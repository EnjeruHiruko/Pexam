package Pexam.textwork;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

class DexFormat {

    static private final String dex2loc = "Pexam/textwork/PTU_dex2_errata_sumo_galar.txt";
    static private final String dex3loc = "Pexam/textwork/PTU_dex3.txt";
    static private final String DELIMITER = "\nHOMELESS\n";

    static private StringBuilder dex3;
    static private Scanner dex2;

    static private Scanner scanLine;

    static String writeDex3() throws FileNotFoundException {

        //initialize
        dex2 = new Scanner(new File(dex2loc)).useLocale(Locale.US);
        dex3 = new StringBuilder();

        double dexNum = 0;
        Scanner entry;

        //temp variables
        String line;
        String[] parts;

        // delimiter between mons and for the first lines of a mon, repeated at the end of the loop
        String stdDelim = "(\\v\\s*)+";
        // delimiter for dex numbers between entries
        String dexnumDelim = "\\v*\\d+\\.\\d+\\v+";
        // delimitier for use inside entries
        String insideDelim = "\\nBase Stats:|\\nBasic Information|\\nEvolution:|\\nSize Information|\\nBreeding Information|\\nCapability List|\\nSkill List|\\nMove List|\\nMega Evolution";

        dex2.useDelimiter(stdDelim);
        try {

            //write
            while (dex2.hasNextDouble()) {

                dexNum = Double.parseDouble( dex2.next().trim() );
                dex3.append(dexNum); // write dexnum
                dex3.append("\n");
                dex3.append( Double.valueOf(dexNum).intValue() ); // write dexnum integer
                dex3.append("\n");
                dex3.append(dex2.next()); // write species name

                dex3.append("\n");

                // set delimiter for acquiring entry
                dex2.useDelimiter(dexnumDelim);
                entry = new Scanner(dex2.next()).useDelimiter(insideDelim);

                dex2.useDelimiter(stdDelim);
                while( !dex2.hasNextDouble() ) { // ff to end of entry
                    dex2.next();
                }
                dex2.next(); // skip closing dexnum

                // no further work on dex2 this cycle. continuing with entry
                entry.next(); // skip an empty newline

                // acquire blocks
                String stats = entry.next();     // System.out.println("\nstats: " + stats);
                String info = entry.next();      // System.out.println("\ninfo: " + info);
                String evo = entry.next();       // System.out.println("\nevo: " + evo);
                String size = entry.next();      // System.out.println("\nsize: " + size);
                String breed = entry.next();     // System.out.println("\nbreed: " + breed);
                String capab = entry.next();     // System.out.println("\ncabab: " + capab);
                String skills = entry.next();    // System.out.println("\nskills: " + skills);
                String moves = entry.next();     // System.out.println("\nmoves: " + moves);

                String mega;
                entry.useDelimiter(stdDelim);
                if( entry.hasNext("Mega") ) {
                    entry.useDelimiter(insideDelim);
                    mega = entry.next();
                } else {
                    entry.useDelimiter(insideDelim);
                    mega = "";
                }

                //TODO fix magmar


                // get basestats:
                Scanner scanStats = new Scanner(stats).useDelimiter("\\n|\\r\\n|: ");

                while (scanStats.hasNext()) {
                    scanStats.next(); // skip stat name
                    dex3.append(scanStats.next());
                    dex3.append(" ");
                }

                cutLast(dex3); // remove last space in stat line
                dex3.append("\n");
                scanStats.close();

                // get info
                Scanner scanInfo = new Scanner(info);
                scanInfo.nextLine(); // skip empty line

                //get type
                line = scanInfo.nextLine();
                Scanner types = new Scanner(line).useDelimiter(": | / ");
                types.next(); // skip "Type "
                while (types.hasNext()) {
                    dex3.append(types.next().toUpperCase());
                    dex3.append(" ");
                }
                cutLast(dex3); // remove last space in types line
                dex3.append("\n");

                //get abilities
                boolean basic = false;
                boolean advanced = false;
                boolean high = false;
                while (scanInfo.hasNextLine()) {
                    line = scanInfo.nextLine();

                    if( !line.matches("(Basic|Adv|High).*") ) {
                        break; // skip other info
                    }

                    if (line.startsWith("Basic Ability") && !basic) {
                        basic = true;
                        dex3.append("BA");
                    } else if (line.startsWith("Adv Ability") && !advanced) {
                        advanced = true;
                        dex3.append("\nAA");
                    } else if (line.startsWith("High Ability") && !high) {
                        high = true;
                        dex3.append("\nHA");
                    }

                    // write ability, with newlines removed and a leading space
                    dex3.append(" ");
                    dex3.append(line.split(": ")[1].replace(" ", "$"));
                }

                dex3.append("\n");
                scanInfo.close();

                //get evolutions
                dex3.append("EV");
                Scanner scanEvo = new Scanner(evo);
                scanEvo.useDelimiter("\\d - ");
                scanEvo.next(); // skip empty line

                while (scanEvo.hasNext()) {

                    line = scanEvo.next();
                    scanLine = new Scanner(line);

                    dex3.append(" ");
                    dex3.append(scanLine.next()); // write evo species

                    if( scanLine.hasNext("Mime|Jr\\.|M|F") ) {
                        dex3.append("$");
                        dex3.append(scanLine.next());
                    }

                    dex3.append("#");

                    if(!scanLine.hasNext()) { // base evo would end here
                        dex3.append(0);
                    }

                    while(scanLine.hasNext()) {

                        if(!scanLine.hasNext("Minimum")) {
                            dex3.append(scanLine.next());
                            if(scanLine.hasNext()) {
                                dex3.append("$");
                            }
                        } else {
                            scanLine.next(); // skip minimum declaration, redundant
                        }

                    }

                    scanLine.close();

                }

                dex3.append("\n");
                scanEvo.close();

                //get size
                String brdDelim = ": | / |%|, | Days"; // delimiter for scanning size and breeding info
                Scanner scanSize = new Scanner(size);
                scanSize.nextLine(); // skip empty line

                while (scanSize.hasNextLine()) {
                    line = scanSize.nextLine();
                    // extract metric units from line
                    dex3.append(line.split(brdDelim + "|m|kg")[2]);
                    dex3.append(" ");
                }

                scanSize.close();

                //get breeding info
                Scanner scanBreed = new Scanner(breed);
                scanBreed.nextLine(); // skip empty line

                // get male ratio
                dex3.append(scanBreed.nextLine().split(brdDelim)[1]);
                dex3.append(" ");

                // get egg group
                parts = scanBreed.nextLine().split(brdDelim);
                for (int i = 1; i < parts.length; i++) {
                    dex3.append(parts[i].replace(" ", "$"));
                    if(i == parts.length-1) {
                        break;
                    }
                    dex3.append("/");
                }
                dex3.append(" ");

                // get hatch days
                if( scanBreed.hasNext("Average") ) { // only first-stage evolutions have their hatch days listed
                    dex3.append(scanBreed.nextLine().split(brdDelim)[1]);
                } else {
                    dex3.append(0);
                }
                dex3.append(" ");

                // get diet && habitat
                while (scanBreed.hasNextLine()) {
                    scanLine = new Scanner(scanBreed.nextLine()).useDelimiter(brdDelim);
                    scanLine.next(); // skip "Diet ", "Habitat"

                    while (scanLine.hasNext()) {
                        dex3.append(scanLine.next());
                        dex3.append("/");
                    }
                    dex3.deleteCharAt(dex3.length() - 1); // remove last slash

                    dex3.append(" ");
                    scanLine.close();
                }

                cutLast(dex3); // remove last space
                dex3.append("\n");
                scanBreed.close();

                //get capabilities
                Scanner scanCap = new Scanner(capab.replaceAll("\\v+", " ").replaceFirst(" ", "")).useDelimiter(", ");
                dex3.append("cl");

                boolean isNaturewalk = false;
                while (scanCap.hasNext()) {
                    line = scanCap.next().trim().replaceFirst(" ", "#").replace(" ", "$");

                    if (isNaturewalk) {
                        dex3.append("/");
                        if (line.endsWith(")")) {
                            isNaturewalk = false;
                        }
                    } else if (line.startsWith("Naturewalk") && !line.endsWith(")") ) {
                        isNaturewalk = true;
                        dex3.append(" ");
                    } else {
                        dex3.append(" ");
                    }

                    dex3.append(line.replaceAll("[()]","")); // remove brackets

                }

                dex3.append("\n");
                scanCap.close();

                //get skills
                Scanner scanSkills = new Scanner(skills.replaceAll("\\v+"," ")).useDelimiter(", *");
                dex3.append("sl");

                while (scanSkills.hasNext()) {
                    parts = scanSkills.next().split(" +|d6\\+|d6");

                    dex3.append(" ");
                    dex3.append(parts[0]); // write capability name

                    for (int i = 1; i < 3; i++) { // write capability dice and bonus
                        dex3.append("#");

                        if(i >= parts.length ) {
                            dex3.append(0);
                        } else {
                            dex3.append(parts[i]);
                        }
                    }
                }

                dex3.append("\n");
                scanSkills.close();

                //get moves
                String moveDelim = "\\v*Level Up Move List\\v*|\\v*TM/HM Move List\\v*|\\v*Egg Move List\\v*|\\v*Tutor Move List\\v*";
                Scanner scanMoves = new Scanner(moves).useDelimiter(moveDelim);

                    //get level-up moves
                writeMoveList(
                        "ml",
                        scanMoves.next(),
                        " - .*\\v*",
                        true
                );

                    //get tm/hm moves
                scanMoves.useDelimiter("\\v+");
                if ( !scanMoves.hasNext("TM/HM Move List") ) {
                    scanMoves.useDelimiter(moveDelim);
                    dex3.append("tml\n");
                } else {
                    scanMoves.useDelimiter(moveDelim);
                    writeMoveList(
                            "tml",
                            scanMoves.next().replaceAll("\\v+", " "),
                            ", ",
                            true
                    );
                }

                    //get eggmoves
                scanMoves.useDelimiter("\\v+");
                if( !scanMoves.hasNext("Egg Move List") ) {
                    scanMoves.useDelimiter(moveDelim);
                    dex3.append("el\n");
                } else {
                    scanMoves.useDelimiter(moveDelim);
                    writeMoveList(
                            "el",
                            scanMoves.next().replaceAll("\\v+", " "),
                            ", ",
                            false
                    );
                }

                    //get tutor moves
                scanMoves.useDelimiter("\\v+");
                if( !scanMoves.hasNext("Tutor Move List") ) {
                    // scanMoves.useDelimiter(moveDelim); // scanner will be closed
                    dex3.append("tl\n");
                } else {
                    scanMoves.useDelimiter(moveDelim);
                    writeMoveList(
                            "tl",
                            scanMoves.next().replaceAll("\\v+", " "),
                            ", ",
                            false
                    );
                }

                scanMoves.close();


                //get mega
                int megas = 0;
                if(mega.equals("")) {
                    dex3.append("mega");
                } else if( mega.startsWith(" X") ) {
                    dex3.append("megaX ");
                    megas = 2;
                } else {
                    dex3.append("mega ");
                    megas = 1;
                }

                while( megas > 0 ) {

                    String megaDelim = "\\nType: |\\nAbility: |\\nStats: ";
                    Scanner scanMega = new Scanner(mega).useDelimiter(megaDelim);
                    scanMega.next(); //skip line

                    //write mega type
                    dex3.append( scanMega.next().replaceAll("-?\\v","") );
                    cutLast(dex3); //remove trailing carriage returns
                    dex3.append(" ");

                    //write mega ability
                    dex3.append( scanMega.next().replaceAll("( |\\v)+", "\\$") );
                    cutLast(dex3); //remove trailing carriage returns
                    dex3.append(" ");

                    //write mega stats;
                    Scanner scanMegaStats = new Scanner(scanMega.next()).useDelimiter(",[ \\v]*");
                    String[] statNames = new String[]{"HP", "Atk", "Def", "Sp\\. Atk", "Sp\\. Def", "Speed"};
                    Scanner scanStat;
                    String stat = scanMegaStats.next();

                    for (String statName: statNames) {

                        if (stat.matches(".*" + statName)) {
                            scanStat = new Scanner(stat);
                            dex3.append( scanStat.nextInt() );
                            scanStat.close();
                            try {
                                stat = scanMegaStats.next();
                            } catch(NoSuchElementException e) {
                                // trailing stats are unchanged
                                stat = "";
                            }
                        } else {
                            dex3.append(0);
                        }

                        dex3.append(" ");
                    }

                    scanMegaStats.close();

                    //remove trailing space
                    cutLast(dex3);

                    if(megas > 1) {
                        mega = entry.next();
                        dex3.append("\nMegaY ");
                    }

                    megas -= 1;

                }

                entry.close();

                //remove trailing vertical space
                cutLast(dex3);

                dex3.append("\n");
                dex3.append(dexNum);
                dex3.append(DELIMITER);


            }

        } catch(NoSuchElementException e) {
            //debugging
            System.out.println(dexNum);
            e.printStackTrace();
        }

        dex2.close();
        return dex3.toString();

    }


    static private void writeMoveList(String movelistname, String movelist, String delim, boolean hasPrefix) {
        dex3.append(movelistname);

        if( movelist.equals("None") ) {
            dex3.append("\n");
            return;
        }

        Scanner subScanMoves = new Scanner(movelist).useDelimiter(delim);

        while(subScanMoves.hasNext()) {
            scanLine = new Scanner(subScanMoves.next());

            dex3.append(" ");

            if(hasPrefix) {
                dex3.append(scanLine.next().replace("A", "-"));
                dex3.append("#");
            }

            dex3.append(scanLine.next());
            while(scanLine.hasNext()) {
                dex3.append("$");
                dex3.append(scanLine.next());
            }

            scanLine.close();
        }

        dex3.append("\n");
        subScanMoves.close();
    }


    /**
     * Removes trailing (vertical) spaces from strb.
     * @param strb The StringBuilder to be cut.
     */
    static private void cutLast(StringBuilder strb) {

        while( String.valueOf( strb.charAt(strb.length()-1) ).matches("\\v|\\s") ) {
            strb.deleteCharAt(strb.length() - 1);
        }

    }

    static public void main(String[] args) throws FileNotFoundException {

        String dex3 = writeDex3();
        if(args.length > 0 && args[0].equals("print") ) {
            System.out.print(dex3);
        }

    }

}
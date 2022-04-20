package Pexam.data.Combatant.Pokemon;

import java.util.Arrays;

/**
 * Represents the nature of a Pokemon.
 */
public enum Nature{
    NON         ("Nix",0, 0, 0, 0, 0, 0),

    //pos Hp
    Cuddly      ("Knuddlig",1, -2, 0, 0, 0, 0),
    Distracted  ("Abgelenkt",1, 0, -2, 0, 0, 0),
    Proud       ("Stolz",1, 0, 0, -2, 0, 0),
    Decisive    ("Entschieden",1, 0, 0, 0, -2, 0),
    Patient     ("Geduldig",1, 0, 0, 0, 0, -2),

    //pos Atk
    Desperate   ("Bemüht",-1, 2, 0, 0, 0, 0),
    Lonely      ("Solo",0, 2, -2, 0, 0, 0),
    Adamant     ("Hart",0, 2, 0, -2, 0, 0),
    Naughty     ("Frech",0, 2, 0, 0, -2, 0),
    Brave       ("Mutig",0, 2, 0, 0, 0, -2),

    //pos Def
    Stark       ("Schroff",-1, 0, 2, 0, 0, 0),
    Bold        ("Kühn",0, -2, 2, 0, 0, 0),
    Impish      ("Pfiffig",0, 0, 2, 2, 0, 0),
    Lax         ("Lasch",0, 0, 2, 0, -2, 0),
    Relaxed     ("Locker",0, 0, 2, 0, 0, -2),

    //pos SpAtk
    Curious     ("Neugierig",-1, 0, 0, 2, 0, 0),
    Modest      ("Mäßig",0, -2, 0, 2, 0, 0),
    Mild        ("Mild",0, 0, -2, 2, 0, 0),
    Rash        ("Hitzig",0, 0, 0, 2, -2, 0),
    Quiet       ("Ruhig",0, 0, 0, 2, 0, -2),

    //pos SpDef
    Dreamy      ("Verträumt",-1, 0, 0, 0, 2, 0),
    Calm        ("Still",0, -2, 0, 0, 2, 0),
    Gentle      ("Zart",0, 0, -2, 0, 2, 0),
    Careful     ("Sacht",0, 0, 0, -2, 2, 0),
    Sassy       ("Forsch",0, 0, 0, 0, 2, -2),

    //pos Spd
    Skittish    ("Sprunghaft",-1, 0, 0, 0, 0, 2),
    Timid       ("Scheu",0, -2, 0, 0, 0, 2),
    Hasty       ("Hastig",0, 0, -2, 0, 0, 2),
    Jolly       ("Froh",-2, 0, 0, -2, 0, 2),
    Naive       ("Naiv",0, 0, 0, 0, -2, 2),

    //neutral
    Composed    ("Beherrscht",0, 0, 0, 0, 0, 0),
    Hardy       ("Robust",0, 0, 0, 0, 0, 0),
    Docile      ("Sanft",0, 0, 0, 0, 0, 0),
    Bashful     ("Zaghaft",0, 0, 0, 0, 0, 0),
    Quirky      ("Kauzig",0, 0, 0, 0, 0, 0),
    Serious     ("Ernst",0, 0, 0, 0, 0, 0);

    
    /** The stat modifiers the nature grants. */
    final private int[] stats_ = new int[6];

    /** The german name of the nature. */
    final private String gerName_;

    /**
     * Generates the natures from their german names and stat modifiers.
     * @param gerName the german name
     * @param stats the stat modifiers
     */
    private Nature(String gerName, int... stats) {

        this.gerName_ = gerName;

        System.arraycopy(stats, 0, this.stats_,0, 6);

    }


    /**
     * Gets the stat modifiers of this.
     * @return the stat modifiers of this
     */
    public int[] getNaturemod() {
        return this.stats_;
    }

    /**
     * Gets the german name of this.
     * @return the german name of this
     */
    public String getGerName_() {
        return this.gerName_;
    }


    /**
     * Retrieves a nature matching a given array of stats.
     * @param stats The stats of the nature to search for
     * @return The corresponding nature
     * @throws Exception if there is no corresponding nature.
     */
    public static Nature fromStats(int... stats) throws Exception {

        for (Nature n : values()) {
            if (Arrays.equals(stats, n.getNaturemod())) {
                return n;
            }
        }

        //TODO nature format mismatch exc
        throw new Exception(String.format("No such Nature: %s", Arrays.toString(stats)));
    }

    /**
     * Gets a nature from two rolls between 1 and 6.
     * @param pos The stat increased by the nature
     * @param neg The stat decreased by the nature
     * @return The corresponding nature
     * @throws ArrayIndexOutOfBoundsException if pos or neg are smaller than 1 or larger than 6.
     */
    public static Nature fromRoll(int pos, int neg) throws ArrayIndexOutOfBoundsException {
        int[] stats = new int[6];

        stats[pos - 1] += 2;
        stats[neg - 1] += -2;
        stats[0] /= 2; //HP are only modified by 1

        Nature nature = null;
        try {
            nature = fromStats(stats);
        } catch (Exception ex) {
        } // syntactically guaranteed to not throw


        if (pos == neg) { // correct neutral natures
            switch (neg) {
                case (1):
                    nature = Composed;
                    break;
                case (2):
                    nature = Hardy;
                    break;
                case (3):
                    nature = Docile;
                    break;
                case (4):
                    nature = Bashful;
                    break;
                case (5):
                    nature = Quirky;
                    break;
                case (6):
                    nature = Serious;
                    break;
            }
        }

        return nature;
    }
}
package Pexam.cute.cuteutility.Database;

import Pexam.cute.cuteutility.config.WorldConfiguration;
import Pexam.data.Abilities.Abilities;
import Pexam.data.Combatant.Pokemon.Species;
import Pexam.data.Moves.Moves;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dex {

    private WorldConfiguration config_;

    private List<Moves> moveList_;

    private List<Abilities> abilityList_;

    private List<Species> pokeDex_;

    public Dex(String worldpath , String in){
        this.config_ = new WorldConfiguration(worldpath);
        this.moveList_ = new ArrayList<>();
        this.abilityList_ = new ArrayList<>();
        this.pokeDex_ = new ArrayList<>();
        createDex(worldpath, in, false);
    }

    public void createDex(String worldpath , String param, boolean print){

        if(param.equalsIgnoreCase("Moves") || param.equalsIgnoreCase("all")) {

            Path file = Paths.get("Pexam/cute/cuteutility/"+worldpath+"/MoveDex.txt");
            int counter = 1;
            try {
                Scanner in = new Scanner(file).useDelimiter("HOMELESS");
                while (in.hasNext()) {
                    //System.out.println(counter);

                    moveList_.add(createMove(in.next()));

                    counter++;
                }
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(print){
                printMoveDex();
            }
        }

        if(param.equalsIgnoreCase("Abilities") || param.equalsIgnoreCase("all")){
            Path file = Paths.get("Pexam/cute/cuteutility/"+worldpath+"/AbilityDex.txt");
            try{
                Scanner in = new Scanner(file).useDelimiter("HOMELESS");
                while(in.hasNext()){
                    abilityList_.add(createAbility(in.next()));
                }
                in.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            if(print){
                printAbilityDex();
            }
        }

        if(param.equalsIgnoreCase("Pokemon") || param.equalsIgnoreCase("all")){
            Path file = Paths.get("Pexam/cute/cuteutility/"+worldpath+"/PokeDex.txt");
            try{
                Scanner in = new Scanner(file).useDelimiter("HOMELESS");
                while(in.hasNext()){
                    pokeDex_.add(createPokemon(in.next()));
                }
                in.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            if(print){
                printPokeDex();
            }
        }
    }

    private Moves createMove(String in){
        String[] mem = in.split("\\R+");
        /*
        for (String s : mem) {
            s.replaceAll("\\R+", "");
        }
        */

        //System.out.println(Arrays.toString(mem));
        return new Moves(mem);
    }

    private Abilities createAbility(String in){
        String[] mem = in.split("\\R+");
        //System.out.println(Arrays.toString(mem));
        return new Abilities(mem);
    }

    private Species createPokemon(String in){
        return new Species(in);
    }

    public void printMoveDex(){
        for (Moves moves : this.moveList_) {
            System.out.println(moves);
        }
    }

    public void controlPrintMoveDex(){
        Path dispatch = Paths.get("Pexam/cute/cuteutility/ver105_5/control_print.txt");
        String result = "";
        for(Moves moves : this.moveList_){
            result += moves.toString();
            result += "\n";
        }

        try{
            BufferedWriter writer = Files.newBufferedWriter(dispatch);
            writer.write(result);
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }


    }

    public Moves searchMoveDex(String in){
        int temp = this.moveList_.indexOf(new Moves(in));
        return this.moveList_.get(temp);
    }

    public boolean MoveDexContains(String in){
        return this.moveList_.contains(new Moves(in));
    }

    private void printAbilityDex(){
        for(Abilities abilities : this.abilityList_){
            System.out.println(abilities);
        }
    }

    private void printPokeDex(){
        for(Species pokemon : this.pokeDex_){
            System.out.println(pokemon);
        }
    }

    public void showcasePokeDex(){
        for(Species pokemon : this.pokeDex_){
            System.out.println(pokemon.showcase());
        }
    }

    public Species searchPokemonString(String in){
        if(this.pokeDex_.contains(new Species(in,in))){
            return pokeDex_.get(pokeDex_.indexOf(new Species(in,in)));
        }else{
            return new Species();
        }
    }

    public Species searchPokemonIndex(int in){
        if(in < this.pokeDex_.size()){
            return pokeDex_.get(in);
        }else{
            return new Species();
        }
    }

    public Species searchPokemonDexNumber(int in){
        return pokeDex_.get(pokeDex_.indexOf(in));
    }

    public String DexSize(String in){
        String temp = "";
        if(in.equalsIgnoreCase("Moves")|| in.equalsIgnoreCase("all")){
            temp += "MoveDexSize= "+ this.moveList_.size() +" ";
        }
        if(in.equalsIgnoreCase("Abilities")|| in.equalsIgnoreCase("all")){
            temp += "AbilityDexSize= " + this.abilityList_.size() + " ";
        }
        if(in.equalsIgnoreCase("Pokemon")|| in.equalsIgnoreCase("all")){
            temp += "PokeDexSize= "+ this.pokeDex_.size()+ " ";
        }
        return temp;
    }

    public void updateDex(){
        for(int c = 0; c < pokeDex_.size(); c++){
            Species mem = pokeDex_.get(c);
            //printAbilityDex();
            //System.out.println(mem.getMovelist());

            //Moves temp = new Moves(mem.getMovelist().get(0).getMove().getName(), this.moveList_);
            //System.out.println(temp);




            for(int z = 0; z < mem.getMovelist().size(); z++){
                try {

                    Moves temp = new Moves(mem.getMovelist().get(z).getMove().getName(), this.moveList_);
                    mem.getMovelist().get(z).setMove(temp);
                    //System.out.println(temp);
                }catch(Exception e){
                    e.printStackTrace();
                    System.out.println(c + "   "+ z + "  movelist");
                    System.out.println(mem.getMovelist());
                }
            }

            for(int z = 0; z < this.pokeDex_.get(c).getTmlist().size(); z++){
                try {

                    Moves temp = new Moves(mem.getTmlist().get(z).getMove().getName(), this.moveList_);
                    mem.getTmlist().get(z).setMove(temp);
                    //System.out.println(temp);
                }catch(Exception e){
                    e.printStackTrace();
                    System.out.println(c + "   "+ z+ "  tmlist");
                    System.out.println(mem.getTmlist());
                }
            }

            for(int z = 0; z < this.pokeDex_.get(c).getTutorlist().size(); z++){
                try {

                    Moves temp = new Moves(mem.getTutorlist().get(z).getName(), this.moveList_);
                    mem.getTutorlist().set(z, temp);
                    //System.out.println(temp);
                }catch(Exception e){
                    e.printStackTrace();
                    System.out.println(c + "   "+ z+ "  tutorlist");
                    System.out.println(mem.getTutorlist());
                }
            }
            for(int z = 0; z < this.pokeDex_.get(c).getEgglist().size(); z++){
                try {

                    Moves temp = new Moves(mem.getEgglist().get(z).getName(), this.moveList_);
                    mem.getEgglist().set(z, temp);
                    //System.out.println(temp);
                }catch(Exception e){
                    e.printStackTrace();
                    System.out.println(c + "   "+ z + "  egglist");
                    System.out.println(mem.getEgglist());
                }
            }

            for(int z = 0; z < this.pokeDex_.get(c).getBasicAbilities().size(); z++){
                try {
                    //System.out.println(c+"_" + mem.getBasicAbilities().get(z).getName() + "_"+z);
                    Abilities temp = new Abilities(mem.getBasicAbilities().get(z).getName(), this.abilityList_);
                    //System.out.println(temp);
                    mem.getBasicAbilities().set(z, temp);
                }catch(Exception e){
                    e.printStackTrace();
                    System.out.println(c + "   "+ z + "  BasicAbilities");
                    System.out.println(mem.getBasicAbilities());
                }
            }

            for(int z = 0; z < this.pokeDex_.get(c).getAdvAbilities().size(); z++){
                try {
                    Abilities temp = new Abilities(mem.getAdvAbilities().get(z).getName(), this.abilityList_);
                    mem.getAdvAbilities().set(z, temp);
                }catch(Exception e){
                    e.printStackTrace();
                    System.out.println(c + "   "+ z + "  AdvAbilities");
                    System.out.println(mem.getAdvAbilities());
                }
            }
            for(int z = 0; z < this.pokeDex_.get(c).getHighability().size(); z++){
                try {
                    Abilities temp = new Abilities(mem.getHighability().get(z).getName(), this.abilityList_);
                    mem.getHighability().set(z, temp);
                }catch(Exception e){
                    e.printStackTrace();
                    System.out.println(c + "   "+ z + "  HighAbilities");
                    System.out.println(mem.getHighability());
                }
            }

            this.pokeDex_.set(c, mem);
        }
    }



}
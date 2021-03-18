package Pexam.cute.cuteutility.Database;

import Pexam.cute.cuteutility.config.WorldConfiguration;
import Pexam.data.Abilities.Abilities;
import Pexam.data.Moves.Moves;
import Pexam.data.Pokemon.Species;

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
        createDex(worldpath, in);
    }

    public void createDex(String worldpath , String param){

        if(param.equalsIgnoreCase("Moves") || param.equalsIgnoreCase("all")) {

            Path file = Paths.get("Pexam/cute/cuteutility/"+worldpath+"/MoveDex.txt");
            int counter = 1;
            try {
                Scanner in = new Scanner(file).useDelimiter("HOMELESS");
                while (in.hasNext()) {
                    System.out.println(counter);
                    moveList_.add(createMove(in.next()));
                    counter++;
                }
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            printMoveDex();
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
            printAbilityDex();
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
            printPokeDex();
        }
    }

    private Moves createMove(String in){
        String[] mem = in.split("\\R");
        //System.out.println(Arrays.toString(mem));
        return new Moves(mem);
    }

    private Abilities createAbility(String in){
        String[] mem = in.split("\\R");
        //System.out.println(Arrays.toString(mem));
        return new Abilities(mem);
    }

    private Species createPokemon(String in){
        return new Species(in);
    }

    private void printMoveDex(){
        for (Moves moves : this.moveList_) {
            System.out.println(moves);
        }
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

}
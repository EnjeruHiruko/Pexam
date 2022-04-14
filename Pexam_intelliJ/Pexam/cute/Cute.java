package Pexam.cute;


import Pexam.cute.cuteutility.Database.Dex;
import Pexam.data.Combatant.Pokemon.PokemonBETA;
import Pexam.data.Combatant.Pokemon.Species;

import java.util.ArrayList;
import java.util.List;

public class Cute{

    private final String standardWorld;

    private Dex database_;

    private List<PokemonBETA> pokemon_;


    public Cute(){
        this.standardWorld = "ver105_5";
        this.database_ = new Dex(standardWorld, "All");
        this.pokemon_ = new ArrayList<PokemonBETA>();
        updateDex();
    }

    public Cute(String path){
        this.standardWorld = "ver105_5";
        try {
            this.database_ = new Dex(path, "All");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("there is no such World saved");
        }
        this.pokemon_ = new ArrayList<PokemonBETA>();
        updateDex();
    }

    public Species searchPokeDexString(String in){
        return this.database_.searchPokemonString(in);
    }

    public Species searchPokeDexIndex(int in){
        return this.database_.searchPokemonIndex(in);
    }

    public String DexSizes(String in){
        return database_.DexSize(in);
    }

    public void PokeDexshowcase(){
        database_.showcasePokeDex();
    }

    public void updateDex(){
        this.database_.updateDex();
    }

    public void printMoveDex(){
        database_.printMoveDex();
    }

    public void controlPrint(){
        database_.controlPrintMoveDex();
    }

    // methods for UI

    public void createTrainerPokemon(String in){
        Species temp = searchPokeDexString(in);
        pokemon_.add(new PokemonBETA(temp.getSpecies(), temp));
    }

}
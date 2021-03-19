package Pexam.cute;


import Pexam.cute.cuteutility.Database.Dex;
import Pexam.data.Combatant.Pokemon.Pokemon;
import Pexam.data.Combatant.Pokemon.Species;

import java.util.ArrayList;
import java.util.List;

public class Cute{

    private final String standardWorld;

    private Dex database_;

    private List<Pokemon> pokemon_;


    public Cute(){
        this.standardWorld = "ver105_5";
        this.database_ = new Dex(standardWorld, "All");
        this.pokemon_ = new ArrayList<Pokemon>();
    }

    public Cute(String path){
        this.standardWorld = "ver105_5";
        try {
            this.database_ = new Dex(path, "All");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("there is no such World saved");
        }
        this.pokemon_ = new ArrayList<Pokemon>();
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







    public static void main(String[] args){
        Cute test = new Cute();
        System.out.println(test.DexSizes("all"));
        System.out.println(test.searchPokeDexIndex(763));
        //test.PokeDexshowcase();
        //System.out.printf(test.toString());
    }

}
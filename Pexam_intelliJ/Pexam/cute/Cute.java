package Pexam.cute;


import Pexam.cute.cuteutility.Database.Dex;
import Pexam.data.Pokemon.Species;

public class Cute{

    private final String standardWorld;

    private Dex database_;


    public Cute(){
        this.standardWorld = "ver105_5";
        this.database_ = new Dex(standardWorld, "All");
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
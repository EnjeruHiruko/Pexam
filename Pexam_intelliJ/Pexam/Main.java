package Pexam;

import Pexam.cute.Cute;
import Pexam.data.Combatant.Pokemon.Nature;
import Pexam.data.Combatant.Pokemon.PokemonBETA;

public class Main{
    public static void main(String[] args){
        Cute run = new Cute();
        //System.out.println(run.searchPokeDexIndex(0));
        //run.controlPrint();
        PokemonBETA test = new PokemonBETA("subject0", run.searchPokeDexString("Dialga"));
        test.LevelGain(100);

        test.learnMove_Levelup("Roar of Time", 0);
        test.learnMove_Levelup("Metal Claw", 1);
        test.update_Nature(Nature.Bold);
        test.PokePrinter();

    }


}

/*
manual calculations:


*/
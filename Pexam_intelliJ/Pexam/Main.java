package Pexam;

import Pexam.cute.Cute;
import Pexam.data.Combatant.Pokemon.Nature;
import Pexam.data.Combatant.Pokemon.PokemonBETA;

import java.io.File;

public class Main {
    public static void main(String[] args){
        /*
        File test1 = new File("/Pexam/Pexam_intelliJ/Pexam/cute/cuteutility/versions/105_5/PokeDex.txt");
        System.out.println(test1.exists());
        */
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
/*
todo: Main -> calling UI and backend
    : 2 threads
    : Handler for Interaction between threads
    : UI-class
    : Cute -> standalone runnable
 */


}

/*
manual calculations:


*/
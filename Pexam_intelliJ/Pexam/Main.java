package Pexam;

import Pexam.cute.Cute;
import Pexam.data.Combatant.Pokemon.Nature;
import Pexam.data.Combatant.Pokemon.PokemonBETA;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    public static void main(String[] args){
        //launch(args);

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
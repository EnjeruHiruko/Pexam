package Pexam.cute;


import Pexam.cute.cuteutility.Database.Dex;
import Pexam.data.Combatant.Pokemon.PokemonBETA;
import Pexam.data.Combatant.Pokemon.Species;
import Pexam.data.Combatant.Trainer.Trainer;
import Pexam.data.Moves.Moves;

import java.util.ArrayList;
import java.util.List;

public class Cute{

    private final String standardWorld;

    private Dex database_;

    private boolean dex_is_changed_;


    private ArrayList<Trainer> all_trainer_;

    private Trainer selected_trainer_;



    public Cute(){
        this.standardWorld = "105_5";
        this.database_ = new Dex(standardWorld, "All");
        this.all_trainer_ = new ArrayList<>();
        this.selected_trainer_ = new Trainer();
        this.dex_is_changed_ = false;
        //updateDex();
    }

    public Cute(String path){
        this();
        try {
            this.database_ = new Dex(path, "All");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("there is no such World saved");
        }
        //updateDex();
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

    public ArrayList<Species> getPokemonPreview(){
        return database_.getpPreview();
    }

    public ArrayList<Moves> getMovesPreview(){
        return database_.getmPreview();
    }

    public void new_Trainer(String name){
        this.all_trainer_.add(new Trainer(name));
        change_selected_Trainer(name);
    }

    public ArrayList<Trainer> getAll_trainer(){
        return this.all_trainer_;
    }
    public Trainer getSelected_trainer(){
        return selected_trainer_;
    }

    public void change_selected_Trainer(String in){//todo check if input trainer does exist
        this.selected_trainer_ = all_trainer_.get(all_trainer_.indexOf(new Trainer(in)));
    }



}
package Pexam.cute;


import Pexam.cute.cuteutility.Database.Dex;
import Pexam.data.Combatant.Pokemon.Pokemon;
import Pexam.data.Combatant.Pokemon.Species;
import Pexam.data.Combatant.Trainer.Trainer;
import Pexam.data.Moves.Moves;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Cute{

    private final String standardWorld;

    private String currentWorld_;

    private Dex database_;

    private boolean dex_is_changed_;


    private ArrayList<Trainer> all_trainer_;

    private Trainer selected_trainer_;

    private Pokemon selected_Pokemon_;



    public Cute(){
        this.standardWorld = "105_5";
        this.currentWorld_ = "105_5";
        this.database_ = new Dex(standardWorld, "All");
        this.all_trainer_ = new ArrayList<>();
        this.selected_trainer_ = new Trainer();
        this.dex_is_changed_ = false;
        //updateDex();
    }

    public Cute(String path){
        this();
        this.currentWorld_ =path.trim();
        try {
            this.database_ = new Dex(currentWorld_, "All");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("there is no such World saved");
        }
        //updateDex();
    }

    private void load_Trainer(String path){
        Path file = Paths.get("../Pexam/Pexam_intelliJ/Pexam/cute/cuteutility/versions/"+path+"/teams.txt");
        try{
            Scanner in = new Scanner(file).useDelimiter("HOMELESS");
            while(in.hasNext()){
                all_trainer_.add(new Trainer(in.next(), this.database_));
            }
            in.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void load_trainer_fromWorld(){
        load_Trainer(currentWorld_);
    }

    public void save_World(){
        if(this.dex_is_changed_){
            if(this.currentWorld_.contentEquals(this.standardWorld)){

            }
        }else{

        }
    }

    private void new_World(String in){
        try {
            Files.createDirectories(Paths.get("../Pexam/Pexam_intelliJ/Pexam/cute/cuteutility/versions/" + in));

        }catch(Exception e){
            e.printStackTrace();
        }
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

    public void change_selected_Pokemon_fromTeam(String in){
        this.selected_Pokemon_ = selected_trainer_.getTeam().get(selected_trainer_.getTeam().indexOf(new Pokemon(in)));
    }

    public void change_selected_Pokemon_fromBox(String in){
        this.selected_Pokemon_ = selected_trainer_.getBox().get(selected_trainer_.getBox().indexOf(new Pokemon(in)));

    }

}
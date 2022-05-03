package Pexam.data.Combatant.Trainer;

import Pexam.cute.cuteutility.Database.Dex;
import Pexam.data.Combatant.Combatant;
import Pexam.data.Combatant.Pokemon.Pokemon;
import Pexam.data.Combatant.Pokemon.Species;
import Pexam.data.utility.Enums.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Trainer extends Combatant {

    private int level_;

    private int exp_;

    private ArrayList<Pokemon> team_;

    private ArrayList<Pokemon> box_;

    public Trainer(){
        super();
        this.level_ = 1;
        this.exp_ = 0;
        this.team_ = new ArrayList<>();
        this.box_ = new ArrayList<>();
        this.types_.add(Type.TYPELESS);
        this.statBlock_.update_BaseStats(new int[]{10,5,5,5,5,5}); //todo use config-values
        this.statBlock_.updateBaseRelationStatus(false);
    }
    public Trainer(String name){
        this();
        this.name_ = name;
    }

    /**
     * Constructor for Loading saved Trainers from File
     *
     * @param in String input from read file which differs from the above version
     * @param database reference to database for reading species of own pokemon
     */
    public Trainer(String in, Dex database){
        this();
        try {
            Scanner read = new Scanner(in).useDelimiter("EVERYDAY");
            this.l_tr(read.next());
            this.l_t(read.next());
            this.l_b(read.next());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /*
    Save Trainer as: combatant -> trainer
    _tr "Name" "lvl as Int" "EXP as Int" "Gender" "Stat-Point Distribution as Array" "Skills as Array" "Abilities as Array" "Moves as Array" "Non-Standard Capabilities as Array"
    -t "Nickname" "Species" "Gender" "Level" "EXP" "Abilities as Array" "Nature" "Stat-Point distribution as Array" "Used Vitamins as Int" "Bonus-Stats from Vitamins as Array" "Used TutorPoints as Int" "Bought PokeEdges as Array" "Selected Moves as Array"
    -b "Nickname" "Species" "Gender" "Level" "EXP" "Held Item" "Abilities as Array" "Nature" "Stat-Point distribution as Array" "Used Vitamins as Int" "Bonus-Stats from Vitamins as Array" "Used TutorPoints as Int" "Bought PokeEdges as Array" "Selected Moves as Array"
     */

    private void l_tr(String in){

    }

    private void l_t(String in){

    }

    private void l_b(String in){

    }

    public String[] save_Trainer(){
        String s = " ";
        String[] value = new String[3];
        value[0] = "_tr " + this.getName() + s +  this.level_ + s + this.exp_ + s + this.gender_ + s + Arrays.toString(this.statBlock_.getUsed_SkillPoints()) + s;
        value[0] += this.skills_.toString() + s + this.abilities_.toString() + s + this.moves_.toString() + s + this.capabilities_.toString() + "\n";

        for(Pokemon temp: this.team_){
            value[1] += temp.toSave();
        }

        for(Pokemon temp: this.box_){
            value[2] += temp.toSave();
        }

        return value;
    }

    public void addPokemon_toTeam(String name, Species species){
        team_.add(new Pokemon(name, species));
    }

    public ArrayList<Pokemon> getTeam(){
        return this.team_;
    }

    public void addPokemon_toBox(String name, Species species){
        box_.add(new Pokemon(name, species));
    }

    public ArrayList<Pokemon> getBox(){
        return this.box_;
    }

    public String getName(){
        return this.name_;
    }


    @Override
    public boolean equals(Object other){
        if(other instanceof Trainer){
            if(this.name_.equals(((Trainer) other).getName())){
                return true;
            }
        }
        if(other instanceof String){
            return this.name_.equals(other);
        }

        return false;
    }

}
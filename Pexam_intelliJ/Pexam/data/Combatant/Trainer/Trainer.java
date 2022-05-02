package Pexam.data.Combatant.Trainer;

import Pexam.data.Capabilities.Capabilities;
import Pexam.data.Combatant.Combatant;
import Pexam.data.Combatant.Pokemon.PokemonBETA;
import Pexam.data.Combatant.Pokemon.Species;
import Pexam.data.utility.Describtions.Skill;
import Pexam.data.utility.Enums.Type;

import java.util.ArrayList;

public class Trainer extends Combatant {

    private ArrayList<PokemonBETA> team_;

    private ArrayList<PokemonBETA> box_;

    public Trainer(){
        super();
        this.team_ = new ArrayList<>();
        this.box_ = new ArrayList<>();
    }
    public Trainer(String name){
        this();
        this.name_ = name;
        this.types_.add(Type.TYPELESS);
        this.statBlock_.update_BaseStats(new int[]{10,5,5,5,5,5});
    }

    public void addPokemon_toTeam(String name, Species species){
        team_.add(new PokemonBETA(name, species));
    }

    public ArrayList<PokemonBETA> getTeam(){
        return this.team_;
    }

    public void addPokemon_toBox(String name, Species species){
        box_.add(new PokemonBETA(name, species));
    }

    public ArrayList<PokemonBETA> getBox(){
        return this.box_;
    }

    public String getName(){
        return this.name_;
    }

    @Override
    public boolean equals(Object other){
        if(other instanceof Trainer){
            if(this.name_.equalsIgnoreCase(((Trainer) other).getName())){
                return true;
            }
        }
        if(other instanceof String){
            return this.name_.equalsIgnoreCase((String) other);
        }

        return false;
    }

}
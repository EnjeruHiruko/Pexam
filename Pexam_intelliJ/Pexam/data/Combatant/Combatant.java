package Pexam.data.Combatant;

import Pexam.data.Abilities.Abilities;
import Pexam.data.Capabilities.Capabilities;
import Pexam.data.Effects.Effect;
import Pexam.data.Moves.Moves;
import Pexam.data.Statblock.StatBlock;
import Pexam.data.utility.Damage.Damage;
import Pexam.data.utility.Damage.DamageClass;
import Pexam.data.utility.Describtions.Gender;
import Pexam.data.utility.Describtions.Skill;
import Pexam.data.utility.Enums.Type;

import java.util.ArrayList;
import java.util.List;

public class Combatant {

    protected String name_;

    protected List types_;

    protected StatBlock statBlock_;

    protected List<Effect> statics_;

    protected List<Effect> temporary_;

    protected List<Moves> moves_;

    protected Gender gender_;

    protected List<Abilities> abilities_;

    protected List skills_;

    protected List<Capabilities> capabilities_;

    protected String notes_;

    // Methods

    public Combatant(){
        this.name_ = "";
        this.skills_ = new ArrayList<Skill>();
        this.statBlock_ = new StatBlock(new int[6]);
        this.statics_ = new ArrayList<Effect>();
        this.temporary_ = new ArrayList<Effect>();
        this.types_ = new ArrayList<Type>();
        this.moves_ = new ArrayList<Moves>();
        this.gender_ = Gender.all;
        this.abilities_ = new ArrayList<Abilities>();
        this.capabilities_ = new ArrayList<Capabilities>();
        this.notes_ = "";
    }

    public Combatant(String name, int[] basestats, List<Type> types, List<Skill> skills, List<Capabilities> capabilities){
        this();
        this.name_ = name;
        this.statBlock_.update_BaseStats(basestats);
        this.types_ = types;
        this.skills_ = skills;
        this.capabilities_ = capabilities;
    }

    public Damage AttackWithMove(String name, int DiceRole, boolean useAverage, boolean crit, boolean effectActivation){
        if(moves_.contains(new Moves(name))){
            Damage temp = moves_.get(moves_.indexOf(new Moves(name))).calcDamageOutput(
                    this.statBlock_, this.types_, DiceRole, useAverage, crit);
            System.out.printf("%n"+this.name_+" will Attack with "+ temp.getMoveName()+" and will deal "+temp.getValue()+" "
                    +temp.getDamageClass()+" Damage%n");
            return temp;
        }else{
            System.out.printf("%n"+this.name_ + " will Attack with nothing%n" );
            return new Damage();
        }
    }

    public void resolveIncomingDamage(Damage in){
        int actualDamage = 0;
        double temp;
        if(in.getDamageClass() == DamageClass.PHYSICAL){
            actualDamage = in.getValue() - this.statBlock_.getCombatDefense();
            temp = actualDamage * TypeDamageMod(in.getType());
            System.out.println(TypeDamageMod(in.getType()));
            actualDamage = (int) temp;
            System.out.printf("%n"+this.name_ + " took after a Defense of " + this.statBlock_.getCombatDefense()
                    + " and an Type mod from " + in.getType() + " of " + TypeDamageMod(in.getType()) + ", "+ actualDamage + " "
                    + in.getDamageClass() + "-Damage");
            this.statBlock_.update_Damage(actualDamage);
        }else if(in.getDamageClass() == DamageClass.SPECIAL){
            actualDamage = in.getValue() - this.statBlock_.getCombatSpecialDefense();
            temp = actualDamage * TypeDamageMod(in.getType());
            actualDamage = (int) temp;
            System.out.printf("%n"+this.name_ + " took after a Special-Defense of " + this.statBlock_.getCombatSpecialDefense()
                    + " and an Type mod from " + in.getType() + " of " + TypeDamageMod(in.getType()) + ", "+ actualDamage + " "
                    + in.getDamageClass() + "-Damage");
            this.statBlock_.update_Damage(actualDamage);
        }else if(in.getDamageClass() == DamageClass.STATUS){
            System.out.println("StatusMove kekW");
        }
    }

    private double TypeDamageMod(Type in){
        /* todo rework since Type-enum got changed
        int value = 0;
        for (Type type : this.types_) {
            if (in.getRelation()[type.getRank()] == -1) {
                value = -1;
                break;
            } else {
                value += in.getRelation()[type.getRank()];
            }
        }
        switch (value){
            case -1: return 0;
            case 0 : return 1;
            case 1 : return 1.5;
            case 2 : return 2;
            case 3 : return 3;
            case 9 : return 0.5;
            case 10 : return 1;
            case 18 : return 0.25;
            case 19 : return 0.5;
            case 27 : return 0.125;
        }

         */
        return 1;


    }

    public void learnMove(Moves in){
        this.moves_.add(in);
    }

    public String toString(){
        String result = "";

        return result;
    }


}
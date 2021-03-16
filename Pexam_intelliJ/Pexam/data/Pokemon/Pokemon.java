package Pexam.data.Pokemon;

import Pexam.data.Abilities.Abilities;
import Pexam.data.Capabilities.Capabilities;
import Pexam.data.Effects.Effect;
import Pexam.data.Items.Items;
import Pexam.data.Moves.MoveForList;
import Pexam.data.Moves.Moves;
import Pexam.data.Moves.MovesCompare;
import Pexam.data.Statblock.StatBlock;
import Pexam.data.utility.Damage.Damage;
import Pexam.data.utility.Damage.DamageClass;
import Pexam.data.utility.Describtions.Gender;
import Pexam.data.utility.Describtions.Skill;
import Pexam.data.utility.Describtions.Tutor;
import Pexam.data.utility.Enums.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pokemon {

    private String nickname_;

    private Species species_;

    private int level_;

    private int exp_;

    private Items heldItem_;

    private int loyalty_;

    private Gender gender_;

    private Nature nature_;

    private List<Abilities> abilities_;

    private List<Capabilities> capabilities_;

    private Skill[] skills_;

    // StatBlock

    private StatBlock statBlock_;

    //

    private int injuries_;

    private int mTTp_;

    private int uTTp_;

    private int usedVitamins_;

    private List<Tutor> edges_;

    private List<Moves> base6_;

    private List<Moves> bonus3_;

    private List<Moves> connections_;

    private String notes_;

    // memory

    private List<Moves> learnable_;

    private int lastLevelUpdated_;

    private List<Effect> statics_;

    private List<Effect> temporary_;

    //Constructor and creation block

    public Pokemon(){
        this.nickname_ = "";
        this.species_ = new Species();
        this.level_ = 1;
        this.exp_ = 0;
        this.heldItem_ = new Items();
        this.loyalty_ = 2;
        this.gender_ = Gender.all;
        this.nature_ = Nature.NON;
        this.abilities_ = new ArrayList<Abilities>();
        this.capabilities_ = new ArrayList<Capabilities>();
        this.skills_ = new Skill[6];
        this.statBlock_ = new StatBlock(true, false, false, false,1 , new boolean[6], new int[6], new int[6], new int[6], new int[6], new int[6]);
        this.injuries_ = 0;
        this.mTTp_ = 0;
        this.uTTp_ = 0;
        this.usedVitamins_ = 0;
        this.edges_ = null;
        this.base6_ = new ArrayList<Moves>();
        this.bonus3_ = new ArrayList<Moves>();
        this.connections_ = new ArrayList<Moves>();
        this.notes_ = "";
    }


    public Pokemon(Species species){
        this.nickname_ = "";
        this.species_ = species;
        this.level_ = 1;
        this.exp_ = 0;
        this.heldItem_ = new Items();
        this.loyalty_ = 2;
        this.gender_ = Gender.all;
        this.nature_ = Nature.NON;
        this.abilities_ = new ArrayList<Abilities>();
        this.capabilities_ = new ArrayList<Capabilities>();
        this.skills_ = species.getSkills();
        this.statBlock_ = new StatBlock(true, false, false, false, 1, new boolean[6], species.getBasestats(), new int[6], new int[6], new int[6], new int[6]);
        this.injuries_ = 0;
        this.mTTp_ = 0;
        this.uTTp_ = 0;
        this.usedVitamins_ = 0;
        this.edges_ = new ArrayList<Tutor>();
        this.base6_ = new ArrayList<Moves>();
        this.bonus3_ = new ArrayList<Moves>();
        this.connections_ = new ArrayList<Moves>();
        this.notes_ = "";
        this.learnable_ = new ArrayList<Moves>();
    }

    // update block

    public void update_StatsBlock(){
        this.statBlock_.update();
    }

    public void update_Stats(int index, int value){
        this.statBlock_.addSkillPoint(index, value);
    }

    public void update_Nature(Nature newnature){
        this.nature_ = newnature;
        statBlock_.update_Nature(newnature.getNaturemod());
    }

    //Customize Block

    public void name_change(String newname){
        this.nickname_ = newname;
    }

    public void genderBender(Gender newgender){
        this.gender_ = newgender;
    }

    public void LevelGain(int amount){
        this.level_ += amount;
        if(this.level_ >= 100){
            this.level_ = 100;
        }
        statBlock_.update_level(this.level_);
        updateTutorPoints();
        learnableMoves();
    }

    public void learnMove(String name, int slot, int list){
        if(!moveAlreadyLearned(name)) {
            if (onLearnableList(name) || list == 1) {
                System.out.println("levelup");
                if (MoveSlotOpen()) {
                    this.base6_.add(learnable_.get(learnable_.indexOf(new Moves(name))));
                    this.learnable_.remove(new Moves(name));
                } else if (!MoveSlotOpen()) {
                    this.base6_.set(slot, this.learnable_.get(this.learnable_.indexOf(new Moves(name))));
                    this.learnable_.remove(new Moves(name));
                }

            } else if (onTmList(name) || list == 2) {
                System.out.println("tm");
                if(!moveAlreadyLearned(name)) {
                    if (MoveSlotOpen()) {
                        if (TmSlotOpen()) {
                            if (remainingTutorPoints() > 0) {
                                this.bonus3_.add(this.species_.getTmlist().get(this.species_.getTmlist().indexOf(new MoveForList(name))).getMove());
                                uTTp_ += 1;

                            } else {
                                System.out.println("Couldn't learn Move, not enough TutorPoints remaining");
                            }
                        }else if (!TmSlotOpen()) {
                            this.bonus3_.set(slot, this.species_.getTmlist().get(this.species_.getTmlist().indexOf(new MoveForList(name))).getMove());
                        }
                    } else {
                        if (TmSlotOpen()) {
                            if (remainingTutorPoints() > 0) {
                                this.bonus3_.add(this.species_.getTmlist().get(this.species_.getTmlist().indexOf(new MoveForList(0, new Moves(name)))).getMove());
                                uTTp_ += 1;
                                this.base6_.remove(slot);
                            } else {
                                System.out.println("Couldn't learn Move, not enough TutorPoints remaining");
                            }
                        }else if (!TmSlotOpen()) {
                            this.bonus3_.set(slot, this.species_.getTmlist().get(this.species_.getTmlist().indexOf(new MoveForList(0, new Moves(name)))).getMove());
                        }
                    }
                }
                naturalMove();
            } else if (onEggList(name) || list == 3) {
                System.out.println("Egg");
                if(!moveAlreadyLearned(name)) {
                    if (MoveSlotOpen()) {
                        if (TmSlotOpen()) {
                            if (remainingTutorPoints() > 1) {
                                this.bonus3_.add(this.species_.getEgglist().get(this.species_.getEgglist().indexOf(new Moves(name))));
                                uTTp_ += 2;

                            } else {
                                System.out.println("Couldn't learn Move, not enough TutorPoints remaining");
                            }
                        }else if (!TmSlotOpen()) {
                            this.bonus3_.set(slot, this.species_.getEgglist().get(this.species_.getEgglist().indexOf(new Moves(name))));
                        }
                    } else {
                        if (TmSlotOpen()) {
                            if (remainingTutorPoints() > 1) {
                                this.bonus3_.add(this.species_.getEgglist().get(this.species_.getEgglist().indexOf(new Moves(name))));
                                uTTp_ += 2;
                                this.base6_.remove(slot);
                            } else {
                                System.out.println("Couldn't learn Move, not enough TutorPoints remaining");
                            }
                        }else if (!TmSlotOpen()) {
                            this.bonus3_.set(slot, this.species_.getEgglist().get(this.species_.getEgglist().indexOf(new Moves(name))));
                        }
                    }
                }
                naturalMove();
            } else if (onTutorList(name) || list == 4) {
                System.out.println("tutor");
                if(!moveAlreadyLearned(name)) {
                    if (MoveSlotOpen()) {
                        if (TmSlotOpen()) {
                            if (remainingTutorPoints() > 1) {
                                this.bonus3_.add(this.species_.getTutorlist().get(this.species_.getTutorlist().indexOf(new Moves(name))));
                                uTTp_ += 2;
                            } else {
                                System.out.println("Couldn't learn Move, not enough TutorPoints remaining");
                            }
                        }else if (!TmSlotOpen()) {
                            this.bonus3_.set(slot, this.species_.getTutorlist().get(this.species_.getTutorlist().indexOf(new Moves(name))));
                        }
                    } else {
                        if (TmSlotOpen()) {
                            if (remainingTutorPoints() > 1) {
                                this.bonus3_.add(this.species_.getTutorlist().get(this.species_.getTutorlist().indexOf(new Moves(name))));
                                uTTp_ += 2;
                                this.base6_.remove(slot);
                            } else {
                                System.out.println("Couldn't learn Move, not enough TutorPoints remaining");
                            }
                        }else if (!TmSlotOpen()) {
                            this.bonus3_.set(slot, this.species_.getTutorlist().get(this.species_.getTutorlist().indexOf(new Moves(name))));
                            uTTp_ += 2;
                        }
                    }
                }
                naturalMove();
            } else {
                System.out.println("Move not learnable");
                // we always expect perfect input anyway
            }
        }
    }

    private boolean onLearnableList(String name){
        if(this.learnable_.contains(new Moves(name))){
            return true;
        }else{
            return false;
        }
    }

    private boolean onTmList(String name){
        if(this.species_.getTmlist().contains(new MoveForList(0, new Moves(name)))){
            return true;
        }else{
            return false;
        }
    }

    private boolean onEggList(String name){
        if(this.species_.getEgglist().contains(new Moves(name))){
            return true;
        }else{
            return false;
        }
    }

    private boolean onTutorList(String name){
        if(this.species_.getTutorlist().contains(new Moves(name))){
            return true;
        }else{
            return false;
        }
    }

    private void learnableMoves(){
        this.learnable_ = moderateLevelUpList(this.lastLevelUpdated_, this.level_);
        this.lastLevelUpdated_ = level_;
    }

    private List<Moves> moderateLevelUpList(int start, int end){
        List<MoveForList> temp = this.species_.getMovelist();
        List<Moves> ret = new ArrayList<Moves>();
        for(int c = start; c < end; c++){
            if(temp.contains(new MovesCompare(c))){
                ret.add(temp.get(temp.indexOf(new MovesCompare(c))).getMove());
            }
        }
        return ret;
    }

    private void naturalMove(){
        List<Moves> temp = moderateLevelUpList(0, this.level_);

        for(int c = 0; c < bonus3_.size(); c++){
            if(temp.contains(bonus3_.get(c))){
                if(!this.base6_.contains(bonus3_.get(c))){
                    this.base6_.add(bonus3_.get(c));
                    this.bonus3_.remove(c);
                }
            }
        }
    }

    private boolean MoveSlotOpen(){
        int maxmoves = 6; // todo max moves could be editable variable for campaign settings
        if(base6_.size() + bonus3_.size() < maxmoves){
            return true;
        }else{
            return false;
        }
    }

    private boolean TmSlotOpen(){
        int maxtmmoves = 3;
        if(bonus3_.size() < maxtmmoves){
            return true;
        }else{
            return false;
        }
    }

    private boolean naturalMoveOpen(){
        int maxmoves = 6;
        if(base6_.size() < maxmoves){
            return true;
        }else{
            return false;
        }
    }

    private void updateTutorPoints(){
        int temp;
        temp = this.level_ / 5;
        temp += 1;
        this.mTTp_ = temp;
    }

    public int remainingTutorPoints(){
        return mTTp_ - uTTp_;
    }

    private boolean moveAlreadyLearned(String name){
        if(base6_.contains(new Moves(name)) || bonus3_.contains(new Moves(name))){
            return true;
        }else{
            return false;
        }
    }

    // Combat-Calculation --- might get it's own class since Trainer would use this as well

    public Damage AttackWithMove(String name, int DiceRole, boolean useAverage, boolean crit, boolean effectActivation){
        if(base6_.contains(new Moves(name))){
            Damage temp = base6_.get(base6_.indexOf(new Moves(name))).calcDamageOutput(this.statBlock_, this.species_.getTypes(), DiceRole, useAverage, crit);
            System.out.printf("%n"+this.nickname_+" will Attack with "+ temp.getMoveName()+" and will deal "+temp.getValue()+" "+temp.getDamageClass()+" Damage%n");
            return temp;
        }else if(bonus3_.contains(new Moves(name))){
            Damage temp = bonus3_.get(bonus3_.indexOf(new Moves(name))).calcDamageOutput(this.statBlock_, this.species_.getTypes(), DiceRole, useAverage, crit);
            System.out.printf("%n"+this.nickname_+" will Attack with "+ temp.getMoveName()+" and will deal "+temp.getValue()+" "+temp.getDamageClass()+" Damage%n");
            return temp;
        }else{
            System.out.printf("%n"+this.nickname_ + " will Attack with nothing%n" );
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
            System.out.printf("%n"+this.nickname_ + " took after a Defense of " + this.statBlock_.getCombatDefense()  + " and an Type mod from " + in.getType() + " of " + TypeDamageMod(in.getType()) + ", "+ actualDamage + " "+ in.getDamageClass() + "-Damage");
            this.statBlock_.update_Damage(actualDamage);
        }else if(in.getDamageClass() == DamageClass.SPECIAL){
            actualDamage = in.getValue() - this.statBlock_.getCombatSpecialDefense();
            temp = actualDamage * TypeDamageMod(in.getType());
            actualDamage = (int) temp;
            System.out.printf("%n"+this.nickname_ + " took after a Special-Defense of " + this.statBlock_.getCombatSpecialDefense()  + " and an Type mod from " + in.getType() + " of " + TypeDamageMod(in.getType()) + ", "+ actualDamage + " "+ in.getDamageClass() + "-Damage");
            this.statBlock_.update_Damage(actualDamage);
        }else if(in.getDamageClass() == DamageClass.STATUS){
            System.out.println("StatusMove kekW");
        }
    }

    private double TypeDamageMod(Type in){
        int value = 0;
        for(int c = 0; c<this.species_.getTypes().size(); c++){
            if(in.getRelation()[this.species_.getTypes().get(c).getRank()] == -1){
                value = -1;
                break;
            }else {
                value += in.getRelation()[this.species_.getTypes().get(c).getRank()];
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
        return 1;
    }

    //misc block
    @Override
    public String toString() {
        return "Pokemon{" +
                "nickname_='" + nickname_ + '\'' +
                ", species_=" + species_ +
                ", level_=" + level_ +
                ", exp_=" + exp_ +
                ", heldItem_=" + heldItem_ +
                ", loyalty_=" + loyalty_ +
                ", gender_=" + gender_ +
                ", nature_=" + nature_ +
                ", abilities_=" + abilities_ +
                ", capabilities_=" + capabilities_ +
                ", skills_=" + Arrays.toString(skills_) +
                ", statBlock_=" + statBlock_ +
                ", injuries_=" + injuries_ +
                ", mTTp_=" + mTTp_ +
                ", uTTp_=" + uTTp_ +
                ", usedVitamins_=" + usedVitamins_ +
                ", edges_=" + edges_ +
                ", base6_=" + base6_ +
                ", bonus3_=" + bonus3_ +
                ", connections_=" + connections_ +
                ", notes_='" + notes_ + '\'' +
                ", learnable_=" + learnable_ +
                ", lastLevelUpdated_=" + lastLevelUpdated_ +
                '}';
    }
}
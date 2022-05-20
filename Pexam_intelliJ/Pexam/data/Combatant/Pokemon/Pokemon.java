package Pexam.data.Combatant.Pokemon;

import Pexam.cute.cuteutility.Database.Dex;
import Pexam.data.Combatant.Combatant;
import Pexam.data.Items.Items;
import Pexam.data.Moves.MoveForList;
import Pexam.data.Moves.Moves;
import Pexam.data.Moves.MovesCompare;
import Pexam.data.utility.Describtions.Tutor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Replacement Class of Pokemon
 * Inherits Combatant-Class for better differentiation between Units
 */
public class Pokemon extends Combatant {

    private Species species_;

    private int level_;

    private int exp_;

    private Items helditem_;

    private int loyalty_;

    private Nature nature_;

    private int mTTp_;

    private int uTTp_;

    private int usedVitamins_;

    private ArrayList<Tutor> edges_;

    private ArrayList<Moves> bonusMoves_;

    private ArrayList<Moves> connectionMoves_;


    private ArrayList<Moves> learnable_;

    private int lastLevelUpdated_;


    // Methods

    public Pokemon(){
        super();
        this.species_ = new Species();
        this.level_ = 1;
        this.exp_ = 0;
        this.loyalty_ = 1;
        this.nature_ = Nature.NON;
        this.mTTp_ = 0;
        this.uTTp_ = 0;
        this.usedVitamins_ = 0;
        this.edges_ = new ArrayList<Tutor>();
        this.bonusMoves_ = new ArrayList<Moves>();
        this.connectionMoves_ = new ArrayList<>();
        this.learnable_ = new ArrayList<Moves>();
    }

    public Pokemon(String in, Species species){
        super(in, species.getBasestats(), species.getTypes(), species.getSkills(), species.getCapabilities());

        this.species_ = species;
        this.level_ = 1;
        this.exp_ = 0;
        this.loyalty_ = 1;
        this.nature_ = Nature.NON;

        this.edges_ = new ArrayList<Tutor>();
        this.bonusMoves_ = new ArrayList<Moves>();
        this.connectionMoves_ = new ArrayList<Moves>();
        this.learnable_ = new ArrayList<Moves>();
    }

    public Pokemon(String in){
        this();
        this.name_ = in;
    }

    public Pokemon(String in, Dex database){

    }

    // non contructor Methods

    public void update_Nature(Nature in){
        this.nature_ = in;
        super.statBlock_.update_Nature(in.getNaturemod());
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

    private ArrayList<Moves> moderateLevelUpList(int start, int end){
        ArrayList<MoveForList> temp = this.species_.getMovelist();
        ArrayList<Moves> ret = new ArrayList<Moves>();
        for(int c = start; c < end; c++){
            if(temp.contains(new MovesCompare(c))){
                ret.add(new Moves(temp.get(temp.indexOf(new MovesCompare(c))).getMove()));
            }
        }
        return ret;
    }

    private void naturalMove(){
        List<Moves> temp = moderateLevelUpList(0, this.level_);

        for(int c = 0; c < bonusMoves_.size(); c++){
            if(temp.contains(bonusMoves_.get(c))){
                if(!super.moves_.contains(bonusMoves_.get(c))){
                    super.moves_.add(bonusMoves_.get(c));
                    this.bonusMoves_.remove(c);
                }
            }
        }
    }

    private boolean MoveSlotOpen(){
        int maxmoves = 6; // todo max moves could be editable variable for campaign settings
        if(super.moves_.size() + this.bonusMoves_.size() < maxmoves){
            return true;
        }else{
            return false;
        }
    }

    private boolean TmSlotOpen(){
        int maxtmmoves = 3;
        if(bonusMoves_.size() <= maxtmmoves){
            return true;
        }else{
            return false;
        }
    }

    private boolean naturalMoveOpen(){
        int maxmoves = 6;
        if(super.moves_.size() < maxmoves){
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
        if(super.moves_.contains(new Moves(name)) || bonusMoves_.contains(new Moves(name))){
            return true;
        }else{
            return false;
        }
    }

    public void learnMove_Levelup(String name, int slot){
        if(!moveAlreadyLearned(name)) {
            if (onLearnableList(name)) {
                //System.out.println("levelup");
                if (MoveSlotOpen()) {
                    super.moves_.add(learnable_.get(learnable_.indexOf(new Moves(name))));
                    this.learnable_.remove(new Moves(name));
                } else if (!MoveSlotOpen()) {
                    super.moves_.set(slot, this.learnable_.get(this.learnable_.indexOf(new Moves(name))));
                    this.learnable_.remove(new Moves(name));
                }

            }
        }
    }

    public void learnMove_TM(String name, int slot){
        //todo make this less scuffed
        if(!moveAlreadyLearned(name)){
            if(MoveSlotOpen()){
                if(TmSlotOpen()){
                    if(remainingTutorPoints() > 0){
                        this.bonusMoves_.add(this.species_.getTmlist().get(this.species_.getTmlist().indexOf(new MoveForList(name))).getMove());
                        uTTp_ += 1;
                    }else{
                        System.out.println("Couldn't learn Move, not enough TutorPoints remaining");
                    }
                }else if (!TmSlotOpen()) {
                    this.bonusMoves_.set(slot, this.species_.getTmlist().get(this.species_.getTmlist().indexOf(new MoveForList(name))).getMove());
                }
            } else {
                if (TmSlotOpen()) {
                    if (remainingTutorPoints() > 0) {
                        this.bonusMoves_.add(this.species_.getTmlist().get(this.species_.getTmlist().indexOf(new MoveForList(0, new Moves(name)))).getMove());
                        uTTp_ += 1;
                        super.moves_.remove(slot);
                    } else {
                        System.out.println("Couldn't learn Move, not enough TutorPoints remaining");
                    }
                }else if (!TmSlotOpen()) {
                    this.bonusMoves_.set(slot, this.species_.getTmlist().get(this.species_.getTmlist().indexOf(new MoveForList(0, new Moves(name)))).getMove());
                }
            }
        naturalMove();
        }
    }

    public void learnMove_Tutor(String name, int slot){
        if(!moveAlreadyLearned(name)){
            if (onTutorList(name)) {
                //System.out.println("tutor");
                if(!moveAlreadyLearned(name)) {
                    if (MoveSlotOpen()) {
                        if (TmSlotOpen()) {
                            if (remainingTutorPoints() > 1) {
                                this.bonusMoves_.add(this.species_.getTutorlist().get(this.species_.getTutorlist().indexOf(new Moves(name))));
                                uTTp_ += 2;
                            } else {
                                System.out.println("Couldn't learn Move, not enough TutorPoints remaining");
                            }
                        }else if (!TmSlotOpen()) {
                            this.bonusMoves_.set(slot, this.species_.getTutorlist().get(this.species_.getTutorlist().indexOf(new Moves(name))));
                        }
                    } else {
                        if (TmSlotOpen()) {
                            if (remainingTutorPoints() > 1) {
                                this.bonusMoves_.add(this.species_.getTutorlist().get(this.species_.getTutorlist().indexOf(new Moves(name))));
                                uTTp_ += 2;
                                super.moves_.remove(slot);
                            } else {
                                System.out.println("Couldn't learn Move, not enough TutorPoints remaining");
                            }
                        }else if (!TmSlotOpen()) {
                            this.bonusMoves_.set(slot, this.species_.getTutorlist().get(this.species_.getTutorlist().indexOf(new Moves(name))));
                            uTTp_ += 2;
                        }
                    }
                }
                naturalMove();
            }
        }
    }

    public void learnMove_Egg(String name, int slot){
        if(!moveAlreadyLearned(name)) {
            if (onEggList(name)) {
                //System.out.println("Egg");
                if (!moveAlreadyLearned(name)) {
                    if (MoveSlotOpen()) {
                        if (TmSlotOpen()) {
                            if (remainingTutorPoints() > 1) {
                                this.bonusMoves_.add(this.species_.getEgglist().get(this.species_.getEgglist().indexOf(new Moves(name))));
                                uTTp_ += 2;

                            } else {
                                System.out.println("Couldn't learn Move, not enough TutorPoints remaining");
                            }
                        } else if (!TmSlotOpen()) {
                            this.bonusMoves_.set(slot, this.species_.getEgglist().get(this.species_.getEgglist().indexOf(new Moves(name))));
                        }
                    } else {
                        if (TmSlotOpen()) {
                            if (remainingTutorPoints() > 1) {
                                this.bonusMoves_.add(this.species_.getEgglist().get(this.species_.getEgglist().indexOf(new Moves(name))));
                                uTTp_ += 2;
                                super.moves_.remove(slot);
                            } else {
                                System.out.println("Couldn't learn Move, not enough TutorPoints remaining");
                            }
                        } else if (!TmSlotOpen()) {
                            this.bonusMoves_.set(slot, this.species_.getEgglist().get(this.species_.getEgglist().indexOf(new Moves(name))));
                        }
                    }
                }
                naturalMove();
            }
        }
    }

    public void learnMove(String name, int slot, int list){
        if(!moveAlreadyLearned(name)) {
            if (onLearnableList(name) || list == 1) {
                System.out.println("levelup");
                if (MoveSlotOpen()) {
                    super.moves_.add(learnable_.get(learnable_.indexOf(new Moves(name))));
                    this.learnable_.remove(new Moves(name));
                } else if (!MoveSlotOpen()) {
                    super.moves_.set(slot, this.learnable_.get(this.learnable_.indexOf(new Moves(name))));
                    this.learnable_.remove(new Moves(name));
                }

            } else if (onTmList(name) || list == 2) {
                System.out.println("tm");
                if(!moveAlreadyLearned(name)) {
                    if (MoveSlotOpen()) {
                        if (TmSlotOpen()) {
                            if (remainingTutorPoints() > 0) {
                                this.bonusMoves_.add(this.species_.getTmlist().get(this.species_.getTmlist().indexOf(new MoveForList(name))).getMove());
                                uTTp_ += 1;

                            } else {
                                System.out.println("Couldn't learn Move, not enough TutorPoints remaining");
                            }
                        }else if (!TmSlotOpen()) {
                            this.bonusMoves_.set(slot, this.species_.getTmlist().get(this.species_.getTmlist().indexOf(new MoveForList(name))).getMove());
                        }
                    } else {
                        if (TmSlotOpen()) {
                            if (remainingTutorPoints() > 0) {
                                this.bonusMoves_.add(this.species_.getTmlist().get(this.species_.getTmlist().indexOf(new MoveForList(0, new Moves(name)))).getMove());
                                uTTp_ += 1;
                                super.moves_.remove(slot);
                            } else {
                                System.out.println("Couldn't learn Move, not enough TutorPoints remaining");
                            }
                        }else if (!TmSlotOpen()) {
                            this.bonusMoves_.set(slot, this.species_.getTmlist().get(this.species_.getTmlist().indexOf(new MoveForList(0, new Moves(name)))).getMove());
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
                                this.bonusMoves_.add(this.species_.getEgglist().get(this.species_.getEgglist().indexOf(new Moves(name))));
                                uTTp_ += 2;

                            } else {
                                System.out.println("Couldn't learn Move, not enough TutorPoints remaining");
                            }
                        }else if (!TmSlotOpen()) {
                            this.bonusMoves_.set(slot, this.species_.getEgglist().get(this.species_.getEgglist().indexOf(new Moves(name))));
                        }
                    } else {
                        if (TmSlotOpen()) {
                            if (remainingTutorPoints() > 1) {
                                this.bonusMoves_.add(this.species_.getEgglist().get(this.species_.getEgglist().indexOf(new Moves(name))));
                                uTTp_ += 2;
                                super.moves_.remove(slot);
                            } else {
                                System.out.println("Couldn't learn Move, not enough TutorPoints remaining");
                            }
                        }else if (!TmSlotOpen()) {
                            this.bonusMoves_.set(slot, this.species_.getEgglist().get(this.species_.getEgglist().indexOf(new Moves(name))));
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
                                this.bonusMoves_.add(this.species_.getTutorlist().get(this.species_.getTutorlist().indexOf(new Moves(name))));
                                uTTp_ += 2;
                            } else {
                                System.out.println("Couldn't learn Move, not enough TutorPoints remaining");
                            }
                        }else if (!TmSlotOpen()) {
                            this.bonusMoves_.set(slot, this.species_.getTutorlist().get(this.species_.getTutorlist().indexOf(new Moves(name))));
                        }
                    } else {
                        if (TmSlotOpen()) {
                            if (remainingTutorPoints() > 1) {
                                this.bonusMoves_.add(this.species_.getTutorlist().get(this.species_.getTutorlist().indexOf(new Moves(name))));
                                uTTp_ += 2;
                                super.moves_.remove(slot);
                            } else {
                                System.out.println("Couldn't learn Move, not enough TutorPoints remaining");
                            }
                        }else if (!TmSlotOpen()) {
                            this.bonusMoves_.set(slot, this.species_.getTutorlist().get(this.species_.getTutorlist().indexOf(new Moves(name))));
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

    public void moveInfo(String in){
        System.out.println(super.moves_.get(super.moves_.indexOf(new Moves(in))).toPrint());
    }
    /*
    -t "Nickname" "Species" "Gender" "Level" "EXP" "Abilities as Array" "Nature" "Stat-Point distribution as Array" "Used Vitamins as Int" "Bonus-Stats from Vitamins as Array" "Used TutorPoints as Int" "Bought PokeEdges as Array" "Selected Moves as Array"
    */
    public String toSave(){
        String s = " ";
        return "" + this.name_ +s +this.species_.getSpecies() +s+ this.gender_ +s+ this.level_ +s+ this.exp_ +s+ this.abilities_.toString() +s+ this.nature_ +s+ Arrays.toString(this.statBlock_.getUsed_SkillPoints()) +s+ this.usedVitamins_ +s+ Arrays.toString(this.statBlock_.getUsed_VitaminPoints()) +s+ this.uTTp_ +s+ this.edges_.toString() +s+ this.moves_.toString() +"\n";
    }

    @Override
    public boolean equals(Object other){
        if(other instanceof Pokemon){
            if(this.name_.equals(((Pokemon) other).getName())){
                return true;
            }
        }
        if(other instanceof String){
            return this.name_.equals((String) other);
        }
        return false;
    }

    @Override
    public String toString() {
        return "PokemonBETA{" +
                "name_='" + name_ + '\'' +
                ", types_=" + types_ +
                ", statBlock_=" + statBlock_ +
                ", statics_=" + perm_present_ +
                ", temporary_=" + temp_present_ +
                ", moves_=" + moves_ +
                ", gender_=" + gender_ +
                ", abilities_=" + abilities_ +
                ", skills_=" + skills_ +
                ", capabilities_=" + capabilities_ +
                ", notes_='" + notes_ + '\'' +
                ", species_=" + species_ +
                ", level_=" + level_ +
                ", exp_=" + exp_ +
                ", helditem_=" + helditem_ +
                ", loyalty_=" + loyalty_ +
                ", nature_=" + nature_ +
                ", mTTp_=" + mTTp_ +
                ", uTTp_=" + uTTp_ +
                ", usedVitamins_=" + usedVitamins_ +
                ", edges_=" + edges_ +
                ", bonusMoves_=" + bonusMoves_ +
                ", connectionMoves_=" + connectionMoves_ +
                ", learnable_=" + learnable_ +
                ", lastLevelUpdated_=" + lastLevelUpdated_ +
                '}';
    }

    public void PokePrinter(){
        System.out.println("PokemonBETA");
        System.out.println("name_='" + name_);
        System.out.println("species_=" + species_);
        System.out.println("types_=" + types_ );
        System.out.println("level_=" + level_);
        System.out.println("exp_=" + exp_);
        System.out.println("statBlock_=" + statBlock_);
        System.out.println("statics_=" + perm_present_ );
        System.out.println("temporary_=" + temp_present_);
        System.out.println("moves_=" + moves_);
        System.out.println("gender_=" + gender_);
        System.out.println("abilities_=" + abilities_);
        System.out.println("skills_=" + skills_);
        System.out.println("capabilities_=" + capabilities_);
        System.out.println("notes_='" + notes_);
        System.out.println("helditem_=" + helditem_);
        System.out.println("loyalty_=" + loyalty_);
        System.out.println("nature_=" + nature_);
        System.out.println("mTTp_=" + mTTp_);
        System.out.println("uTTp_=" + uTTp_);
        System.out.println("usedVitamins_=" + usedVitamins_);
        System.out.println("edges_=" + edges_);
        System.out.println("bonusMoves_=" + bonusMoves_);
        System.out.println("connectionMoves_=" + connectionMoves_);
        System.out.println("learnable_=" + learnable_);
        System.out.println("lastLevelUpdated_=" + lastLevelUpdated_);
    }
}
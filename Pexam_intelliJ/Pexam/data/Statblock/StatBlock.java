package Pexam.data.Statblock;

import java.util.Arrays;

/**
 * Statblock Class which implements Statblocks for all Character Types
 */
public class StatBlock {

    private final Stats KP_;

    private final Stats AT_;

    private final Stats DEF_;

    private final Stats sAT_;

    private final Stats sDEF_;

    private final Stats SPE_;

    // Bool

    private boolean baseRel_;

    private boolean atConf_;

    private boolean spatConf_;

    // BonusStats

    private int[] MegaEvo_;

    // CombatStages

    private int[] combatStages_;

    private int[] standardStages_;

    private int[] fromAffliction_; // TODO: 07/09/2020 this shit afflictions are implemented

    // other Bool

    private boolean[] statAce_;

    private boolean mega_;

    private int level_;

    private int leftPoints_;

    private int spendPoints_;

    // Derived Stats

    private int phEV_;

    private int spEV_;

    private int speEV_;

    private int maxHP_;

    private int curHP_;

    private int injuries_; // TODO: 19.03.2021 update mathods to check injuries and stuff

    // constructor

    public StatBlock(int[] baseStats){
        this.baseRel_ = false;
        this.atConf_ = false;
        this.spatConf_ = false;
        this.mega_ = false;
        this.statAce_ = new boolean[6];
        this.level_ = 1;
        this.leftPoints_ = 0;
        this.spendPoints_ = 0;
        this.combatStages_ = new int[6];
        this.fromAffliction_ = new int[6];
        this.standardStages_ = new int[6];
        this.phEV_ = 0;
        this.spEV_ = 0;
        this.speEV_ = 0;

        this.KP_ = new Stats(baseStats[0],0);
        this.AT_ = new Stats(baseStats[1],1);
        this.DEF_ = new Stats(baseStats[2],2);
        this.sAT_ = new Stats(baseStats[3],3);
        this.sDEF_ = new Stats(baseStats[4],4);
        this.SPE_ = new Stats(baseStats[5],5);
    }

    /**
     * Constructor Method for a Statblock of any Type but primarily Pokemon
     * @param baseRel True if Baserelation does appear to be enforced
     * @param atConf True if the PokeEdge "Attack Conflict" is bought and set on the Attack Stat
     * @param spatConf True if the PokeEdge "Attack Conflict" is bought and set on the Special Attack
     * @param mega True if Mega-Stats are taken into consideration
     * @param level Level of Statblock owner
     * @param statAce True if StatAce feat takes effect on any Stat with the same order as the normal stats in array
     * @param baseStats Stat-Array with Order [KP, Attack, Defense, Special Attack, Special Defense, Speed]
     * @param natureMod Basestat changes from Nature same order as normal stats in array
     * @param vitamins Basestat changes from Vitamins same order as normal stats in array
     * @param trainerClass Bonusstats from Trainerclass same order as normal stats in array
     * @param abilities Statchanges from Abilities same order as normal stats in array
     */
    public StatBlock(boolean baseRel, boolean atConf, boolean spatConf, boolean mega, int level, boolean[] statAce, int[] baseStats, int[] natureMod, int[] vitamins, int[] trainerClass, int[] abilities){
        this.baseRel_ = baseRel;
        this.atConf_ = atConf;
        this.spatConf_ = spatConf;
        this.mega_ = mega;
        this.statAce_ = statAce;
        this.level_ = level;
        this.leftPoints_ = 0;
        this.spendPoints_ = 0;
        this.combatStages_ = new int[6];
        this.standardStages_ = new int[6];
        this.fromAffliction_ = new int[6];
        this.MegaEvo_ = new int[6];
        this.phEV_ = 0;
        this.spEV_ = 0;
        this.speEV_ = 0;

        this.KP_ = new Stats(baseStats[0], natureMod[0], vitamins[0], trainerClass[0], abilities[0], 0);
        this.AT_ = new Stats(baseStats[1], natureMod[1], vitamins[1], trainerClass[1], abilities[1], 1);
        this.DEF_ = new Stats(baseStats[2], natureMod[2], vitamins[2], trainerClass[2], abilities[2], 2);
        this.sAT_ = new Stats(baseStats[3], natureMod[3], vitamins[3], trainerClass[3], abilities[3], 3);
        this.sDEF_ = new Stats(baseStats[4], natureMod[4], vitamins[4], trainerClass[4], abilities[4], 4);
        this.SPE_ = new Stats(baseStats[5], natureMod[5], vitamins[5], trainerClass[5], abilities[5], 5);

        update();
    }

    // update methods

    /**
     * Calls some update Methods to recalculate some stats
     */
    public void update (){
        //System.out.println(this.maxHP_);

        calcRelations();

        update_SkillPoints();

        update_EVs();

        update_maxHP();

        reset_HP(); //might get removed again if something comes up or update on current hp is at this point pointless

    }

    /**
     * Updates Level from set amount
     * @param level new Level
     */
    public void update_level(int level){
        this.level_ = level;
        update();
    }

    /**
     * Updates Attack Conflict, PokeEdge Core Rulebook
     * @param atConf true if Attack Conflict takes affect on the Attack Stat
     */
    public void update_atConf(boolean atConf){
        if(!spatConf_) {
            this.atConf_ = atConf;
            this.spatConf_ = !atConf;
        }else{//todo throw actual exception
            System.out.println("you already own a Version of AttackConflict");
        }
    }

    /**
     * Updates Special Attack Conflict, PokeEdge Core Rulebook
     * @param spatConf true if Attack Conflict takes affect on the Special Attack Stat
     */
    public void update_spatConf(boolean spatConf){
        if(!atConf_) {
            this.atConf_ = !spatConf;
            this.spatConf_ = spatConf;
        }else{//todo throw actual exception
            System.out.println("you already own a Version of AttackConflict");
        }
    }

    public void update_switchMegaStatus(){
        this.mega_ = !mega_;
    }

    public void update_megaStats(int[] values){
        this.MegaEvo_ = values;
    }

    /**
     * Updates Basestats from Int-Array
     * @param values Integer-Array of Standard Order
     */
    public void update_BaseStats(int[] values){
        KP_.redoBase(values[0]);
        AT_.redoBase(values[1]);
        DEF_.redoBase(values[2]);
        sAT_.redoBase(values[3]);
        sDEF_.redoBase(values[4]);
        SPE_.redoBase(values[5]);
        update();
    }

    public void updateBaseRelationStatus(boolean newStatus){
        this.baseRel_ = newStatus;
    }

    public void update_Nature(int[] values){
        KP_.redoNature(values[0]);
        AT_.redoNature(values[1]);
        DEF_.redoNature(values[2]);
        sAT_.redoNature(values[3]);
        sDEF_.redoNature(values[4]);
        SPE_.redoNature(values[5]);
        update();
    }

    public void update_SkillPoints(){
        //System.out.println(this.maxHP_);
        int temp = level_ +10;
        int mem = KP_.getSkillPoints() + AT_.getSkillPoints() + DEF_.getSkillPoints() + sAT_.getSkillPoints() + sDEF_.getSkillPoints() + SPE_.getSkillPoints();
        this.spendPoints_ = mem;
        this.leftPoints_ = level_ + 10 - mem;
        if(temp < mem){
            resetSkillPoints();
            System.out.println("SkillPoints are fucked up oof");
        }
    }

    public void update_CombatStages(int index, int value){
        switch (index){
            case 1: combatStages_[1] += value; break;
            case 2: combatStages_[2] += value; break;
            case 3: combatStages_[3] += value; break;
            case 4: combatStages_[4] += value; break;
            case 5: combatStages_[5] += value; break;
            default: break;
        }
    }

    private void update_EVs(){
        int temp;
        int[] mem = calcStats();
        temp = mem[2] / 5;
        //System.out.println("\n" + Arrays.toString(mem));
        if(temp <= 6){
            this.phEV_ = temp;
        }else if(temp <= 0){
            this.phEV_ = 0;
        }else if(temp > 6){
            this.phEV_ = 6;
        }
        temp = mem[4] / 5;
        if(temp <= 6){
            this.spEV_ = temp;
        }else if(temp <= 0){
            this.spEV_ = 0;
        }else if(temp > 6){
            this.spEV_ = 6;
        }
        temp = mem[5] / 5;
        if(temp <= 6){
            this.speEV_ = temp;
        }else if(temp <= 0){
            this.speEV_ = 0;
        }else if(temp > 6){
            this.speEV_ = 6;
        }
    }

    public void update_maxHP(){
        //System.out.println(maxHP_);
        if(baseRel_){
            this.maxHP_ = (KP_.calcStat() * 3) + 10 + level_;
        }else{
            this.maxHP_ = (KP_.calcStat() * 3) + 10 + level_ + level_;
        }
    }

    public void reset_HP(){
        int temp = this.maxHP_;
        this.curHP_ = temp;
    }

    public void update_Damage(int damage){
        this.curHP_ = this.curHP_ - damage;
        System.out.printf("%nCurrent HP: " +this.curHP_ +"/"+ this.maxHP_);
        if(this.curHP_ < 0){
            System.out.println(": Your Pokemon feinted");
        }
    }

    // adding Values

    public void addVitamins(int index, int value){
        resetSkillPoints();
        if(index == 0){
            KP_.addVit(value);
        }
        if(index == 1){
            AT_.addVit(value);
        }
        if(index == 2){
            DEF_.addVit(value);
        }
        if(index == 3){
            sAT_.addVit(value);
        }
        if(index == 4){
            sDEF_.addVit(value);
        }
        if(index == 5){
            SPE_.addVit(value);
        }
        calcRelations();
    }

    public void addTrainerClass(int index, int value){
        resetSkillPoints();
        if(index == 0){
            KP_.addTCL(value);
        }
        if(index == 1){
            AT_.addTCL(value);
        }
        if(index == 2){
            DEF_.addTCL(value);
        }
        if(index == 3){
            sAT_.addTCL(value);
        }
        if(index == 4){
            sDEF_.addTCL(value);
        }
        if(index == 5){
            SPE_.addTCL(value);
        }
        calcRelations();
    }

    public void addAbility(int index, int value){
        resetSkillPoints();
        if(index == 0){
            KP_.addAby(value);
        }
        if(index == 1){
            AT_.addAby(value);
        }
        if(index == 2){
            DEF_.addAby(value);
        }
        if(index == 3){
            sAT_.addAby(value);
        }
        if(index == 4){
            sDEF_.addAby(value);
        }
        if(index == 5){
            SPE_.addAby(value);
        }
        calcRelations();
    }

    /**
     * Method with which you can add a specific amount of skillpoints to a selected skill
     * @param index Integer Number of 0 to 5 having the same order as the Stat Arrays
     * @param amount Integer Amount of spend Skillpoints
     */
    public void addSkillPoint(int index, int amount){
        for(int c = 0; c < amount; c++){
            if(this.leftPoints_ > 0){
                if(this.baseRel_){
                    if(checkAdding(index)){
                        this.indexAddOne(index);
                        this.modLevelupPoints(1);
                    }else{
                        System.out.println("Adding stopped since baserelation");
                    }
                }else{
                    this.indexAddOne(index);
                    this.modLevelupPoints(1);
                }
            }
        }
        update();
    }

    private void indexAddOne(int index){
        switch(index){
            case 0: this.KP_.addSP(1);break;
            case 1: this.AT_.addSP(1);break;
            case 2: this.DEF_.addSP(1);break;
            case 3: this.sAT_.addSP(1);break;
            case 4: this.sDEF_.addSP(1);break;
            case 5: this.SPE_.addSP(1);break;
        }
    }

    private boolean checkAdding(int index){
        switch (index){
            case 0: return this.KP_.checkBaseRelationWithAdded(this.calcStats());
            case 1: return this.AT_.checkBaseRelationWithAdded(this.calcStats());
            case 2: return this.DEF_.checkBaseRelationWithAdded(this.calcStats());
            case 3: return this.sAT_.checkBaseRelationWithAdded(this.calcStats());
            case 4: return this.sDEF_.checkBaseRelationWithAdded(this.calcStats());
            case 5: return this.SPE_.checkBaseRelationWithAdded(this.calcStats());
        }
        return false;
    }

    private void modLevelupPoints(int in){
        this.leftPoints_ -= in;
        this.spendPoints_ += in;
    }

    public void addFromClass(int index, int value){
        if(index == 0){
            KP_.addFC(value);
        }
        if(index == 1){
            AT_.addFC(value);
        }
        if(index == 2){
            DEF_.addFC(value);
        }
        if(index == 3){
            sAT_.addFC(value);
        }
        if(index == 4){
            sDEF_.addFC(value);
        }
        if(index == 5){
            SPE_.addFC(value);
        }
    }

    // calc stuff

    private int[] calcBaseStats(){
        int[] temp = new int[6];
        temp[0] = KP_.calcBase();
        temp[1] = AT_.calcBase();
        temp[2] = DEF_.calcBase();
        temp[3] = sAT_.calcBase();
        temp[4] = sDEF_.calcBase();
        temp[5] = SPE_.calcBase();
        return temp;
    }

    private int[] calcStats(){
        int[] temp = new int[6];
        temp[0] = KP_.calcStat();
        temp[1] = AT_.calcStat();
        temp[2] = DEF_.calcStat();
        temp[3] = sAT_.calcStat();
        temp[4] = sDEF_.calcStat();
        temp[5] = SPE_.calcStat();
        return temp;
    }

    private int[] calcCombatStatsBETA(){
        int[] withoutCS = calcStats();
        int[] withCS = new int[6];
        double pivot;
        for(int c = 0; c < withoutCS.length; c++){
            pivot = withoutCS[c] * calcCSMod(c);
            withCS[c] = (int) pivot;
        }
        return withCS;
    }

    private double calcCSMod(int index){
        double negCS = 0.1;
        double posCS = 0.2;
        double mod = 1.0;
        if(index == 0){
            return 1;
        }else{
            if(this.combatStages_[index] > 0){
                for(int c = 0; c < this.combatStages_[index]; c++){
                    mod += posCS;
                }
            }else{
                for(int c = 0; c > this.combatStages_[index]; c--){
                    mod -= negCS;
                }
            }
            return mod;
        }
    }

    private int[] calcCombatStats (){// TODO: 01/02/2021 something does not work -> results are always 0
        int[] mem = calcStats();
        int[] temp = new int[6];
        double mod = 1.0;
        double calc;
        for(int c = 0; c < mem.length; c++){
            if(combatStages_[c] < 0){
                if(combatStages_[c] < -6){
                    mod = mod - (0.1 * 6);
                }else{
                    mod = mod - (0.1 * combatStages_[c]);
                }
                calc = mem[c] * mod;
                temp[c] = (int) calc;
            }
            if(combatStages_[c] > 0){
                if(combatStages_[c] > 6){
                    mod = mod + (0.2 * 6);
                }else{
                    mod = mod + (0.2 * combatStages_[c]);
                }
                calc = mem[c] * mod;
                temp[c] = (int) calc;
            }
            mod = 1.0;
        }
        return temp;
    }

    private void calcRelations(){ // TODO: 01/02/2021 does not work correctly
        if(this.baseRel_) {
            this.KP_.createRelation(calcBaseStats());
            this.AT_.createRelation(calcBaseStats());
            this.DEF_.createRelation(calcBaseStats());
            this.sAT_.createRelation(calcBaseStats());
            this.sDEF_.createRelation(calcBaseStats());
            this.SPE_.createRelation(calcBaseStats());
        }
    }

    private void resetSkillPoints(){
        KP_.resetSP();
        AT_.resetSP();
        DEF_.resetSP();
        sAT_.resetSP();
        sDEF_.resetSP();
        SPE_.resetSP();
        int temp = this.level_;
        leftPoints_ = temp + 10;
        this.spendPoints_ = 0;
    }

    // utility

    private int[] addArrays (int[] a, int[] b){
        int[] temp = new int[6];
        for(int c = 0; c < a.length; c++){
            temp[c] = a[c] + b[c];
        }
        return temp;
    }

    private int arraySum ( int[] in){
        int mem = 0;
        for( int c = 0; c < in.length; c++){
            mem += in[c];
        }
        return mem;
    }

    private void bubbleSort(int[] arr) {
        int b;
        int c;
        for (int a = 0; a < arr.length; a++) {
            if (a + 1 < arr.length) {
                b = arr[a];
                c = arr[a + 1];
                if (b > c) {
                    arr[a] = c;
                    arr[a + 1] = b;
                    a = -1;
                }
            }
        }
    }

    // returns

    public int[] getBaseStats(){
        return calcBaseStats();
    }

    public int[] getStats(){
        return calcBaseStats();
    }

    public int[] getCombatStats(){
        return calcCombatStatsBETA();
    }

    public int[] getEvasions(){
        int[] temp = new int[3];
        temp[0] = this.phEV_;
        temp[1] = this.spEV_;
        temp[2] = this.speEV_;
        return temp;
    }

    public int getCombatAttack(){
        return calcCombatStatsBETA()[1];
    }

    public int getCombatSpecialAttack(){
        return calcCombatStatsBETA()[3];
    }

    public int getCombatDefense(){
        return calcCombatStatsBETA()[2];
    }

    public int getCombatSpecialDefense(){
        return calcCombatStatsBETA()[4];
    }

    @Override
    public String toString() {

        return "StatBlock{" +
                "KP_=" + KP_ +
                ", AT_=" + AT_ +
                ", DEF_=" + DEF_ +
                ", sAT_=" + sAT_ +
                ", sDEF_=" + sDEF_ +
                ", SPE_=" + SPE_ +
                ", baseRel_=" + baseRel_ +
                ", atConf_=" + atConf_ +
                ", spatConf_=" + spatConf_ +
                ", MegaEvo_=" + Arrays.toString(MegaEvo_) +
                ", combatStages_=" + Arrays.toString(combatStages_) +
                ", standardStages_=" + Arrays.toString(standardStages_) +
                ", fromAffliction_=" + Arrays.toString(fromAffliction_) +
                ", statAce_=" + Arrays.toString(statAce_) +
                ", mega_=" + mega_ +
                ", level_=" + level_ +
                ", leftPoints_=" + leftPoints_ +
                ", spendPoints_=" + spendPoints_ +
                ", phEV_=" + phEV_ +
                ", spEV_=" + spEV_ +
                ", speEV_=" + speEV_ +
                ", maxHP_=" + maxHP_ +
                ", curHP_=" + curHP_ +
                "}";
    }

    public void addstuff(){
        this.combatStages_[1] = 3;
    }
}

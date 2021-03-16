package Pexam.data.Statblock;

import java.util.Arrays;

public class Stats {

    // base stuff

    private int baseStat_;

    private int natureMod_;

    private int vitamins_;

    private int trainerClass_; // TODO: 07/09/2020 when trainer classes are implemented

    private int ability_; // TODO: 07/09/2020 redo when abilities are implemented

    // const

    private final int index_;

    // bonus stuff

    private int skillPoints_;

    private int fromClass_; // TODO: 07/09/2020 when trainer classes are implemented

    // Relations

    private int[] relations_;

    // Constructor

    public Stats(int base, int nat, int vit, int tcl, int Aby, int index){
        this.baseStat_ = base;
        this.natureMod_ = nat;
        this.vitamins_ = vit;
        this.trainerClass_ = tcl;
        this.ability_ = Aby;
        this.skillPoints_ = 0;
        this.fromClass_ = 0;
        this.index_ = index;
        this.relations_ = new int[6];
    }

    // utility

    public int calcBase(){
        //System.out.println(baseStat_ + natureMod_ + vitamins_ + trainerClass_ + ability_);
        return baseStat_ + natureMod_ + vitamins_ + trainerClass_ + ability_;
    }

    public int calcStat(){
        //System.out.println(calcBase() + skillPoints_ + fromClass_);
        return calcBase() + skillPoints_ + fromClass_;
    }

    public void updateBaseRelation(int[] relation){
        this.relations_ = relation;
    }

    public void createRelation(int[] stats){
        int[] temp = new int[6];
        for(int c = 0; c < stats.length; c++){
            if(calcBase() < stats[c]){
                temp[c] = 1;
            }else if(calcBase() == stats[c]){
                temp[c] = 0;
            }else if(calcBase() > stats[c]){
                temp[c] = -1;
            }
            //System.out.println(temp[c]);
        }
        //System.out.println(Arrays.toString(temp));
        this.relations_ = temp;
    }

    public boolean checkBaseRelationWithAdded(int[] stats){
        int[] temp = createNewStats(stats);
        boolean[] test = new boolean[6];
        for(int c = 0; c < this.relations_.length; c++){
            if(c == this.index_){
                test[c] = true;
            }else{
                if(this.relations_[c] == 1){
                    if(temp[c] == 1){
                        test[c] = true;
                    }
                }
                if(this.relations_[c] == 0){
                    test[c] = true;
                }
                if(this.relations_[c] == -1){
                    if(temp[c] == -1){
                        test[c] = true;
                    }
                }

            }
        }
        System.out.println(Arrays.toString(test)); //print of relations in boolean
        for(boolean yes : test){
            if(!yes){
                return false;
            }
        }
        return true;
    }

    private int[] createNewStats(int[] in){
        in[this.index_]++;
        return createStatRelation(in);
    }

    private int[] createStatRelation(int[] in){
        int[] temp = new int[6];
        for(int c = 0; c < in.length; c++){
            if(in[this.index_] < in[c]){
                temp[c] = 1;
            }else if(in[this.index_] == in[c]){
                temp[c] = 0;
            }else if(in[this.index_] > in[c]){
                temp[c] = -1;
            }
            //System.out.println(temp[c]);
        }
        //System.out.println(Arrays.toString(temp));
        return temp;
    }

    public void resetSP(){
        this.skillPoints_ = 0;
    }

    // adding

    public void addVit(int value){
        this.vitamins_ = vitamins_ + value;
    }

    public void addTCL(int value){
        this.trainerClass_ = trainerClass_ + value;
    }

    public void addAby(int value){
        this.ability_ = ability_ + value;
    }

    public void addSP(int value){
        this.skillPoints_ = skillPoints_ + value;
    }

    public void addFC(int value){
        this.fromClass_ = fromClass_ + value;
    }

    public int getSkillPoints(){
        return this.skillPoints_;
    }

    // redo

    public void redoBase(int value){
        this.baseStat_ = value;
    }

    public void redoNature(int value){
        this.natureMod_ = value;
    }

    //misc

    public String toString(){

        return "" + calcStat();

    }

}

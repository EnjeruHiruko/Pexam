package Pexam.data.utility.Describtions;

public class Skill{

    int dice_;

    int mod_;

    public Skill(){
        this.dice_ = 0;
        this.mod_ = 0;
    }

    public Skill(String[] input){
        this.dice_ = Integer.valueOf(input[0]);
        this.mod_ = Integer.valueOf(input[1]);
    }

    public String toString(){
        return "" + dice_ + "d6 +" + mod_ + "%n";
    }

}
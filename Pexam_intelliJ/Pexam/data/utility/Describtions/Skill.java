package Pexam.data.utility.Describtions;

public class Skill{

    String name_;

    int dice_;

    int mod_;

    public Skill(){
        this.dice_ = 0;
        this.mod_ = 0;
    }

    public Skill(String[] input){
        //System.out.println(Arrays.toString(input));
        //System.out.println(input.length);
        if(input[1].equals("Athl")){
            this.name_ = input[1];
            this.dice_ = Integer.parseInt(input[2]);
        }else{
            this.name_ = input[0];
            this.dice_ = Integer.parseInt(input[1].trim());
            this.mod_ = Integer.parseInt(input[2].trim());
        }
    }

    public String toString(){
        return "" + dice_ + "d6+" + mod_;
    }

}
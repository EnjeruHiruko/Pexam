package Pexam.data.Pokemon;

import java.util.Arrays;

public class Evolution{

    private String name_;

    private String means_;

    private int level_;

    //Constructor and Creation block

    public Evolution(){
        this.name_ = "";
        this.level_ = 0;
    }

    public Evolution(String[] in){
        this.name_ = in[0].replace("$", " ");
        String temp = in[1].replace("$", " ");
        String[] well = temp.split(" ");
        String nani = "";

        for(int c = 0; c < well.length; c++){
            try{
                this.level_ = Integer.parseInt(well[c]);
            }catch(Exception e){
                nani += well[c];
            }
        }
        this.means_ = nani;
        System.out.println(Arrays.toString(well));
    }

    public Evolution(String name, int level){
        this.name_ = name;
        this.level_ = level;
    }

    //Getter block

    public String getName() {
        return this.name_;
    }

    public int getLevel() {
        return this.level_;
    }

    //Setter block

    public void setName(String name) {
        this.name_ = name;
    }

    public void setLevel(int level) {
        this.level_ = level;
    }


    //misc block

    public String toString(){
        return "Evolution: " + name_ +" at " + level_;
    }

}
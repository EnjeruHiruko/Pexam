package Pexam.data.Pokemon;

public class Evolution{

    private String name_;

    private int level_;

    //Constructor and Creation block

    public Evolution(){
        this.name_ = "";
        this.level_ = 0;
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
        return "Evolution: " + name_ +" at " + level_ + "%n";
    }

}
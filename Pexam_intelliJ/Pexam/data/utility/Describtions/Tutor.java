package Pexam.data.utility.Describtions;

public class Tutor{

    String name_;

    String effect_;

    int costs_;

    public Tutor(){
        this.effect_ = "";
        this.costs_ = 0;
    }

    public Tutor(String name, String effect, int costs){
        this.name_ = name;
        this.effect_ = effect;
        this.costs_ = costs;
    }

    public String toString(){
        return " PokeEdge " + name_ + " : " + effect_ + " costs: " + costs_;
    }

}
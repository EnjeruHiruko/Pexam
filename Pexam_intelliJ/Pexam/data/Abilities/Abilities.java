package Pexam.data.Abilities;
import Pexam.data.utility.Enums.Action;
import Pexam.data.utility.Enums.Frequency;


public class Abilities{

    private String name_;

    private Frequency frequency_;

    private Action action_;

    private String target_;

    private String trigger_;

    private String effect_; // TODO: 18/07/2020 rename and reimplement as own abstract class

    //Constructor and creation block

    public Abilities(){
        this.name_ = "";
        this.frequency_ = new Frequency();
    }

    public Abilities(String input){
        this.name_ = input;
        this.frequency_ = new Frequency();
        this.action_ = Action.NON;
        this.target_ = "";
        this.trigger_ = "";
        this.effect_ = "";
    }

    public Abilities(String[] input){
        String[] mem = input;
        this.name_ = mem[0];
        this.frequency_ = new Frequency(mem[1]);
        this.action_ = Action.valueOf(mem[2]);
        this.target_ = mem[3];
        this.trigger_ = mem[4];
        this.effect_ = mem[5];
    }

    //Getter block

    public String getName() {
        return this.name_;
    }

    public Frequency getFrequency() {
        return this.frequency_;
    }

    public Action getAction() {
        return this.action_;
    }

    public String getTarget() {
        return this.target_;
    }

    public String getTrigger() {
        return this.trigger_;
    }

    public String getEffect() {
        return this.effect_;
    }

    //Setter block


    public void setName(String name) {
        this.name_ = name;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency_ = frequency;
    }

    public void setAction(Action action) {
        this.action_ = action;
    }

    public void setTarget(String target) {
        this.target_ = target;
    }

    public void setTrigger(String trigger) {
        this.trigger_ = trigger;
    }

    public void setEffect(String effect) {
        this.effect_ = effect;
    }

    //misc block

    public boolean equals(Object other){
        if(other instanceof Abilities){
            Abilities another = (Abilities) other;
            return this.name_.equals(another.name_);
        }
        return false;
    }

    public String toString(){
        return "Ability: " + name_ + " | " + frequency_ + " | " + action_ + " | " + target_ + " | " + trigger_ + " | " + effect_ + " |%n";
    }

}
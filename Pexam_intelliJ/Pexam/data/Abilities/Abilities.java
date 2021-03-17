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

    private String bonus_;

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
        this.bonus_ = "";
    }

    public Abilities(String[] input){
        String[] mem = input;
        if(mem.length > 0) {
            //System.out.println(mem.length);
            this.name_ = mem[1];
            String[] temp = mem[2].split(" - ");
            /*
            try{
                Scanner mehh = new Scanner(mem[2]).useDelimiter(" - ");
                System.out.println(mehh.next());

                this.frequency_ = new Frequency(mehh.next().split(" "));

                if(mehh.hasNext()){
                    this.action_ = Action.valueOf(mehh.next());
                }

                mehh.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            */






            this.frequency_ = new Frequency(temp[0].split(" "));
            if (temp.length > 1) {
                //System.out.println(temp[1]);
                this.action_ = Action.valueOf(temp[1]);
            } else {
                this.action_ = Action.NON;
            }



            this.target_ = "";
            this.trigger_ = "";
            this.effect_ = "";
            this.bonus_ = "";
            for (int c = 3; c < mem.length; c++) {
                String[] emp = mem[c].split(":");
                if (emp[0].equals("Trigger")) {
                    this.trigger_ = emp[1];
                }
                if (emp[0].equals("Target")) {
                    this.target_ = emp[1];
                }
                if (emp[0].equals("Effect")) {
                    this.effect_ = emp[1];
                }
                if (emp[0].equals("Bonus")) {
                    this.bonus_ = emp[1];
                }
            }
        }
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
        return "Ability: " + this.name_ + " | " + this.frequency_ + " | " + action_ + " | " + target_ + " | " + trigger_ + " | " + effect_ + " "+ this.bonus_ +" |%n";
    }

}
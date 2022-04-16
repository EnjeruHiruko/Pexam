package Pexam.data.Abilities;
import Pexam.data.utility.Enums.Action;
import Pexam.data.utility.Enums.Frequency;
import Pexam.data.utility.Misc.EnumHandler;

import java.util.List;


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

    public Abilities(String name, List<Abilities> dex){
        int thrust;
        String temp = name.replaceAll("\\R+", "");
        //System.out.println(temp);
        //System.out.println(dex.contains(new Abilities(temp)));
        if(dex.contains(new Abilities(temp))){
            thrust = dex.indexOf(new Abilities(temp));
            //System.out.println(dex.get(thrust));
            this.name_ = temp;
            this.frequency_ = dex.get(thrust).getFrequency();
            this.action_ = dex.get(thrust).getAction();
            this.target_ = dex.get(thrust).getTarget();
            this.trigger_ = dex.get(thrust).getTrigger();
            this.effect_ = dex.get(thrust).getEffect();
            this.bonus_ = dex.get(thrust).getBonus();
        }
    }

    public Abilities(String input){
        this.name_ = input.replace("$", " ");
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

            for(int c = 0; c < mem.length; c++){
                mem[c] = mem[c].replaceAll("\\R+","");
            }
            //System.out.println(mem.length);
            this.name_ = mem[1].trim();
            String[] temp = mem[2].split(" ");
            //System.out.println(Arrays.toString(temp));

            if(temp.length == 1){
                //System.out.println("AYAYAYAYAYAYAYAYAYAYYAA");
                String[] yikes = new String[1];
                yikes[0] = temp[0];
                this.frequency_ = new Frequency(yikes);
            }else{
                int ayaya = 0;
                for(int c = 0; c < temp.length; c++){
                    if(temp[c].length() < 2){
                        ayaya = c;
                        break;
                    }
                }
                //System.out.println(ayaya);
                String[] monka = new String[ayaya];
                for(int c = 0; c < ayaya; c++){
                    monka[c] = temp[c];
                }
                this.frequency_ = new Frequency(monka);
                String kekw = "";
                for(int c = 1+ayaya; c < temp.length; c++){
                    kekw += temp[c] + " ";
                }
                this.action_ = EnumHandler.ActionHandler(kekw);
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

    public String getBonus(){
        return this.bonus_;
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
            return this.name_.equalsIgnoreCase(another.getName());
        }
        return false;
    }

    public String toString(){
        return this.name_;
        //return "Ability: " + this.name_ + " | " + this.frequency_ + " | " + action_ + " | " + target_ + " | " + trigger_ + " | " + effect_ + " | "+ this.bonus_ +" |";
    }

}
package Pexam.data.Capabilities;
import Pexam.data.utility.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Capabilities{

    private String name_;

    private String description_;

    private int value_;

    //Constructor and creation block

    public Capabilities(){
        this.name_ = "";
        this.description_ = "";
        this.value_ = 0;
    }

    public Capabilities(String input){
        String[] temp = input.split("#");
        if(temp.length == 1){
            this.name_ = temp[0];
        }else if(temp.length == 2){
            this.name_ = temp[0];
            this.value_ = Integer.parseInt(temp[1]);
        }

        //todo check if everything works
    }

    public Capabilities(String input, List<Capabilities> cList){
        String[] temp = input.split("#");
        int tooDeep;
        if(temp.length == 1){
            if(cList.contains(temp[0])){
                tooDeep = cList.indexOf(temp[0]);
                this.name_ = temp[0];
                this.description_ = cList.get(tooDeep).getDescription();
                this.value_ = 1;
            }else {
                this.name_ = temp[0];
            }
        }else if(temp.length == 2){
            if(cList.contains(temp[0])){
                tooDeep = cList.indexOf(temp[0]);
                this.name_ = temp[0];
                this.description_ = cList.get(tooDeep).getDescription();
            }else {
                this.name_ = temp[0];

            }
            this.value_ = Integer.valueOf(temp[1]);
        }

        //todo check if everything works
    }

    //Getter block

    public String getName() {
        return this.name_;
    }

    public String getDescription() {
        return this.description_;
    }

    public int getValue() {
        return this.value_;
    }

    //Setter Block

    public void setName(String name) {
        this.name_ = name;
    }

    public void setDescription(String description) {
        this.description_ = description;
    }

    public void setValue(int value) {
        this.value_ = value;
    }

    //misc block

    public String toString(){
        return name_ + " | " + value_ + " | " + description_ + " |%n";
    }

}
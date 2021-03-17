package Pexam.data.utility.Describtions;

public class MiscInfo{

    //size
    double height_;

    double weight_;

    //breeding information
    double genderratio_;

    String egggroup_;

    int avhatchrate_;

    //other stuff
    String diet_;

    String habitat_;

    public MiscInfo(){
        this.height_ = 0.0;
        this.weight_ = 0.0;
        this.genderratio_ = 0.5;
        this.egggroup_ = "";
        this.avhatchrate_ = 0;
        this.diet_ = "all";
        this.habitat_ = "dead";
    }

    public MiscInfo(String[] input){
        this.height_ = Double.parseDouble(input[0]);
        this.weight_ = Double.parseDouble(input[1]);
        String temp = input[2].replace("$", " ");
        String[] mem = temp.split(" ");
        if(mem.length > 1){
            this.genderratio_ = 200.2;
        }else {
            try {
                this.genderratio_ = Double.parseDouble(input[2]);
            }catch(Exception e){
                this.genderratio_ = 300.3;
            }
        }
        this.egggroup_ = input[3];
        this.avhatchrate_ = Integer.parseInt(input[4]);
        this.diet_ = input[5];
        this.habitat_ = input[6];
    }

    public String toString(){
        return "Sizes: Height: " + height_ + " Weight: " + weight_ + "%nGenderrate m/f: " + genderratio_ + " Egggroup:" + egggroup_ + " hatchtime in days: " + avhatchrate_ + "%nDiet:" + diet_ + " Habitat:" + habitat_ + "%n";
    }

}
package Pexam.data.Items;

public class Items{

    private String name_;

    private String desciption_;

    // Constructor Block

    public Items(){
        this.name_ = "";
        this.desciption_ = "";
    }

    //Getter block

    public String getName() {
        return this.name_;
    }

    public String getDesciption() {
        return this.desciption_;
    }

    //Setter block

    public void setName(String name) {
        this.name_ = name;
    }

    public void setDesciption(String desciption) {
        this.desciption_ = desciption;
    }

    //misc block

}
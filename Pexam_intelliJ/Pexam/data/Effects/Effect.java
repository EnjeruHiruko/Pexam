package Pexam.data.Effects;

public class Effect {

    private String name_;

    private String description;

    public Effect (String[] args){
        this.name_ = args[0];
        this.description = args[1];
    }

    public String getName_() {
        return name_;
    }

    public String getDescription() {
        return description;
    }
}

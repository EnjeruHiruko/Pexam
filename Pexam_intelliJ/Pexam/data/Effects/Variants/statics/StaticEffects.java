package Pexam.data.Effects.Variants.statics;

import Pexam.data.Combatant.Pokemon.Pokemon;
import Pexam.data.Effects.Effect;

public class StaticEffects implements Effect {

    private String description_;

    private String coded_effect_;

    public StaticEffects(String effect,String description){
        this.coded_effect_ = effect;
        this.description_ = description;
    }

    public void causeEffect(){

    }

    @Override
    public String getDescription() {
        return description_;
    }
}

package Pexam.data.Effects.Variants.Immunity;

import Pexam.data.utility.Enums.Type;

public class Immunity {

    private Type immunity_;

    public Immunity(Type in){
        this.immunity_ = in;
    }

    public Type getImmunity(){
        return this.immunity_;
    }

}
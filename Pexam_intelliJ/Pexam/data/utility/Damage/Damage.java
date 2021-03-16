package Pexam.data.utility.Damage;

import Pexam.data.utility.Enums.Type;

public class Damage{

    private String MoveName_;

    private int value_;

    private Type type_;

    private DamageClass damage_class_;

    public Damage( int value, Type type, DamageClass damage_class, String movename){
        this.value_ = value;
        this.type_ = type;
        this.damage_class_ = damage_class;
        this.MoveName_ = movename;
    }

    public Damage(){
        this.value_ = 0;
        this.type_ = Type.UKN;
        this.damage_class_ = DamageClass.NON;
        this.MoveName_ = "Non";
    }

    public int getValue() {
        return value_;
    }

    public Type getType() {
        return type_;
    }

    public DamageClass getDamageClass() {
        return damage_class_;
    }

    public String getMoveName(){
        return this.MoveName_;
    }
}
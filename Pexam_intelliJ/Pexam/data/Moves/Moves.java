package Pexam.data.Moves;

import Pexam.data.Statblock.StatBlock;
import Pexam.data.utility.Damage.Damage;
import Pexam.data.utility.Damage.DamageBase;
import Pexam.data.utility.Damage.DamageClass;
import Pexam.data.utility.Enums.Frequency;
import Pexam.data.utility.Enums.Type;
import Pexam.data.utility.Misc.EnumHandler;

import java.util.List;

public class Moves{

    private String name_;

    private Type type_;

    private Frequency frequency_;

    private int AC_;

    private DamageBase DB_;

    private DamageClass damageClass_;

    private String Range_;

    private String Effect_;

    private String ContestType_; // TODO: 29/07/2020 enum of contest type

    private String ContestEffect_; // TODO: 29/07/2020 enum of contest effect


    //Constructor and other move editing methods

    public Moves(){
        this.name_ = "";
        this.type_ = Type.UKN;
        this.frequency_ = new Frequency();
        this.AC_ = 0;
        this.DB_ = DamageBase.NON;
        this.damageClass_ = DamageClass.NON;
        this.Range_ = "empty move";
        this.Effect_ = "empty move";
        this.ContestType_ = "empty move";
        this.ContestEffect_ = "empty move";
    }

    public Moves(String input){
        this.name_ = input.replace("$", " ");
        this.type_ = Type.UKN;
        this.frequency_ = new Frequency();
        this.AC_ = 0;
        this.DB_ = DamageBase.NON;
        this.damageClass_ = DamageClass.NON;
        this.Range_ = "placeholder move";
        this.Effect_ = "placeholder move";
        this.ContestType_ = "placeholder move";
        this.ContestEffect_ = "placeholder move";
    }

    public Moves(String input, List<Moves> mList){
        int thrust;
        if(mList.contains(input)){
            thrust = mList.indexOf(input);
            this.name_ = input;
            this.type_ = mList.get(thrust).getType();
            this.frequency_ = mList.get(thrust).getFrequency();
            this.AC_ = mList.get(thrust).getAC();
            this.DB_ = mList.get(thrust).getDB();
            this.damageClass_ = mList.get(thrust).getDamageClass();
            this.Range_ = mList.get(thrust).getRange();
            this.Effect_ = mList.get(thrust).getEffect();
            this.ContestType_ = mList.get(thrust).getContestType();
            this.ContestEffect_ = mList.get(thrust).getContestEffect();
        }
    }

    public Moves(String[] input){
        //System.out.println(input.length);
        String[] mem = input;
        if(mem.length > 0) {
            this.name_ = mem[1];
            this.type_ = EnumHandler.TypeHandler(mem[2]);
            //System.out.println(mem[2]);
            //System.out.println(EnumHandler.TypeHandler(mem[2]));
            this.frequency_ = new Frequency(mem[3].split(" "));
            //System.out.printf(Arrays.toString(mem));
            this.AC_ = EnumHandler.AcHandler(mem[4]);
            if (mem.length < 11) {
                this.DB_ = DamageBase.NON;
                this.damageClass_ = EnumHandler.DamageClassHandler(mem[5].trim());
                this.Range_ = mem[6];
                this.Effect_ = mem[7];
                this.ContestType_ = mem[8];
                this.ContestEffect_ = mem[9];
            } else {


                this.DB_ = EnumHandler.DamageBaseHandler(mem[5].split(":")[0].trim());
                this.damageClass_ = EnumHandler.DamageClassHandler(mem[6].trim());
                this.Range_ = mem[7];
                this.Effect_ = mem[8];
                this.ContestType_ = mem[9];
                this.ContestEffect_ = mem[10];
            }
        }
    }

    public void createMove(String info){
        String[] mem = info.split("\n");
        this.name_ = mem[0];
        this.type_ = Type.valueOf(mem[1]);
        this.frequency_ = new Frequency(mem[2]);
        this.AC_ = Integer.valueOf(mem[3]);
        this.DB_ = DamageBase.valueOf(mem[4]);
        this.damageClass_ = DamageClass.valueOf(mem[5]);
        this.Range_ = mem[6];
        this.Effect_ = mem[7];
        this.ContestType_ = mem[8];
        this.ContestEffect_ = mem[9];
    }

    public void fromMove(Moves reference){
        this.name_ = reference.getName();
        this.type_ = reference.getType();
        this.frequency_ = reference.getFrequency();
        this.AC_ = reference.getAC();
        this.DB_ = reference.getDB();
        this.damageClass_ = reference.getDamageClass();
        this.Range_ = reference.getRange();
        this.Effect_ = reference.getEffect();
        this.ContestType_ = reference.getContestType();
        this.ContestEffect_ = reference.getContestEffect();
    }

    //getter block

    public String getName() {
        return this.name_;
    }

    public Type getType() {
        return this.type_;
    }

    public Frequency getFrequency() {
        return this.frequency_;
    }

    public int getAC() {
        return this.AC_;
    }

    public DamageBase getDB() {
        return this.DB_;
    }

    public DamageClass getDamageClass() {
        return this.damageClass_;
    }

    public String getRange() {
        return this.Range_;
    }

    public String getEffect() {
        return this.Effect_;
    }

    public String getContestType() {
        return this.ContestType_;
    }

    public String getContestEffect() {
        return this.ContestEffect_;
    }

    //Setter block

    public void setName(String name) {
        this.name_ = name;
    }

    public void setType(Type type) {
        this.type_ = type;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency_ = frequency;
    }

    public void setAC(int AC) {
        this.AC_ = AC;
    }

    public void setDB(DamageBase DB) {
        this.DB_ = DB;
    }

    public void setDamageClass(DamageClass damageClass) {
        this.damageClass_ = damageClass;
    }

    public void setRange(String range) {
        this.Range_ = range;
    }

    public void setEffect(String effect){
        this.Effect_ = effect;
    }

    public void setContestType(String contestType) {
        this.ContestType_ = contestType;
    }

    public void setContestEffect(String contestEffect) {
        this.ContestEffect_ = contestEffect;
    }

    //misc stuff

    @Override
    public boolean equals(Object other){
        if(other instanceof String){
            String another = (String) other;
            if(this.name_.equals(another)){
                return true;
            } else {
                return false;
            }
        }
        if(other instanceof Moves){
            Moves bnother = (Moves) other;
            if(this.name_.equals(bnother.name_)){
                return true;
            } else {
                return false;
            }
        }
        if(other instanceof MoveForList){
            MoveForList cnother = (MoveForList) other;
            if(this.equals(cnother.getMove())){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }


    public String toString(){

        if(this.type_ == Type.UKN){
            return "Move: " + name_ + "%n";
        }else {
            return "Move: " + name_ + " | " + type_ + " | " + frequency_ + " | " + AC_ + " | " + DB_ + " | " + damageClass_ + " | " + Range_  + " | " + Effect_ + " |%n";

        }
    }

    public String toPrint(){
        if(this.type_ == Type.UKN){
            return "" + name_ + "%n";
        }else{
            return "" + name_ + " --- " + type_ + " --- " + frequency_ + " --- " + AC_ + " --- " + DB_ + " --- " + damageClass_ + " --- " + Range_  + " --- " + Effect_ + "---%n";
        }
    }

    private DamageBase addDBMod(int mod){
        if(this.DB_ != DamageBase.NON) {
            if(this.DB_.ordinal() + mod > 28){
                return DamageBase.DB28;
            }
            switch (this.DB_.ordinal() + mod) {
                case 1: return DamageBase.DB1;
                case 2: return DamageBase.DB2;
                case 3: return DamageBase.DB3;
                case 4: return DamageBase.DB4;
                case 5: return DamageBase.DB5;
                case 6: return DamageBase.DB6;
                case 7: return DamageBase.DB7;
                case 8: return DamageBase.DB8;
                case 9: return DamageBase.DB9;
                case 10: return DamageBase.DB10;
                case 11: return DamageBase.DB11;
                case 12: return DamageBase.DB12;
                case 13: return DamageBase.DB13;
                case 14: return DamageBase.DB14;
                case 15: return DamageBase.DB15;
                case 16: return DamageBase.DB16;
                case 17: return DamageBase.DB17;
                case 18: return DamageBase.DB18;
                case 19: return DamageBase.DB19;
                case 20: return DamageBase.DB20;
                case 21: return DamageBase.DB21;
                case 22: return DamageBase.DB22;
                case 23: return DamageBase.DB23;
                case 24: return DamageBase.DB24;
                case 25: return DamageBase.DB25;
                case 26: return DamageBase.DB26;
                case 27: return DamageBase.DB27;
                case 28: return DamageBase.DB28;
            }
        }
        return DamageBase.NON;
    }

    public Damage calcDamageOutput(StatBlock CombatStats, List<Type> PokemonTypes, int DiceRole, boolean averageRole, boolean crit){
        int STABmod = 2;
        int damage = 0;
        if(this.damageClass_ != DamageClass.STATUS){
            if(this.damageClass_ == DamageClass.PHYSICAL){
                if(PokemonTypes.contains(this.type_)){
                    DamageBase temp = addDBMod(STABmod);
                    if(averageRole){
                        damage += CombatStats.getCombatAttack();
                        System.out.println(damage);
                        if(crit){
                            damage += temp.getAverageDamage() + temp.getAverageDamage();
                        }else {
                            damage += temp.getAverageDamage();
                        }
                        System.out.println("kekus"); //debug print
                        return new Damage(damage, this.type_, this.damageClass_, this.name_);
                    }else{
                        damage += CombatStats.getCombatAttack();
                        if(crit){
                            damage += DiceRole + DiceRole;
                            damage += temp.getDamageMod() + temp.getDamageMod();
                        }else {
                            damage += temp.getDamageMod();
                            damage += DiceRole;
                        }
                        return new Damage(damage, this.type_, this.damageClass_, this.name_);
                    }
                }else{
                    if(averageRole) {
                        damage += CombatStats.getCombatAttack();
                        if (crit) {
                            damage += this.DB_.getAverageDamage() + this.DB_.getAverageDamage();
                        }else{
                            damage += this.DB_.getAverageDamage();
                        }
                        return new Damage(damage, this.type_, this.damageClass_, this.name_);
                    }else{
                        damage += CombatStats.getCombatAttack();
                        if(crit){
                            damage += DiceRole + DiceRole;
                            damage += this.DB_.getDamageMod() + this.DB_.getDamageMod();
                        }else {
                            damage += this.DB_.getDamageMod();
                            damage += DiceRole;
                        }
                        return new Damage(damage, this.type_, this.damageClass_, this.name_);
                    }
                }
            }
            if(this.damageClass_ == DamageClass.SPECIAL){
                if(PokemonTypes.contains(this.type_)){
                    DamageBase temp = addDBMod(STABmod);
                    if (averageRole){
                        damage += CombatStats.getCombatSpecialAttack();
                        if(crit){
                            damage += temp.getAverageDamage() + temp.getAverageDamage();
                        }else {
                            damage += temp.getAverageDamage();
                        }
                        return new Damage(damage, this.type_, this.damageClass_, this.name_);
                    }else{
                        damage += CombatStats.getCombatSpecialAttack();
                        if(crit){
                            damage += DiceRole + DiceRole;
                            damage += temp.getDamageMod() + temp.getDamageMod();
                        }else {
                            damage += temp.getDamageMod();
                            damage += DiceRole;
                        }
                        return new Damage(damage, this.type_, this.damageClass_, this.name_);
                    }
                }else{
                    if(averageRole){
                        damage += CombatStats.getCombatSpecialAttack();
                        if (crit) {
                            damage += this.DB_.getAverageDamage() + this.DB_.getAverageDamage();
                        }else{
                            damage += this.DB_.getAverageDamage();
                        }
                        return new Damage(damage, this.type_, this.damageClass_, this.name_);
                    }else{
                        damage += CombatStats.getCombatSpecialAttack();
                        if(crit){
                            damage += DiceRole + DiceRole;
                            damage += this.DB_.getDamageMod() + this.DB_.getDamageMod();
                        }else {
                            damage += this.DB_.getDamageMod();
                            damage += DiceRole;
                        }
                        return new Damage(damage, this.type_, this.damageClass_, this.name_);
                    }
                }
            }
        }else{
            return new Damage(damage, this.type_, this.damageClass_, this.name_);
        }
        return new Damage(damage, this.type_, this.damageClass_, this.name_);
    }

}
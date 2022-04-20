package Pexam.data.utility.Misc;

import Pexam.data.utility.Damage.DamageBase;
import Pexam.data.utility.Damage.DamageClass;
import Pexam.data.utility.Enums.Action;
import Pexam.data.utility.Enums.Freq;
import Pexam.data.utility.Enums.Type;

public class EnumHandler {

    /**
     * Method which returns the enum of TYPE depending on String input
     * @param in String of Type
     * @return Type enum
     */
    public static Type TypeHandler(String in){
        String temp = in.toUpperCase();
        Type well = Type.TYPELESS;
        switch (temp.trim()){
            case "NORMAL": well = Type.NORMAL; break;
            case "FIRE": well = Type.FIRE;break;
            case "WATER": well = Type.WATER;break;
            case "ELECTRIC": well = Type.ELECTRIC;break;
            case "GRASS": well = Type.GRASS;break;
            case "ICE": well = Type.ICE; break;
            case "FIGHTING": well = Type.FIGHTING;break;
            case "POISON": well = Type.POISON;break;
            case "GROUND": well = Type.GROUND;break;
            case "FLYING": well = Type.FLYING;break;
            case "PSYCHIC": well = Type.PSYCHIC;break;
            case "BUG": well = Type.BUG; break;
            case "ROCK": well = Type.ROCK;break;
            case "GHOST": well = Type.GHOST;break;
            case "DRAGON": well = Type.DRAGON;break;
            case "DARK": well = Type.DARK;break;
            case "STEEL": well = Type.STEEL;break;
            case "FAIRY": well = Type.FAIRY;break;
            case "": well = Type.TYPELESS;break;
        }
        return well;
    }

    public static DamageBase DamageBaseHandler(String in){
        switch (in.toUpperCase().trim()){
            case "": return DamageBase.NON;
            case "NONE": return DamageBase.NON;
            case "1": return DamageBase.DB1;
            case "2": return DamageBase.DB2;
            case "3": return DamageBase.DB3;
            case "4": return DamageBase.DB4;
            case "5": return DamageBase.DB5;
            case "6": return DamageBase.DB6;
            case "7": return DamageBase.DB7;
            case "8": return DamageBase.DB8;
            case "9": return DamageBase.DB9;
            case "10": return DamageBase.DB10;
            case "11": return DamageBase.DB11;
            case "12": return DamageBase.DB12;
            case "13": return DamageBase.DB13;
            case "14": return DamageBase.DB14;
            case "15": return DamageBase.DB15;
            case "16": return DamageBase.DB16;
            case "17": return DamageBase.DB17;
            case "18": return DamageBase.DB18;
            case "19": return DamageBase.DB19;
            case "20": return DamageBase.DB20;
            case "21": return DamageBase.DB21;
            case "22": return DamageBase.DB22;
            case "23": return DamageBase.DB23;
            case "24": return DamageBase.DB24;
            case "25": return DamageBase.DB25;
            case "26": return DamageBase.DB26;
            case "27": return DamageBase.DB27;
            case "28": return DamageBase.DB28;
        }
        return DamageBase.NON;
    }

    public static DamageClass DamageClassHandler(String in){
        switch (in.toUpperCase().trim()){
            case "SPECIAL": return DamageClass.SPECIAL;
            case "PHYSICAL": return DamageClass.PHYSICAL;
            case "STATUS": return DamageClass.STATUS;
            case "": return DamageClass.NON;
            case "NONE": return DamageClass.NON;
        }
        return DamageClass.NON;
    }

    public static Freq FreqHandler(String in){
        String temp = in.toUpperCase();
        Freq well = Freq.NON;
        switch (temp.trim()){
            case "AT-WILL": well = Freq.AW;break;
            case "SCENE": well = Freq.SCENE;break;
            case "STATIC": well = Freq.STATIC;break;
            case "DAILY": well = Freq.DAILY;break;
            case "EOT": well = Freq.EOT;break;
            case "": well = Freq.NON;break;
        }
        return well;
    }

    public static int AcHandler(String in){
        if(in.trim().equalsIgnoreCase("None")){
            return 0;
        }else{
            return Integer.parseInt(in.trim());
        }
    }

    public static Action ActionHandler(String in){
        String temp = in.toUpperCase();
        Action well = Action.NON;
        switch (temp.trim()){
            case "SHIFT ACTION": well = Action.SHIFT;break;
            case "SWIFT ACTION": well = Action.SWIFT;break;
            case "STANDARD ACTION": well = Action.STANDARD;break;
            case "FULL ACTION": well = Action.FULL;break;
            case "FREE ACTION": well = Action.FREE;break;
            case "EXTENDED ACTION": well = Action.EXTENDED;break;
            case "": well = Action.NON;
        }
        return well;
    }

}
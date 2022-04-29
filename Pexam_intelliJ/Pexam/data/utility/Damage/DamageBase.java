package Pexam.data.utility.Damage;

public enum DamageBase {
    NON(new int[]{0,0,0}, new int[]{0,0,0}, "   "),
    DB1(new int[]{1,6,1}, new int[]{2,5,7}, "DB1"),
    DB2(new int[]{1,6,3}, new int[]{4,7,9}, "DB2"),
    DB3(new int[]{1,6,5}, new int[]{6,9,11}, "Db3"),
    DB4(new int[]{1,8,6}, new int[]{7,11,14}, "DB4"),
    DB5(new int[]{1,8,8}, new int[]{9,13,16}, "DB5"),
    DB6(new int[]{2,6,8}, new int[]{10,15,20}, "DB6"),
    DB7(new int[]{2,6,10}, new int[]{12,17,22}, "DB7"),
    DB8(new int[]{2,8,10}, new int[]{12,19,26}, "DB8"),
    DB9(new int[]{2,10,10}, new int[]{12,21,30}, "DB9"),
    DB10(new int[]{3,8,10}, new int[]{13,24,34}, "DB10"),
    DB11(new int[]{3,10,10}, new int[]{13,27,40}, "DB11"),
    DB12(new int[]{3,12,10}, new int[]{13,30,46}, "DB12"),
    DB13(new int[]{4,10,10}, new int[]{14,35,50}, "DB13"),
    DB14(new int[]{4,10,15}, new int[]{19,40,55}, "DB14"),
    DB15(new int[]{4,10,20}, new int[]{24,45,60}, "DB15"),
    DB16(new int[]{5,10,20}, new int[]{25,50,70}, "DB16"),
    DB17(new int[]{5,12,25}, new int[]{30,60,85}, "DB17"),
    DB18(new int[]{6,12,25}, new int[]{31,65,97}, "DB18"),
    DB19(new int[]{6,12,30}, new int[]{36,70,102}, "DB19"),
    DB20(new int[]{6,12,35}, new int[]{41,75,107}, "DB20"),
    DB21(new int[]{6,12,40}, new int[]{46,80,112}, "DB21"),
    DB22(new int[]{6,12,45}, new int[]{51,85,117}, "DB22"),
    DB23(new int[]{6,12,50}, new int[]{56,90,122}, "DB23"),
    DB24(new int[]{6,12,55}, new int[]{61,95,127}, "DB24"),
    DB25(new int[]{6,12,60}, new int[]{66,100,132}, "DB25"),
    DB26(new int[]{7,12,65}, new int[]{72,110,149}, "DB26"),
    DB27(new int[]{8,12,70}, new int[]{78,120,166}, "DB27"),
    DB28(new int[]{8,12,80}, new int[]{88,130,176}, "DB28");

    /** The values defining the damage roll of this. */
    private final int[] roll;// = new int[3];

    /** The set damage values corresponding to this. */
    private final int[] set;// = new int[3];

    private final String print;

    DamageBase(int[] roll_, int[] set, String print){
        this.roll = roll_;
        this.set = set;
        this.print = print;
    }

    public int getAverageDamage(){
        return this.set[1]; // todo handle full range
    }

    public int getDamageMod(){
        return this.roll[2];
    }
}
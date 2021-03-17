package Pexam.cute;


import Pexam.cute.cuteutility.Database.Dex;

public class Cute{

    private final String standardWorld;

    private Dex database_;


    public Cute(){
        this.standardWorld = "ver105_5";
        this.database_ = new Dex(standardWorld, "All");
    }









    public static void main(String[] args){
        Cute test = new Cute();
        //System.out.printf(test.toString());
    }

}
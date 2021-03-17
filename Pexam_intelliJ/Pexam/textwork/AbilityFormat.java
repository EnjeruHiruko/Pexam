package Pexam.textwork;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

class AbilityFormat{

    static public Path source = Paths.get("Pexam/textwork/PTU_abilityDex2_ver105_5.txt");

    static public Path dispatch = Paths.get("Pexam/cute/cuteutility/ver105_5/AbilityDex.txt");

    static void readAbilityDex(Path in){
        try {
            Scanner temp = new Scanner(in).useDelimiter("Ability:\\v*");
            String printer = "";

            while(temp.hasNext()){
                String mem = temp.next();
                printer += work(mem);
                printer += "HOMELESS\n";

            }

            try{
                BufferedWriter writer = Files.newBufferedWriter(dispatch);
                writer.write(printer);
                writer.close();
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.println(printer);
            temp.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    static String work(String input){
        String regex = "%n";
        String temp = "";
        Scanner in = new Scanner(input).useDelimiter(regex);
        while(in.hasNext()){
            temp += in.next();
            System.out.println(temp);
            if(in.hasNext()){
                temp +="\n";
            }
        }
        in.close();
        return temp;
    }

    public static void main(String[] args){
        readAbilityDex(source);
    }

}
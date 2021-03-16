package Pexam.textwork;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

class MoveDexFormat{

    static public Path source = Paths.get("Pexam/textwork/PTU_moveDex2_ver105_5.txt");
    static public Path dispatch = Paths.get("Pexam/cute/cuteutility/ver105_5/MoveDex.txt");

    static void readMoveDex(Path in){
        try{
            Scanner temp = new Scanner(in).useDelimiter("Move:\\v*");
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
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(printer);
            temp.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    static String work(String input){
        String regex = "\\v*Type:\\v*|\\v*Frequency:\\v*|\\v*AC:\\v*|\\v*Damage Base\\v*|\\v*Class:\\v*|\\v*Range:\\v*|\\v*Effect:\\v*|\\v*Contest Type:\\v*|\\v*Contest Effect:\\v*|\\v*Special:\\v*";
        String temp = "";
        Scanner in = new Scanner(input).useDelimiter(regex);
        while (in.hasNext()){
            temp += in.next();
            if(in.hasNext()){
                temp += "\n";
            }
            //System.out.println(in.next());
        }
        //System.out.println(temp);
        in.close();
        return temp;
    }

    public static void main(String[] args){
        readMoveDex(source);
    }

}


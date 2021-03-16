package Pexam.cute.cuteutility.config;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class WorldConfiguration {

    private ArrayList<values> configuration_;

    public WorldConfiguration(String worldpath){
        this.configuration_ = new ArrayList<values>();
        Path source = Paths.get("Pexam/cute/cuteutility/"+worldpath+"/config.txt" );
        try(Scanner in = new Scanner(source) ){
            in.useDelimiter("\n");

            while(in.hasNext()){
                String temp = in.next();
                String[] lol = temp.split("=");
                if(!"///".equals(lol[0])){
                    /*
                    debug messages
                    System.out.println(lol[0]);
                    System.out.println(lol[1]);
                    */
                    this.configuration_.add(new values(lol));
                }
            }

        }catch(Exception mep){
            mep.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "WorldConfiguration{" +
                "configuration_=" + configuration_ +
                '}';
    }
}
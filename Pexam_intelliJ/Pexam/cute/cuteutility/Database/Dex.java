package Pexam.cute.cuteutility.Database;

import Pexam.cute.cuteutility.config.WorldConfiguration;
import Pexam.data.Abilities.Abilities;
import Pexam.data.Moves.Moves;
import Pexam.data.Pokemon.Species;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dex {

    private WorldConfiguration config_;

    private List<Moves> moveList_;

    private List<Abilities> abilityList_;

    private List<Species> pokeDex_;

    public Dex(String worldpath , String in){
        this.config_ = new WorldConfiguration(worldpath);
        this.moveList_ = new ArrayList<>();
        this.abilityList_ = new ArrayList<>();
        this.pokeDex_ = new ArrayList<>();
        createDex(worldpath, in);
    }

    public void createDex(String worldpath , String param){

        if(param.equals("Moves") || param.equals("all")) {

            Path file = Paths.get("Pexam/cute/cuteutility/"+worldpath+"/MoveDex.txt");
            try {
                Scanner in = new Scanner(file).useDelimiter("HOMELESS");
                while (in.hasNext()) {
                    moveList_.add(createMove(in.next()));
                }
                in.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.printf(moveList_.toString());
        }

        if(param.equals("Abilities") || param.equals("all")){
            Path file = Paths.get("Pexam/cute/cuteutility/"+worldpath+"/AbilityDex.txt");
            try{
                Scanner in = new Scanner(file).useDelimiter("HOMELESS");
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        if(param.equals("Pokemon") || param.equals("all")){
            Path file = Paths.get("Pexam/cute/cuteutility/"+worldpath+"/PokeDex.txt");


        }
    }

    private Moves createMove(String in){
        String[] mem = in.split("\n");
        return new Moves(mem);
    }

    public List<Moves> getMoveDex(){
        return this.moveList_;
    }

}
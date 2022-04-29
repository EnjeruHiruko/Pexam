package Pexam.data.Combatant.Pokemon;

import Pexam.data.Abilities.Abilities;
import Pexam.data.Capabilities.Capabilities;
import Pexam.data.Moves.MoveForList;
import Pexam.data.Moves.Moves;
import Pexam.data.utility.Describtions.MiscInfo;
import Pexam.data.utility.Describtions.Skill;
import Pexam.data.utility.Enums.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Species {

    private int DexNumber_;

    private String species_;

    private ArrayList<Type> types_;

    private int[] baseStats_;

    private ArrayList<Abilities> basicAbilities_;

    private ArrayList<Abilities> advAbilities_;

    private ArrayList<Abilities> highAbility_;

    private ArrayList<Evolution> evolutions_;

    private MiscInfo miscInfo_;

    private ArrayList<Capabilities> capabilities_;

    private ArrayList<Skill> skills_;

    private ArrayList<MoveForList> moveList_;

    private ArrayList<MoveForList> tmList_;

    private ArrayList<Moves> eggList_;

    private ArrayList<Moves> tutorList_;

    private ArrayList<Mega> MegaEvolutions_;

    public Species(){
        this.DexNumber_ = 0;
        this.species_ = "";
        this.baseStats_ = new int[6];
        this.types_ = new ArrayList<Type>();
        this.basicAbilities_ = new ArrayList<Abilities>();
        this.advAbilities_ = new ArrayList<Abilities>();
        this.highAbility_ = new ArrayList<Abilities>();
        this.capabilities_ = new ArrayList<Capabilities>();
        this.evolutions_ = new ArrayList<Evolution>();
        this.miscInfo_ = new MiscInfo();
        this.skills_ = new ArrayList<Skill>();
        this.moveList_ = new ArrayList<MoveForList>();
        this.tmList_ = new ArrayList<MoveForList>();
        this.eggList_ = new ArrayList<Moves>();
        this.tutorList_ = new ArrayList<Moves>();
        this.MegaEvolutions_ = new ArrayList<Mega>();
    }

    public Species(String input){
        this();
        createDexEntry(new Scanner(input).useDelimiter("\\n+"));
        //createDexEntry(input);
    }

    public Species(String in, String fill){
        this.species_ = in;
    }

    public void createDexEntry(String input){
        String[] mem = input.split("\\n+");
        this.DexNumber_ = Integer.valueOf(mem[1].trim());
        this.species_ = mem[2];
        this.assignBasestats(mem[3]);
        this.assignTypes(mem[4]);
        this.assignBasicAbilities(mem[5]);
        this.assignAdvAbilities(mem[6]);
        this.assignHighAbility(mem[7]);
        this.assignEvolutions(mem[8]);
        this.assignMiscInfo(mem[9]);
        this.assignCapabilities(mem[10]);
        this.assignSkills(mem[11]);
        this.assignMovelist(mem[12]);
        this.assignTmlist(mem[13]);
        this.assignEgglist(mem[14]);
        this.assignTutorlist(mem[15]);
    }


    public void createDexEntry(Scanner in) {

        in.next();

        /*
        //test
        while(in.hasNext()){
            String str = in.next();
            System.out.println(str);
        }
        */

        in.next();
        int temp = Integer.parseInt((in.next().replaceAll("\\R+", "")));
        this.DexNumber_ = temp;
        String mem = in.next().replaceAll("\\R+", "");
        this.species_ = mem;
        //System.out.println(this.species_ + "   " + this.DexNumber_);
        this.assignBasestats(in.next().replaceAll("\\R+", ""));
        this.assignTypes(in.next().replaceAll("\\R+", ""));

        this.assignBasicAbilities(in.next().replaceAll("\\R+", ""));
        this.assignAdvAbilities(in.next().replaceAll("\\R+", ""));
        this.assignHighAbility(in.next().replaceAll("\\R+", ""));

        this.assignEvolutions(in.next().replaceAll("\\R+", ""));
        this.assignMiscInfo(in.next().replaceAll("\\R+", ""));

        this.assignCapabilities(in.next().replaceAll("\\R+", ""));
        this.assignSkills(in.next().replaceAll("\\R+", ""));
        //System.out.println("ayaya");
        this.assignMovelist(in.next().replaceAll("\\R+", ""));
        //System.out.println("kekW");
        this.assignTmlist(in.next().replaceAll("\\R+", ""));
        //System.out.println("fin");
        this.assignEgglist(in.next().replaceAll("\\R+", ""));
        this.assignTutorlist(in.next().replaceAll("\\R+", ""));
        this.assignMega(in.next().replaceAll("\\R+", ""));
        in.close();
    }

    private void assignBasestats(String input){
        Scanner stats = new Scanner(input);
        for(int i = 0; i<this.baseStats_.length; i++) {
            this.baseStats_[i] = stats.nextInt();
        }
        stats.close();
    }

    private void assignTypes(String input){
        String[] temp = input.split("\\s+");
        for(String c : temp){
            this.types_.add(Type.valueOf(c));
        }
    }

    private void assignBasicAbilities(String input){
        String[] temp = input.split("\\s+");
        String[] minitemp;
        for(int c = 1; c < temp.length; c++){
            minitemp = temp[c].split("#");
            if(minitemp.length == 1){
                this.basicAbilities_.add(new Abilities(minitemp[0]));
            }else if(minitemp.length > 1){
                String tempo = "";
                for(int k = 0; k < minitemp.length; k++){
                    tempo += minitemp[k];
                    if(k != (minitemp.length - 1)){
                        tempo += " ";
                    }
                }
                this.basicAbilities_.add(new Abilities(tempo));
            }
        }

    }

    private void assignAdvAbilities(String input){
        String[] temp = input.split("\\s+");
        String[] minitemp;
        for(int c = 1; c < temp.length; c++){
            minitemp = temp[c].split("#");
            if(minitemp.length == 1){
                this.advAbilities_.add(new Abilities(minitemp[0]));
            }else if(minitemp.length > 1){
                String tempo = "";
                for(int k = 0; k < minitemp.length; k++){
                    tempo += minitemp[k];
                    if(k != (minitemp.length - 1)){
                        tempo += " ";
                    }
                }
                this.advAbilities_.add(new Abilities(tempo));
            }
        }
    }


    private void assignHighAbility(String input){
        String[] temp = input.split("\\s+");
        String[] minitemp = temp[1].split("#");
        for(int c = 1; c < temp.length; c++){
            minitemp = temp[c].split("#");
            if(minitemp.length == 1){
                this.highAbility_.add(new Abilities(minitemp[0]));
            }else if(minitemp.length > 1){
                String tempo = "";
                for(int k = 0; k < minitemp.length; k++){
                    tempo += minitemp[k];
                    if(k != (minitemp.length - 1)){
                        tempo += " ";
                    }
                }
                this.highAbility_.add(new Abilities(tempo));
            }
        }

    }


    private void assignEvolutions(String input){
        String[] temp = input.split("\\s+");
        String[] mem;
        for(int c = 1; c < temp.length; c++){
            //mem = temp[c].split("#");
            this.evolutions_.add(new Evolution(temp[c].split("#")));
        }
    }

    private void assignMiscInfo(String input){
        String[] temp = input.split("\\s+");
        this.miscInfo_ = new MiscInfo(temp);
    }

    private void assignCapabilities(String input){
        String[] temp = input.split("\\s+");
        for(String c : temp){
            if(!c.equals("cl")) {
                this.capabilities_.add(new Capabilities(c));
            }
        }
    }


    private void assignSkills(String input){
        String[] temp = input.split("\\s+");
        Skill[] mem = new Skill[6];
        for(int c = 1; c < temp.length; c++){
            if(!temp[c].trim().equalsIgnoreCase("sl")){
                skills_.add(new Skill(temp[c].split("#")));
            }
        }
    }

    private void assignMovelist(String input){
        String[] temp = input.split("\\s+");
        for(int c = 1; c < temp.length; c++){
            this.moveList_.add(new MoveForList(temp[c]));
        }
    }


    private void assignTmlist(String input){
        String[] temp = input.split("\\s+");
        for(int c = 1; c < temp.length; c++){
            this.tmList_.add(new MoveForList(temp[c]));
        }
    }


    private void assignEgglist(String input){
        String[] temp = input.split("\\s+");
        for(int c = 1; c < temp.length; c++){
            this.eggList_.add(new Moves(temp[c]));
        }
    }


    private void assignTutorlist(String input){
        String[] temp = input.split("\\s+");
        for(int c = 1; c < temp.length; c++){
            this.tutorList_.add(new Moves(temp[c]));
        }
    }

    private void assignMega(String input){

    }


    //Getter block

    public int getDexNumber() {
        return this.DexNumber_;
    }

    public String getSpecies() {
        return this.species_;
    }

    public int[] getBasestats() {
        return this.baseStats_;
    }

    public ArrayList<Type> getTypes() {
        return this.types_;
    }

    public ArrayList<Abilities> getBasicAbilities() {
        return this.basicAbilities_;
    }

    public ArrayList<Abilities> getAdvAbilities() {
        return this.advAbilities_;
    }

    public ArrayList<Abilities> getHighability() {
        return this.highAbility_;
    }

    public ArrayList<Evolution> getEvolutions() {
        return this.evolutions_;
    }

    public MiscInfo getMiscinfo() {
        return this.miscInfo_;
    }

    public ArrayList<Capabilities> getCapabilities() {
        return this.capabilities_;
    }

    public ArrayList<Skill> getSkills() {
        return this.skills_;
    }

    public ArrayList<MoveForList> getMovelist() {
        return this.moveList_;
    }

    public ArrayList<MoveForList> getTmlist() {
        return this.tmList_;
    }

    public ArrayList<Moves> getEgglist() {
        return this.eggList_;
    }

    public ArrayList<Moves> getTutorlist() {
        return this.tutorList_;
    }

    //Setter block

    public void setDexnumber(int dexnumber) {
        this.DexNumber_ = dexnumber;
    }

    public void setSpecies(String species) {
        this.species_ = species;
    }

    public void setBasestats(int[] basestats) {
        this.baseStats_ = basestats;
    }

    public void setTypes(ArrayList<Type> types) {
        this.types_ = types;
    }

    public void setBasicAbilities(ArrayList<Abilities> basicAbilities) {
        this.basicAbilities_ = basicAbilities;
    }

    public void setAdvAbilities(ArrayList<Abilities> advAbilities) {
        this.advAbilities_ = advAbilities;
    }

    public void setHighability(ArrayList<Abilities> highability) {
        this.highAbility_ = highability;
    }

    public void setEvolutions(ArrayList<Evolution> evolutions) {
        this.evolutions_ = evolutions;
    }

    public void setMiscinfo(MiscInfo miscinfo) {
        this.miscInfo_ = miscinfo;
    }

    public void setCapabilities(ArrayList<Capabilities> capabilities) {
        this.capabilities_ = capabilities;
    }

    public void setSkills(ArrayList<Skill> skills) {
        this.skills_ = skills;
    }

    public void setMovelist(ArrayList<MoveForList> movelist) {
        this.moveList_ = movelist;
    }

    public void setTmlist(ArrayList<MoveForList> tmlist) {
        this.tmList_ = tmlist;
    }

    public void setEgglist(ArrayList<Moves> egglist) {
        this.eggList_ = egglist;
    }

    public void setTutorlist(ArrayList<Moves> tutorlist) {
        this.tutorList_ = tutorlist;
    }

    //misc block

    public void update_Filler(Object other){

        if(other instanceof Moves){
            Moves another = (Moves) other;
            if(this.moveList_.contains(another)){
                //System.out.println("fizwfewzvfuwevfewvfuwvfuew");
                MoveForList temp = this.moveList_.get(this.moveList_.indexOf(another));
                this.moveList_.set(this.moveList_.indexOf(another), new MoveForList(temp.getReqLevel(), another));
            }
            if(this.eggList_.contains(another)){
                this.eggList_.set(this.eggList_.indexOf(another), another);
            }
            if(this.tmList_.contains(another)){
                MoveForList temp = this.tmList_.get(this.tmList_.indexOf(another));
                this.tmList_.set(this.tmList_.indexOf(another), new MoveForList(temp.getReqLevel(), another));
            }
            if(this.tutorList_.contains(another)){
                this.tutorList_.set(this.tutorList_.indexOf(another), another);
            }
        }
        if(other instanceof Abilities){
            Abilities another = (Abilities) other;
            if(this.basicAbilities_.contains(another)){
                this.basicAbilities_.set(this.basicAbilities_.indexOf(another), another);
            }
            if(this.advAbilities_.contains(another)){
                this.advAbilities_.set(this.advAbilities_.indexOf(another), another);
            }
            if(this.highAbility_.contains(another)){
                this.highAbility_.set(this.highAbility_.indexOf(another), another);
            }
        }
        if(other instanceof  Capabilities){

        }
    }

    @Override
    public boolean equals(Object other){

        if(other instanceof Species){
            if(this.getSpecies().equalsIgnoreCase(((Species) other).getSpecies())){
                return true;
            }
        }
        if(other instanceof String){
            if(this.getSpecies().equalsIgnoreCase((String) other)){
                return true;
            }
        }
        if(other instanceof Integer){
            if(this.DexNumber_ == (int) other){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Species{" +
                "dexnumber_=" + this.DexNumber_ +
                ", species_='" + this.species_  +
                ", types_=" + types_ +
                ", basestats_=" + Arrays.toString(baseStats_) +
                ", basicAbilities_=" + basicAbilities_ +
                ", advAbilities_=" + advAbilities_ +
                ", highability_=" + highAbility_ +
                ", evolutions_=" + evolutions_ +
                ", miscinfo_=" + miscInfo_ +
                ", capabilities_=" + capabilities_ +
                ", skills_=" + skills_ +
                ", movelist_=" + moveList_ +
                ", tmlist_=" + tmList_ +
                ", egglist_=" + eggList_ +
                ", tutorlist_=" + tutorList_ +
                '}';
    }

    public String showcase(){ //todo make it right
        if(getDexNumber() != 0) {
            String temp = "No°" + this.DexNumber_ + "\t|" + this.species_ + "\t| " + types_.get(0);
            if (this.types_.size() > 1) {
                temp += "/" + types_.get(1);
            }
            return temp;
        }else{
            return "";
        }
    }
}
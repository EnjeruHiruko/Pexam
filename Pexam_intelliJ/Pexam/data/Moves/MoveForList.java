package Pexam.data.Moves;

import java.util.List;

public class MoveForList {

    private int reqLevel_;

    private Moves move_;

    private boolean vm_;

    private boolean onEvo_;

    //Constructor and Creation block

    public MoveForList(){
        this.reqLevel_ = 0;
        this.move_ = new Moves();
    }

    public MoveForList(String input){
        String ayaya = input.replaceFirst("#", "---" );
        String[] mem = ayaya.split("---");

        if(mem[0].trim().equalsIgnoreCase("Evo")){
            this.move_ = new Moves(mem[1]);
            this.reqLevel_ = 0;
            this.onEvo_ = true;
        }else{
            if(Integer.parseInt(mem[0]) > 0 ){
                this.reqLevel_ = Integer.parseInt(mem[0].trim());
                this.move_ = new Moves(mem[1]);
            }
            if(Integer.parseInt(mem[0]) < 0){
                this.vm_ = true;
                this.reqLevel_ = Integer.parseInt(mem[0].trim());
                this.move_ = new Moves(mem[1]);
            }

        }

    }

    public MoveForList(int level, Moves move){
        this.reqLevel_ = level;
        this.move_ = move;
    }

    public MoveForList(String input, List<Moves> mList){
        String[] mem = input.split("#");
        String lel = "";
        int c2 = 0;
        for(int c = 0; c < mem.length; c++){
            if(c == 0 && Integer.valueOf(mem[0]) != 1337 ) {
                this.reqLevel_ = Integer.valueOf(mem[c]);
            }
            if(c != 0 && Integer.valueOf(mem[0]) != 1337){
                if(mem.length == c2+1){
                    lel += mem[c];
                    this.move_ = new Moves(lel, mList);
                } else {
                    lel += mem[c] + " ";
                }
            }
            if(Integer.valueOf(mem[0]) == 1337){
                this.reqLevel_ = 0;
                this.move_ = new Moves(mem[2],mList);
            }
            c2 = c;
        }
    }

    //Getter block

    public int getReqLevel() {
        return this.reqLevel_;
    }

    public Moves getMove() {
        return this.move_;
    }

    //Setter block

    public void setReqLevel(int reqLevel) {
        this.reqLevel_ = reqLevel;
    }

    public void setMove(Moves move) {
        this.move_ = move;
    }

    //misc block

    public boolean equals(Object other){

        if(other instanceof MoveForList){
            if(this.move_.equals(other)){
                return true;
            }else{
                return false;
            }
        }
        if(other instanceof Moves){
            if(this.move_.equals(other)){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    public String toString(){
        if(this.vm_){
            return "VM " + this.reqLevel_ + " " + move_;
        }else {
            return "" + this.reqLevel_ + " " + move_;
        }
    }

}
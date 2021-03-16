package Pexam.data.Moves;

public class MovesCompare{

    private int level_;

    public MovesCompare(int level){
        this.level_ = level;
    }

    public boolean equals(Object other){

        if(other instanceof MoveForList){
            MoveForList temp = (MoveForList) other;
            if(temp.getReqLevel() == this.level_){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }



}
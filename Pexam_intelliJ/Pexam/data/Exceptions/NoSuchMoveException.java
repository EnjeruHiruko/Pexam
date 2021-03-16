package Pexam.data.Exceptions;

public class NoSuchMoveException extends Exception{
    public NoSuchMoveException(){
        super("This Move does not Exist");
    }
}
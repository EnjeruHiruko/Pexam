package Pexam.data.Effects.Variants.Connection;

import Pexam.data.Moves.Moves;

public class Connection {

    private Moves connection_;

    public Connection(String in){
        this.connection_ = new Moves(in);
    }

    public Connection(Moves in){
        this.connection_ = in;
    }

    public Moves getConnection() {
        return this.connection_;
    }
}
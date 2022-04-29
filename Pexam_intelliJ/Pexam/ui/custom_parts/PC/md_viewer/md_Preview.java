package Pexam.ui.custom_parts.PC.md_viewer;

import Pexam.data.Moves.Moves;
import Pexam.data.utility.Enums.Type;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class md_Preview extends GridPane {

    private Moves current_;

    private Label out_;

    public md_Preview(){
        super();

        this.current_ = new Moves();

        out_ = new Label();
        out_.setWrapText(true);
        out_.setMaxSize(400, 600);
        if(current_.getType() == Type.TYPELESS){
            out_.setStyle("-fx-text-fill: white;");
        }else {
            out_.setStyle("-fx-text-fill: white; -fx-border-color: white;");
        }
        out_.setPadding(new Insets(0,10,0,10));

        GridPane.setConstraints(out_,0,0);
        this.getChildren().add(out_);
    }

    public md_Preview(Moves in){
        super();

        this.current_ = in;

        out_ = new Label();
        out_.setWrapText(true);
        out_.setMaxSize(400, 600);
        if(current_.getType() == Type.TYPELESS){
            out_.setStyle("-fx-text-fill: white;");
        }else {
            out_.setStyle("-fx-text-fill: white; -fx-border-color: white;");
        }
        out_.setPadding(new Insets(0,10,0,10));

        GridPane.setConstraints(out_,0,0);
        this.getChildren().add(out_);
    }

    public void changeView(Moves in){
        this.current_ = in;
        this.out_.setText(in.toPrint());
        out_.setStyle("-fx-text-fill: white; -fx-border-color: white;");
    }

}

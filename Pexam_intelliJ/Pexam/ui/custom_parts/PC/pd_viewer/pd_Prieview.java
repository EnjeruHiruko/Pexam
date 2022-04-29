package Pexam.ui.custom_parts.PC.pd_viewer;

import Pexam.data.Combatant.Pokemon.Species;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class pd_Prieview extends GridPane {

    private Species current_;

    private Label out_;
    public pd_Prieview(){ //todo actually use the GridPane to it's fullest
        super();
        this.current_ = new Species();

        //format
        out_ = new Label(current_.showcase());
        out_.setWrapText(true);
        out_.setMaxSize(400, 600);
        if(current_.getDexNumber() == 0){
            out_.setStyle("-fx-text-fill: white;");
        }else {
            out_.setStyle("-fx-text-fill: white; -fx-border-color: white;");
        }
        out_.setPadding(new Insets(0,10,0,10));

        GridPane.setConstraints(out_,0,0);
        this.getChildren().add(out_);
    }
    public pd_Prieview(Species in){
        super();
        this.current_ = in;

        //format
        out_ = new Label(current_.showcase());
        out_.setWrapText(true);
        out_.setMaxSize(400, 600);
        if(current_.getDexNumber() == 0){
            out_.setStyle("-fx-text-fill: white;");
        }else {
            out_.setStyle("-fx-text-fill: white; -fx-border-color: white;");
        }
        out_.setPadding(new Insets(0,10,0,10));

        GridPane.setConstraints(out_,0,0);
        this.getChildren().add(out_);
    }

    public void changeView(Species in){
        this.current_ = in;
        this.out_.setText(in.showcase());
        out_.setStyle("-fx-text-fill: white; -fx-border-color: white;");
    }
}

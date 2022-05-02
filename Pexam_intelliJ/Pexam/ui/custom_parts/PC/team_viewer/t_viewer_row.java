package Pexam.ui.custom_parts.PC.team_viewer;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class t_viewer_row extends HBox {

    private Button btn_pokemon_;

    private Label lbl_row_number_;

    private CheckBox cb_training_;

    public t_viewer_row(){
        super();
        this.btn_pokemon_ = new Button();
        this.lbl_row_number_ = new Label();
        this.cb_training_ = new CheckBox();
        this.setPadding(new Insets(10,10,10,10));

        //Style and Size
        lbl_row_number_.setMinSize(60,60);
        lbl_row_number_.setStyle("-fx-background-color: white; -fx-text-fill: #121212; -fx-font: 40 arial");

        btn_pokemon_.setMinSize(400,60);
        btn_pokemon_.setStyle("-fx-background-color: white; -fx-text-fill: #121212; -fx-font: 40 arial");

        this.getChildren().addAll(lbl_row_number_,btn_pokemon_,cb_training_);
    }
    public  t_viewer_row(int row){
        this();

        lbl_row_number_.setText(""+row);
    }

    public t_viewer_row(int row, String button){
        this(row);
        btn_pokemon_.setText(button);
    }

    public void setPokemon(String in){
        btn_pokemon_.setText(in);
    }
}

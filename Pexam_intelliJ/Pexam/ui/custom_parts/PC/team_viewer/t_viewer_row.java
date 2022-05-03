package Pexam.ui.custom_parts.PC.team_viewer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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
        this.setAlignment(Pos.CENTER);
        this.setMinSize(520,100);


        //Style and Size
        StackPane test = new StackPane();
        Rectangle test_bg_btn = new Rectangle(60,60);
        test_bg_btn.setFill(Color.web("#121212"));
        test_bg_btn.setArcWidth(5);
        test_bg_btn.setArcHeight(5);


        Rectangle gap1 = new Rectangle(10,60);
        gap1.setFill(Color.web("#121212"));
        Rectangle gap2 = new Rectangle(10,60);
        gap2.setFill(Color.web("#121212"));


        lbl_row_number_.setMinSize(60,60);
        lbl_row_number_.setStyle("-fx-background-color: white; -fx-text-fill: #121212; -fx-font: 40 arial");
        lbl_row_number_.setAlignment(Pos.CENTER);
        lbl_row_number_.setPadding(new Insets(0,10,0,0));

        StackPane test2 = new StackPane();
        Rectangle test2_bg = new Rectangle(400, 60);
        test2_bg.setFill(Color.web("#FFFFFF"));

        btn_pokemon_.setMinSize(400,55);
        btn_pokemon_.setStyle("-fx-background-color: white; -fx-text-fill: #121212; -fx-font: 40 arial;");
        btn_pokemon_.setPadding(new Insets(0,10,0,0));

        test2.getChildren().addAll(test2_bg,btn_pokemon_);
        test2.setAlignment(Pos.CENTER);
        test.getChildren().addAll(test_bg_btn,lbl_row_number_);
        test.setAlignment(Pos.CENTER);

        this.getChildren().addAll(test,gap1,test2,gap2,cb_training_);
    }
    public  t_viewer_row(int row){
        this();

        lbl_row_number_.setText(" "+row);
    }

    public t_viewer_row(int row, String button){
        this(row);
        btn_pokemon_.setText(button);
    }

    public void setPokemon(String in){
        btn_pokemon_.setText(in);
    }

    public Button getBtn_pokemon_() {
        return btn_pokemon_;
    }

    public Label getLbl_row_number_() {
        return lbl_row_number_;
    }

    public CheckBox getCb_training_() {
        return cb_training_;
    }
}

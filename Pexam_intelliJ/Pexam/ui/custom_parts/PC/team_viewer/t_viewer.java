package Pexam.ui.custom_parts.PC.team_viewer;

import Pexam.cute.Cute;
import Pexam.data.Combatant.Trainer.Trainer;
import Pexam.ui.custom_parts.PC.Creator;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class t_viewer extends HBox {

    private t_viewer_row r1_;

    private t_viewer_row r2_;

    private t_viewer_row r3_;

    private t_viewer_row r4_;

    private t_viewer_row r5_;

    private t_viewer_row r6_;

    private Button btn_box_;

    private Button btn_sheet_;

    private Button btn_train_;

    public t_viewer(){
        super();

        //spacer left menu to Selection
        Rectangle spacer1 = new Rectangle(100,800);
        spacer1.setFill(Color.web("#121212"));

        //spacer between both menu parts
        Rectangle spacer2 = new Rectangle(200, 800);
        spacer2.setFill(Color.web("#121212"));

        //leftside
        VBox left_side = new VBox();

        Label lbl_trainer = new Label("Trainer");
        lbl_trainer.setStyle("-fx-font: 40 arial; -fx-text-fill: white;");

        Label lbl_team = new Label("Team - ");
        lbl_team.setStyle("-fx-font: 40 arial; -fx-text-fill: white;");
        btn_train_ = new Button("Train");

        r1_ = new t_viewer_row(1);
        r2_ = new t_viewer_row(2);
        r3_ = new t_viewer_row(3);
        r4_ = new t_viewer_row(4);
        r5_ = new t_viewer_row(5);
        r6_ = new t_viewer_row(6);

        for(int c = 0; c < Creator.getTest().getSelected_trainer().getTeam().size(); c++){
            switch (c+1){
                case 1: r1_.setPokemon(Creator.getTest().getSelected_trainer().getTeam().get(c).getName());break;
                case 2: r2_.setPokemon(Creator.getTest().getSelected_trainer().getTeam().get(c).getName());break;
                case 3: r3_.setPokemon(Creator.getTest().getSelected_trainer().getTeam().get(c).getName());break;
                case 4: r4_.setPokemon(Creator.getTest().getSelected_trainer().getTeam().get(c).getName());break;
                case 5: r5_.setPokemon(Creator.getTest().getSelected_trainer().getTeam().get(c).getName());break;
                case 6: r6_.setPokemon(Creator.getTest().getSelected_trainer().getTeam().get(c).getName());break;
            }
        }

        left_side.getChildren().addAll(lbl_trainer,lbl_team,r1_,r2_,r3_,r4_,r5_,r6_);

        //right side
        this.btn_box_ = new Button("Box");
        btn_box_.setMinSize(100,60);

        VBox vb_spacer = new VBox();
        vb_spacer.setMinSize(100,120);

        btn_sheet_ = new Button("Sheet");
        btn_sheet_.setMinSize(100,60);

        VBox right_side = new VBox();
        right_side.getChildren().addAll(btn_box_,vb_spacer, btn_sheet_);

        this.getChildren().addAll(spacer1, left_side, spacer2 ,right_side);
    }

}

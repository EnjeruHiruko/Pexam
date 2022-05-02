package Pexam.ui.custom_parts.PC.team_viewer;

import Pexam.cute.Cute;
import Pexam.data.Combatant.Trainer.Trainer;
import Pexam.ui.custom_parts.PC.Creator;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class t_viewer extends HBox {
    public t_viewer(){
        super();

        //leftside
        VBox left_side = new VBox();

        Label lbl_trainer = new Label("Trainer");
        lbl_trainer.setStyle("-fx-font: 40 arial; -fx-text-fill: white;");

        Label lbl_team = new Label("Team - ");
        lbl_team.setStyle("-fx-font: 40 arial; -fx-text-fill: white;");
        Button btn_train = new Button("Train");

        t_viewer_row r1 = new t_viewer_row(1);
        t_viewer_row r2 = new t_viewer_row(2);
        t_viewer_row r3 = new t_viewer_row(3);
        t_viewer_row r4 = new t_viewer_row(4);
        t_viewer_row r5 = new t_viewer_row(5);
        t_viewer_row r6 = new t_viewer_row(6);

        for(int c = 0; c < Creator.getTest().getSelected_trainer().getTeam().size(); c++){
            switch (c+1){
                case 1: r1.setPokemon(Creator.getTest().getSelected_trainer().getTeam().get(c).getName());break;
                case 2: r2.setPokemon(Creator.getTest().getSelected_trainer().getTeam().get(c).getName());break;
                case 3: r3.setPokemon(Creator.getTest().getSelected_trainer().getTeam().get(c).getName());break;
                case 4: r4.setPokemon(Creator.getTest().getSelected_trainer().getTeam().get(c).getName());break;
                case 5: r5.setPokemon(Creator.getTest().getSelected_trainer().getTeam().get(c).getName());break;
                case 6: r6.setPokemon(Creator.getTest().getSelected_trainer().getTeam().get(c).getName());break;
            }
        }

        left_side.getChildren().addAll(lbl_trainer,lbl_team,r1,r2,r3,r4,r5,r6);


        //right side
        Button btn_box = new Button("Box");
        btn_box.setMinSize(100,60);

        VBox vb_spacer = new VBox();
        vb_spacer.setMinSize(100,120);

        Button btn_sheet = new Button("Sheet");
        btn_sheet.setMinSize(100,60);

        VBox right_side = new VBox();
        right_side.getChildren().addAll(btn_box,vb_spacer, btn_sheet);

        this.getChildren().addAll(left_side,right_side);
    }

}

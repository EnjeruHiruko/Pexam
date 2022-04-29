package Pexam.ui.custom_parts.PC.p_creator;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class P_Creator extends GridPane{
    public P_Creator(){
        super();

        this.setPadding(new Insets(10,10,10,10));
        this.setHgap(10);
        this.setVgap(5);

        //label
        Label lbl_Name = new p_creator_Grid_Label("Name");
        Label lbl_Species = new p_creator_Grid_Label("Species");
        Label lbl_Type = new p_creator_Grid_Label("Type");
        Label lbl_level = new p_creator_Grid_Label("Level");
        Label lbl_EXP = new p_creator_Grid_Label("EXP");
        Label lbl_Held_Item = new p_creator_Grid_Label("Held Item");
        Label lbl_Loyalty = new p_creator_Grid_Label("Loyalty");
        Label lbl_Gender = new p_creator_Grid_Label("Gender");
        Label lbl_Nature = new Label("Nature");
        Label lbl_Abilities = new Label("Abilities");
        Label lbl_Height_Size = new Label("Height/Size");
        Label lbl_Weight_class = new Label("Weight Class");
        Label lbl_Capabilities = new Label("Capabilities");
        Label lbl_Skills = new Label("Skills");

        Label lbl_mHP = new Label("Hit Points");
        Label lbl_sHp = new Label("HP");
        Label lbl_sAT = new Label("AT");
        Label lbl_sDef = new Label("DEF");
        Label lbl_sSpAt = new Label("SpAT");
        Label lbl_sSpDef = new Label("SpDEF");
        Label lbl_speed = new Label("SPEED");

        GridPane.setConstraints(lbl_Name, 0,0);
        GridPane.setConstraints(lbl_Species, 0,1);
        GridPane.setConstraints(lbl_Type, 0,2);
        GridPane.setConstraints(lbl_level, 0,3);
        GridPane.setConstraints(lbl_EXP, 0,4);
        GridPane.setConstraints(lbl_Held_Item, 0,5);
        GridPane.setConstraints(lbl_Loyalty, 0,6);



        this.getChildren().addAll(lbl_Name,lbl_Species,lbl_Type,lbl_level,lbl_EXP,lbl_Held_Item,lbl_Loyalty);






    }
}

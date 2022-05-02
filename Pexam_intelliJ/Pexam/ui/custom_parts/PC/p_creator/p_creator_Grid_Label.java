package Pexam.ui.custom_parts.PC.p_creator;

import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class p_creator_Grid_Label extends Label {
    public p_creator_Grid_Label(String input){
        super(input);

        String bg_hex = "#121212";
        this.setMinSize(100,40);
        this.setMaxSize(100, 40);
        this.setStyle("-fx-font: 20 arial; -fx-border-color: #121212; -fx-text-fill: #121212;");
        this.setAlignment(Pos.CENTER);
    }
}

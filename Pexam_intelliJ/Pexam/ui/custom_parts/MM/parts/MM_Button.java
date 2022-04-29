package Pexam.ui.custom_parts.MM.parts;

import javafx.scene.control.Button;

public class MM_Button extends Button {
    public MM_Button(String input){
        super(input);

        //values
        String bg_hex = "#121212";
        int button_width = 240;
        int button_height = 60;
        int button_font_size = 40;

        this.setMaxSize(button_width,button_height);
        this.setStyle("-fx-font: " + button_font_size + " arial; -fx-background-color: white; -fx-text-fill: "+ bg_hex +"; -fx-border-color:" + bg_hex+ ";");

    }
}

package Pexam.ui.custom_parts.PC;

import Pexam.cute.Cute;
import Pexam.ui.UserInterface;
import Pexam.ui.custom_parts.MM.parts.MM_Button;
import Pexam.ui.custom_parts.PC.md_viewer.md_Viewer;
import Pexam.ui.custom_parts.PC.p_creator.P_Creator;
import Pexam.ui.custom_parts.PC.pd_viewer.Pd_Viewer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Creator {

    private Scene scene;
    private static Cute test_;

    public static Cute getTest(){
        return test_;
    }

    public Creator(){

        test_ = new Cute();
        //main layout
        String bg_hex = "#121212";
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setStyle("-fx-background-color: "+bg_hex+";");


        //left side Menu -> to mirror the Main Menu
        int button_width = 240;
        int button_height = 60;
        int button_font_size = 40;
        VBox menu_left = new VBox();
        //menu_left.setMaxSize(240,1080);
        menu_left.setMinSize(240,1000);
        menu_left.setAlignment(Pos.TOP_CENTER);
        menu_left.setStyle("-fx-background-color: white");

        //more Vbox shananigans
        VBox left_lower = new VBox();
        left_lower.setMaxSize(button_width,button_height);
        VBox left_upper = new VBox();
        left_upper.setMinSize(button_width, 937);


        // Buttons todo Windows with Searches etc for
        Button btn_NEW = new MM_Button("Editor");
        Button btn_Pokemon = new MM_Button("Pokemon");
        Button btn_Moves = new MM_Button("Moves");
        Button btn_abilities = new MM_Button("Abilities");
        Button btn_return = new MM_Button("Return");




        left_upper.getChildren().addAll(btn_NEW, btn_Pokemon,btn_Moves,btn_abilities);
        left_lower.getChildren().add(btn_return);
        menu_left.getChildren().addAll(left_upper, left_lower);
        layout.setLeft(menu_left);

        // right side menu




        // center menu
        GridPane center_menu = new P_Creator();


        //Events
        btn_return.setOnAction(e -> UserInterface.change_scene(0));
        btn_Pokemon.setOnAction(e -> {
            if(!(layout.getCenter() instanceof Pd_Viewer)){
                layout.setCenter(new Pd_Viewer());
            }
        });
        btn_Moves.setOnAction(e -> {
            if(!(layout.getCenter() instanceof md_Viewer)) {
                layout.setCenter(new md_Viewer());
            }
        });
        btn_NEW.setOnAction(e -> {
            if(!(layout.getCenter() instanceof P_Creator)) {
                layout.setCenter(center_menu);
            }
        });

        // finishing touches
        layout.setMinSize(1920,1033);




        Group root = new Group(layout);

        this.scene = new Scene(root);

    }
    public Scene getScene(){
        return this.scene;
    }
}

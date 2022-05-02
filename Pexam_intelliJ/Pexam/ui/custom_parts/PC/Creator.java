package Pexam.ui.custom_parts.PC;

import Pexam.cute.Cute;
import Pexam.data.Combatant.Trainer.Trainer;
import Pexam.ui.UserInterface;
import Pexam.ui.custom_parts.MM.parts.MM_Button;
import Pexam.ui.custom_parts.PC.md_viewer.md_Viewer;
import Pexam.ui.custom_parts.PC.p_creator.P_Creator;
import Pexam.ui.custom_parts.PC.parts.prompt_window;
import Pexam.ui.custom_parts.PC.pd_viewer.Pd_Viewer;
import Pexam.ui.custom_parts.PC.team_viewer.t_viewer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
        int button_width = 300;
        int button_height = 60;
        int button_font_size = 40;
        VBox menu_left = new VBox();
        //menu_left.setMaxSize(240,1080);
        menu_left.setMinSize(300,1013);
        menu_left.setAlignment(Pos.TOP_CENTER);
        menu_left.setStyle("-fx-background-color: white");

        //more Vbox shananigans
        VBox left_lower = new VBox();
        left_lower.setMaxSize(button_width,button_height*4);
        VBox left_upper = new VBox();
        left_upper.setMinSize(button_width, 1003-button_height*5);


        //upper VBox todo replace edit-button with trainer-combobox
        Label c_lbl_trainer = new Label("Trainer:");
        c_lbl_trainer.setMinSize(300,60);
        c_lbl_trainer.setAlignment(Pos.CENTER);
        c_lbl_trainer.setStyle("-fx-font: " + button_font_size + " arial; -fx-background-color: white; -fx-text-fill: "+ bg_hex +"; -fx-border-color: gray;");

        ChoiceBox<String> cb_trainer_select = new ChoiceBox<>();
        cb_trainer_select.setMinSize(300,60);
        cb_trainer_select.setMaxSize(300,80);
        cb_trainer_select.setStyle("-fx-text-fill: #121212; -fx-font: 40 arial;");
        for(Trainer temp: test_.getAll_trainer()){
            cb_trainer_select.getItems().add(temp.getName());
        }
        cb_trainer_select.getItems().add("New..");
        //cb_trainer_select.setPromptText("Choose");
        //Button btn_NEW = new MM_Button("Editor");



        //lower VBox
        Button btn_Pokemon = new MM_Button("Pokemon");
        Button btn_Moves = new MM_Button("Moves");
        Button btn_abilities = new MM_Button("Abilities");
        Button btn_return = new MM_Button("Return");




        left_upper.getChildren().addAll(c_lbl_trainer, cb_trainer_select);
        left_lower.getChildren().addAll(btn_Pokemon,btn_abilities,btn_Moves,btn_return);
        menu_left.getChildren().addAll(left_upper, left_lower);
        layout.setLeft(menu_left);

        // right side menu




        // center menu
        BorderPane c_m = new BorderPane();
        c_m.setStyle("-fx-background-color: white");
        c_m.setPadding(new Insets(10,10,10,0));
        c_m.setMaxSize(1620,1020);
        GridPane center_menu = new P_Creator();
        c_m.getChildren().add(center_menu);

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


        cb_trainer_select.setOnAction(e -> {
            if(cb_trainer_select.getValue().equals("New..")){
                String val = prompt_window.display("Name your Trainer", "What is your name?");
                if(val != null){
                    test_.new_Trainer(val);
                    cb_trainer_select.getItems().add(val);
                    cb_trainer_select.setValue(val);
                    layout.setCenter(new t_viewer());
                }//todo resetting the choiceBox
            }else{ //todo saving changed values if another trainer was edited
                test_.change_selected_Trainer(cb_trainer_select.getValue());
                layout.setCenter(new t_viewer());
            }
        });

        /*
        btn_NEW.setOnAction(e -> {
            if(!(layout.getCenter() instanceof P_Creator)) {
                layout.setCenter(c_m);
            }
        });
        */
        // finishing touches
        layout.setMinSize(1920,1033);




        Group root = new Group(layout);

        this.scene = new Scene(root);

    }
    public Scene getScene(){
        return this.scene;
    }
}

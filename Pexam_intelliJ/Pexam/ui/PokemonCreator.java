package Pexam.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class PokemonCreator {

    private Scene scene;

    public PokemonCreator(){
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
        menu_left.setMaxSize(240,1080);
        menu_left.setMinSize(240,1000);
        menu_left.setAlignment(Pos.TOP_CENTER);
        menu_left.setStyle("-fx-background-color: white");

        //more Vbox shananigans
        VBox left_lower = new VBox();
        left_lower.setMaxSize(button_width,button_height);
        VBox left_upper = new VBox();
        left_upper.setMaxSize(button_width, 980);
        left_upper.setMinSize(button_width, 980);


        // Buttons todo button renaming
        Button btn_start = new Button("Test1");
        Button btn_settings = new Button("Test2");
        Button btn_about = new Button("Test3");
        Button btn_Rules = new Button("Test4");
        Button btn_return = new Button("Return");

        // Size of Buttons
        btn_start.setMaxSize( button_width, button_height);
        btn_settings.setMaxSize( button_width, button_height);
        btn_about.setMaxSize( button_width, button_height);
        btn_Rules.setMaxSize( button_width, button_height);
        btn_return.setMaxSize( button_width, button_height);

        //Font and Style of Buttons
        btn_start.setStyle("-fx-font: " + button_font_size + " arial; -fx-background-color: white; -fx-text-fill: "+ bg_hex +"; -fx-border-color:" + bg_hex+ ";");
        btn_settings.setStyle("-fx-font: " + button_font_size + " arial; -fx-background-color: white; -fx-text-fill: "+ bg_hex +"; -fx-border-color:" + bg_hex+ ";");
        btn_about.setStyle("-fx-font: " + button_font_size + " arial; -fx-background-color: white; -fx-text-fill: "+ bg_hex +"; -fx-border-color:" + bg_hex+ ";");
        btn_Rules.setStyle("-fx-font: " + button_font_size + " arial; -fx-background-color: white; -fx-text-fill: "+ bg_hex +"; -fx-border-color:" + bg_hex+ ";");
        btn_return.setStyle("-fx-font: " + button_font_size + " arial; -fx-background-color: white; -fx-text-fill: "+ bg_hex +"; -fx-border-color:" + bg_hex+ ";");

        //Events
        btn_return.setOnAction(e -> UserInterface.getMainStage().setScene(UserInterface.getMm_()));


        left_upper.getChildren().addAll(btn_start, btn_settings,btn_about,btn_Rules);
        left_lower.getChildren().add(btn_return);
        menu_left.getChildren().addAll(left_upper, left_lower);
        layout.setLeft(menu_left);

        // right side menu

        // center menu



        layout.setMaxSize(1920,1080);
        layout.setMinSize(1920,1080);


        Group root = new Group(layout);

        this.scene = new Scene(root);

    }
    public Scene getScene(){
        return this.scene;
    }
}

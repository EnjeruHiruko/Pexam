package Pexam.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;


public class TitleScreen {

    private Scene scene;

    public TitleScreen(){
        //general layout
        String bg_hex = "#121212";
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(10,10,10,10));

        //left side menu
        int button_width = 240;
        int button_height = 60;
        int button_font_size = 40;
        VBox menu_left = new VBox();
        menu_left.setMaxSize(240,1080);
        menu_left.setMinSize(240,1000);
        menu_left.setAlignment(Pos.BOTTOM_CENTER);
        menu_left.setStyle("-fx-background-color: white");

        // Buttons
        Button btn_start = new Button("Start");
        Button btn_settings = new Button("Settings");
        Button btn_about = new Button("About Us");
        Button btn_Rules = new Button("Rules");
        Button btn_exit = new Button("Exit");

        // Size of Buttons
        btn_start.setMaxSize( button_width, button_height);
        btn_settings.setMaxSize( button_width, button_height);
        btn_about.setMaxSize( button_width, button_height);
        btn_Rules.setMaxSize( button_width, button_height);
        btn_exit.setMaxSize( button_width, button_height);

        //Font and Style of Buttons
        btn_start.setStyle("-fx-font: " + button_font_size + " arial; -fx-background-color: white; -fx-text-fill: "+ bg_hex +"; -fx-border-color:" + bg_hex+ ";");
        btn_settings.setStyle("-fx-font: " + button_font_size + " arial; -fx-background-color: white; -fx-text-fill: "+ bg_hex +"; -fx-border-color:" + bg_hex+ ";");
        btn_about.setStyle("-fx-font: " + button_font_size + " arial; -fx-background-color: white; -fx-text-fill: "+ bg_hex +"; -fx-border-color:" + bg_hex+ ";");
        btn_Rules.setStyle("-fx-font: " + button_font_size + " arial; -fx-background-color: white; -fx-text-fill: "+ bg_hex +"; -fx-border-color:" + bg_hex+ ";");
        btn_exit.setStyle("-fx-font: " + button_font_size + " arial; -fx-background-color: white; -fx-text-fill: "+ bg_hex +"; -fx-border-color:" + bg_hex+ ";");

        //Events
        btn_exit.setOnAction(event -> System.exit(1));

        menu_left.getChildren().addAll(btn_start, btn_settings,btn_Rules,btn_about, btn_exit);
        layout.setLeft(menu_left);


        //center image view
        Image front_cover = new Image("Pexam/ui/resources/Pexam_frontcover.png");

        ImageView imageView = new ImageView();
        imageView.setImage(front_cover);
        layout.setCenter(imageView);

        layout.setStyle("-fx-background-color: #121212");


        layout.setMaxSize(1920,1080);
        layout.setMinSize(1920,1080);


        Group root = new Group(layout);

        this.scene = new Scene(root);



    }
    public Scene getScene(){
        return this.scene;
    }
}

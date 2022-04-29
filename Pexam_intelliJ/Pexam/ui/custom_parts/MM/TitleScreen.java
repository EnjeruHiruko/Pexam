package Pexam.ui.custom_parts.MM;

import Pexam.ui.UserInterface;
import Pexam.ui.custom_parts.MM.parts.MM_Button;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;


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
        //menu_left.setMaxSize(240,1080);
        menu_left.setMinSize(240,1000);
        menu_left.setAlignment(Pos.BOTTOM_CENTER);
        menu_left.setStyle("-fx-background-color: white");

        //more Vbox shananigans
        VBox left_lower = new VBox();
        left_lower.setMaxSize(button_width, 300);
        VBox left_upper = new VBox();
        left_upper.setMinSize(button_width, 620);

        // Buttons
        Button btn_start = new MM_Button("Start");
        Button btn_settings = new MM_Button("Settings");
        Button btn_about = new MM_Button("About Us");
        Button btn_Rules = new MM_Button("Rules");
        Button btn_exit = new MM_Button("Exit");

        //Events
        btn_exit.setOnAction(e -> System.exit(1));
        btn_start.setOnAction(e -> UserInterface.change_scene(1));

        left_lower.getChildren().addAll(btn_start, btn_settings,btn_Rules,btn_about, btn_exit);
        menu_left.getChildren().addAll(left_upper, left_lower);
        layout.setLeft(menu_left);


        //center image view
        Image front_cover = new Image("Pexam/ui/resources/Pexam_frontcover.png");

        ImageView imageView = new ImageView();
        imageView.setImage(front_cover);
        imageView.setStyle("-fx-background-color: #121212");
        layout.setCenter(imageView);

        layout.setStyle("-fx-background-color: #121212");

        layout.setMinSize(1920,1033);


        Group root = new Group(layout);

        this.scene = new Scene(root);



    }
    public Scene getScene(){
        return this.scene;
    }
}

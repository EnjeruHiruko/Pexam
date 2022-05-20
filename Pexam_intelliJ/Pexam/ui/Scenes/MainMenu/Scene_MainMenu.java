package Pexam.ui.Scenes.MainMenu;

import Pexam.ui.Scenes.MainMenu.parts.mm_CenterBackground;
import Pexam.ui.Scenes.MainMenu.parts.mm_LeftMenu;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class Scene_MainMenu {

    private Scene scene;

    private mm_LeftMenu left_menu;

    private mm_CenterBackground center_menu;

    public Scene_MainMenu(){

        //Main Layout and Window sizing
        AnchorPane window_border = new AnchorPane();
        window_border.setStyle("-fx-background-color: #121212");
        BorderPane main_layout = new BorderPane();
        AnchorPane.setLeftAnchor(main_layout, 0.0);
        AnchorPane.setRightAnchor(main_layout, 0.0);
        AnchorPane.setTopAnchor(main_layout, 0.0);
        AnchorPane.setBottomAnchor(main_layout, 0.0);





        //main_layout.setTop(new FileMenu());
        this.center_menu = new mm_CenterBackground();
        main_layout.setCenter(center_menu);
        this.left_menu = new mm_LeftMenu();
        main_layout.setLeft(left_menu);





        window_border.getChildren().add(main_layout);
        window_border.setPrefSize(1280,720);
        this.scene = new Scene(window_border);
    }

    public Scene getScene() {
        return scene;
    }

    public mm_LeftMenu getLeft_menu() {
        return left_menu;
    }

    public mm_CenterBackground getCenter_menu() {
        return center_menu;
    }

}

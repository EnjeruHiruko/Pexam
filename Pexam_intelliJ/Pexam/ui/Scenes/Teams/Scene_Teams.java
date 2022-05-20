package Pexam.ui.Scenes.Teams;

import Pexam.ui.Scenes.MainMenu.parts.mm_LeftMenu;
import Pexam.ui.Scenes.Teams.parts.teams_CenterManu;
import Pexam.ui.Scenes.Teams.parts.teams_LeftMenu;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Scene_Teams {
    private Scene scene;

    private teams_LeftMenu l_menu;

    private AnchorPane c_menu;

    public Scene_Teams(){

        //Main Layout and Window sizing
        AnchorPane window_border = new AnchorPane();
        BorderPane main_layout = new BorderPane();
        window_border.setStyle("-fx-background-color: #121212");
        AnchorPane.setLeftAnchor(main_layout, 0.0);
        AnchorPane.setRightAnchor(main_layout, 0.0);
        AnchorPane.setTopAnchor(main_layout, 0.0);
        AnchorPane.setBottomAnchor(main_layout, 0.0);


        l_menu = new teams_LeftMenu();
        main_layout.setLeft(l_menu);

        c_menu = new teams_CenterManu();
        main_layout.setCenter(c_menu);


        window_border.getChildren().addAll(main_layout);
        window_border.setPrefSize(1280,720);
        this.scene = new Scene(window_border);
    }

    public Scene getScene() {
        return scene;
    }

    public teams_LeftMenu getL_menu() {
        return l_menu;
    }

    public AnchorPane getC_menu() {
        return c_menu;
    }
}

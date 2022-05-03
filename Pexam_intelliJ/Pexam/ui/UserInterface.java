package Pexam.ui;

import Pexam.ui.custom_parts.MM.TitleScreen;
import Pexam.ui.custom_parts.PC.Creator;
import Pexam.ui.custom_parts.PC.team_viewer.PokemonEditor;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

// testing of javafx for better usage later on
public class UserInterface extends Application { //todo this will be eventually moved to the main method

    private static Stage mainStage_;

    private static Scene mm_;

    private static Scene pc_;

    private static Scene pv_;

    public static void main(String[] args){
        launch(args);
    }

    public static void change_scene(int value){
        switch (value){
            case 0: mainStage_.setScene(mm_);break;
            case 1: mainStage_.setScene(pc_);break;
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Pexam WIP");
        primaryStage.setMaxWidth(1920);
        primaryStage.setMaxHeight(1080);
        primaryStage.setMinWidth(1920);
        primaryStage.setMinHeight(1080);

        // initialize Scenes
        mainStage_ = primaryStage;
        mm_ = new TitleScreen().getScene();
        pc_ = new Creator().getScene();
        pv_ = new PokemonEditor().getScene();

        mainStage_.setScene(mm_);
        mainStage_.show();

    }
}

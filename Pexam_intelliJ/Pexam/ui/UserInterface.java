package Pexam.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

// testing of javafx for better usage later on
public class UserInterface extends Application {

    private static Stage mainStage_;

    private static Scene mm_;

    private static Scene pc_;

    public static void main(String[] args){
        launch(args);
    }

    public static Stage getMainStage(){
        return mainStage_;
    }

    public static Scene getMm_(){
        return mm_;
    }

    public static Scene getPc_(){
        return pc_;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Pexam");
        primaryStage.setMaxWidth(1920);
        primaryStage.setMaxHeight(1127);
        primaryStage.setMinWidth(1920);
        primaryStage.setMinHeight(1125);

        // initialize Scenes
        mainStage_ = primaryStage;
        mm_ = new TitleScreen().getScene();
        pc_ = new PokemonCreator().getScene();

        mainStage_.setScene(mm_);
        mainStage_.show();

    }
}

package Pexam.ui;

import javafx.application.Application;
import javafx.stage.Stage;

// testing of javafx for better usage later on
public class UserInterface extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Pexam");
        primaryStage.setMaxWidth(1920);
        primaryStage.setMaxHeight(1127);
        primaryStage.setMinWidth(1920);
        primaryStage.setMinHeight(1125);

        TitleScreen mm = new TitleScreen();
        PokemonCreator pc = new PokemonCreator();

        primaryStage.setScene(mm.getScene());
        primaryStage.show();

    }
}

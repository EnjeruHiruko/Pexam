package Pexam;

import Pexam.cute.Cute;
import Pexam.data.Combatant.Pokemon.Nature;
import Pexam.data.Combatant.Pokemon.Pokemon;
import Pexam.ui.UI;
import Pexam.ui.UserInterface;
import Pexam.ui.custom_parts.MM.TitleScreen;
import Pexam.ui.custom_parts.PC.Creator;
import Pexam.ui.custom_parts.PC.team_viewer.PokemonEditor;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    //todo well UI is WIP and will be overhauled at some point to make everything to be better maintainable
    //todo Setup an overview to better implement all elements of the scenes
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
            case 2: mainStage_.setScene(pv_);break;
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        boolean testing_ = true;
        boolean exp = true;
        if (exp) {
            primaryStage.setScene(new UI().getScene());
            primaryStage.show();
        } else {
            if (testing_) {
                primaryStage = new UserInterface();
                primaryStage.show();
            } else {

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
    }
}
/*
todo: Main -> calling UI and backend
    : 2 threads
    : Handler for Interaction between threads
    : UI-class
    : Cute -> standalone runnable
 */
/*
manual calculations:


*/
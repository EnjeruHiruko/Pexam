package Pexam.ui;

import Pexam.cute.Cute;
import Pexam.ui.Scenes.MainMenu.Scene_MainMenu;
import Pexam.ui.Scenes.Teams.Scene_Teams;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;

// testing of javafx for better usage later on
public class UserInterface extends Stage{

    private static Scene_MainMenu mainMenu;

    private static Scene_Teams teams;

    private static ArrayList<String> world_paths;

    private static Cute backend;

    public UserInterface(){
        super();
        mainMenu = new Scene_MainMenu();
        teams = new Scene_Teams();
        this.setTitle("Pexam WIP");
        this.setScene(mainMenu.getScene());
        createPaths();
        this.setActions();

    }

    public void change_scene(int value, double width, double height){
        switch (value){
            case 0: this.setScene(mainMenu.getScene());break;
            case 1: this.setScene(teams.getScene());break;
        }
    }
    public Cute backendAccess(){
        return backend;
    }

    private void createPaths(){
        try {
            File temp = new File("../Pexam/Pexam_intelliJ/Pexam/cute/cuteutility/versions/");
            String[] directories = temp.list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return new File(dir,name).isDirectory();
                }
            });
            assert directories != null;
            world_paths = new ArrayList<>(Arrays.asList(directories));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<String> getPaths(){
        return world_paths;
    }

    private void setActions(){
        mainMenu.getLeft_menu().getBtn_lg().setOnAction(e -> change_scene(1,mainMenu.getScene().getWidth(),mainMenu.getScene().getHeight()));
        teams.getL_menu().getBtn_return().setOnAction(event -> change_scene(0,teams.getScene().getWidth(),teams.getScene().getHeight()));
    }

    private void resizeStage(double width, double height){
        this.setWidth(width);
        this.setHeight(height);
    }

}

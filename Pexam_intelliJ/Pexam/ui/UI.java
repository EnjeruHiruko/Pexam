package Pexam.ui;

import Pexam.cute.Cute;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** This Class will contain the complete User Interface like disregarding any convention. It's purpose is to have something working.
 *  At later dates this will be split into different subclasses for better maintainability and organization.
 *  At a later date some line will be removed due to usage of CSS.
 *
 */
public class UI {

    private Cute database;

    private Scene main;

    private AnchorPane layout;

    private String bg_hex;

    private ArrayList<String> world_paths;

    private String selected_world;

    public UI(){
        //General Layout
        layout = new AnchorPane();
        this.layout.setStyle("-fx-background-color: #121212");
        main = new Scene(layout);
        database = new Cute();
        bg_hex = "#121212";
        createPaths();
        setGeneral();
        setEventHandling();
    }

    private BorderPane lyt_general;

    private Button general_left_btn_load;

    private Button general_left_btn_new;

    private Button general_left_btn_setting;

    private Button general_left_btn_exit;

    private Button general_left_btn_aboutUs;


    private void setGeneral(){
        //Setup Parts



        lyt_general = new BorderPane();
        AnchorPane.setBottomAnchor(lyt_general, 0.0);
        AnchorPane.setTopAnchor(lyt_general, 0.0);
        AnchorPane.setLeftAnchor(lyt_general, 0.0);
        AnchorPane.setRightAnchor(lyt_general, 0.0);


        //Left Sub-Layout
        VBox general_left = new VBox();
        general_left.setStyle("-fx-background-color: white;");
        general_left.setAlignment(Pos.BOTTOM_LEFT);
        general_left.setPrefWidth(300);

        String general_left_ButtonStyle = "-fx-background-color: white; -fx-text-fill: #121212; -fx-font: 40 arial; -fx-border-color: white;";
        general_left_btn_load = new Button("Load..");
        general_left_btn_new = new Button("New..");
        general_left_btn_setting = new Button("Settings..");
        general_left_btn_exit = new Button("Exit");
        general_left_btn_aboutUs = new Button("About Us");

        general_left.getChildren().addAll(general_left_btn_load,general_left_btn_new,general_left_btn_setting,general_left_btn_aboutUs,general_left_btn_exit);
        for(int c = 0; c < general_left.getChildren().size(); c++){
            general_left.getChildren().get(c).setStyle(general_left_ButtonStyle);
        }

        //Center Sub-Layout
        Image Pexam_frontCover = new Image("./Pexam/ui/resources/Pexam_frontcover.png");
        ImageView general_center_iv_cover = new ImageView(Pexam_frontCover);



        lyt_general.setCenter(general_center_iv_cover);
        lyt_general.setLeft(general_left);
        //lyt_general.getChildren().add(lyt_general);
        layout.getChildren().add(lyt_general);
    }

    private void selectCharacter(){

    }

    private void setEventHandling(){
        //Events General_Left Buttons
        general_left_btn_load.setOnAction(event -> {
            worldSelect();
            reloadDatabase();

        });
        general_left_btn_new.setOnAction(event -> {});
        general_left_btn_setting.setOnAction(event -> {});
        general_left_btn_aboutUs.setOnAction(event -> {});
        general_left_btn_exit.setOnAction(event -> {System.exit(1);});
        //
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

    private void worldSelect(){
        Stage worldSelect_prompt = new Stage();
        worldSelect_prompt.setTitle("Select a World");
        HBox layout = new HBox();
        ChoiceBox<String> selection = new ChoiceBox<>();
        selection.setPrefSize(250,60.0);
        for (String in: world_paths){
            selection.getItems().add(in);
        }

        Button submit = new Button("Submit");
        submit.setPrefSize(60,40);
        submit.setOnAction(event -> {
            selected_world = selection.getValue();
            worldSelect_prompt.close();
        });


        layout.getChildren().addAll(selection,submit);
        Scene scene = new Scene(layout);
        worldSelect_prompt.setScene(scene);
        worldSelect_prompt.showAndWait();
    }

    private void reloadDatabase(){
        this.database = new Cute(selected_world);
    }



    public Scene getScene(){
        return main;
    }

}

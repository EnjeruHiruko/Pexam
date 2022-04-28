package Pexam.ui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class PokemonCreator {

    private Scene scene;

    public PokemonCreator(){
        //left side Menu
        VBox leftMenu = new VBox();
        leftMenu.setSpacing(10);
        leftMenu.setPadding(new Insets(0,20,10,20));


        //labels
        Label newP = new Label("new");
        Label editP = new Label("edit");
        Label delete = new Label("delete");

        // Buttons
        Button b_newP = new Button("new");
        Button b_editP = new Button("edit");
        Button b_delete = new Button(("delete"));

        leftMenu.getChildren().addAll(b_newP, b_editP, b_delete);

        //center Menu
        GridPane centerMenu = new GridPane();

        //tests
        Button t1 = new Button("Test1 ");
        Button t2 = new Button("Test2 ");
        Button t3 = new Button("Test3 ");
        Button t4 = new Button("Test4 ");

        centerMenu.setPadding(new Insets(10,10,10,10));



        centerMenu.add(t1,0,0);
        centerMenu.add(t2, 3, 3);
        centerMenu.add(t3, 0,4);
        centerMenu.add(t4,2,2);

        //main layout
        BorderPane layout = new BorderPane();
        layout.setLeft(leftMenu);
        layout.setCenter(centerMenu);
        layout.setPadding(new Insets(20, 0,20,20));


        this.scene = new Scene(layout, Color.GREY);

    }
    public Scene getScene(){
        return this.scene;
    }
}

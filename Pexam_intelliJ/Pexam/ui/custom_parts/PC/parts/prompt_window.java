package Pexam.ui.custom_parts.PC.parts;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.security.Key;

public class prompt_window {

    static String value_;

    public static String display(String title, String Message){
        Stage window = new Stage();

        value_ = null;

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(500);
        window.setMinHeight(200);

        Label label = new Label();
        label.setText(Message);

        TextField input = new TextField();
        input.setMinSize(400,30);
        input.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.ENTER){
                    value_ = input.getText();
                    window.close();
                }
            }
        });


        Button submit = new Button("Submit");
        submit.setOnAction(e -> {
            value_ = input.getText();
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, input,submit);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);

        window.setScene( scene);
        window.showAndWait();

        return value_;
    }
}
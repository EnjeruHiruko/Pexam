package Pexam.ui.Scenes.Teams.parts;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class teams_LeftMenu extends AnchorPane {

    private Button btn_return;

    public teams_LeftMenu(){
        super();
        this.setPrefWidth(300);
        this.setPadding(new Insets(10,10,10,10));
        this.setStyle("-fx-background-color: #121212");

        //Content
        VBox menu = new VBox();
        menu.setPrefWidth(300);
        menu.setAlignment(Pos.BOTTOM_CENTER);
        menu.setStyle("-fx-background-color: white");


        AnchorPane.setTopAnchor(menu, 0.0);
        AnchorPane.setLeftAnchor(menu, 0.0);
        AnchorPane.setBottomAnchor(menu, 0.0);
        AnchorPane.setRightAnchor(menu, 0.0);

        //Buttons
        String styleString = "-fx-background-color: white; -fx-text-fill: #121212; -fx-font: 40 arial; -fx-border-color: white";

        btn_return = new Button("Return");
        btn_return.setStyle(styleString);
        btn_return.setAlignment(Pos.CENTER_LEFT);
        btn_return.setPrefWidth(300);
        menu.getChildren().addAll(btn_return);


        this.getChildren().addAll(menu);
    }

    public Button getBtn_return() {
        return btn_return;
    }

}

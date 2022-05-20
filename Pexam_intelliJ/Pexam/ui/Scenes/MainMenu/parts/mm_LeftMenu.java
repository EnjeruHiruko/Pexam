package Pexam.ui.Scenes.MainMenu.parts;

import Pexam.ui.UserInterface;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class mm_LeftMenu extends AnchorPane {

    private Button btn_ng;

    private Button btn_lg;

    private Button btn_r;

    private Button btn_s;

    private Button btn_au;

    private Button btn_e;

    private VBox menu;


    public mm_LeftMenu(){
        super();
        this.setPrefWidth(300);
        this.setPadding(new Insets(10,10,10,10));
        this.setStyle("-fx-background-color: #121212");

        this.menu = new VBox();
        menu.setPrefWidth(300);
        menu.setAlignment(Pos.BOTTOM_CENTER);
        menu.setStyle("-fx-background-color: white");

        VBox t1 = new VBox();
        VBox t2 = new VBox();

        //Buttons
        this.btn_ng = new Button("New..");
        this.btn_lg = new Button("Load..");
        this.btn_r = new Button("Rules..");
        this.btn_au = new Button("About Us..");
        this.btn_s = new Button("Settings..");
        this.btn_e = new Button("Exit");

        //Button Styles
        int fontsize = ((int) (this.getHeight() / 2)) +10;
        String styleString = "-fx-background-color: white; -fx-text-fill: #121212; -fx-font: 40 arial; -fx-border-color: white";
        btn_lg.setStyle(styleString);
        btn_ng.setStyle(styleString);
        btn_r.setStyle(styleString);
        btn_au.setStyle(styleString);
        btn_s.setStyle(styleString);
        btn_e.setStyle(styleString);

        btn_lg.setAlignment(Pos.CENTER_LEFT);
        btn_r.setAlignment(Pos.CENTER_LEFT);
        btn_ng.setAlignment(Pos.CENTER_LEFT);
        btn_s.setAlignment(Pos.CENTER_LEFT);
        btn_au.setAlignment(Pos.CENTER_LEFT);
        btn_e.setAlignment(Pos.CENTER_LEFT);

        //Button Min Size
        int pref_width = 300;
        btn_ng.setPrefWidth(pref_width);
        btn_lg.setPrefWidth(pref_width);
        btn_r.setPrefWidth(pref_width);
        btn_e.setPrefWidth(pref_width);
        btn_au.setPrefWidth(pref_width);
        btn_s.setPrefWidth(pref_width);

        AnchorPane.setTopAnchor(menu, 0.0);
        AnchorPane.setLeftAnchor(menu, 0.0);
        AnchorPane.setBottomAnchor(menu, 0.0);
        AnchorPane.setRightAnchor(menu, 0.0);

        //Button Events
        btn_e.setOnAction(event -> {
            System.exit(1);
        });
        btn_lg.setOnAction(event -> {

        });



        //Finishing Touches
        menu.getChildren().addAll(btn_lg, btn_ng, btn_r, btn_s, btn_au, btn_e);

        this.getChildren().addAll(menu);
    }

    public Button getBtn_ng() {
        return btn_ng;
    }

    public Button getBtn_lg() {
        return btn_lg;
    }

    public Button getBtn_r() {
        return btn_r;
    }

    public Button getBtn_s() {
        return btn_s;
    }

    public Button getBtn_au() {
        return btn_au;
    }

    public Button getBtn_e() {
        return btn_e;
    }

    public VBox getMenu() {
        return menu;
    }
}

package Pexam.ui.custom_parts.PC.parts;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class window_stackpane_background extends StackPane {
    public window_stackpane_background(Pane content){
        super();
        Rectangle white_border = new Rectangle(1560,460);
        Rectangle bg = new Rectangle(1540,990);

        white_border.setFill(Color.WHITE);
        bg.setFill(Color.web("#121212"));
        Rectangle ehh = new Rectangle(1560,460);
        ehh.setFill(Color.RED);
        Rectangle bg_spac = new Rectangle(1560,90);
        bg_spac.setFill(Color.web("#121212"));

        VBox stackpane_bg = new VBox();
        stackpane_bg.setMaxSize(1560, 1010);
        stackpane_bg.getChildren().addAll(ehh, bg_spac,white_border);

        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(0,0,10,0));
        this.getChildren().addAll(stackpane_bg,bg, content);
        //Content MaxSize = 1520 x 970

    }
}

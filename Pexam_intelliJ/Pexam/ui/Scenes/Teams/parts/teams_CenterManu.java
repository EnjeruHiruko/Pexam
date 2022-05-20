package Pexam.ui.Scenes.Teams.parts;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class teams_CenterManu extends AnchorPane {

    private teams_CenterBackground background;

    private AnchorPane sub_scene_adex;

    private AnchorPane sub_scene_mdex;

    private AnchorPane sub_scene_pdex;

    private AnchorPane sub_scene_pviewer;

    private AnchorPane sub_scene_tviewer;

    public teams_CenterManu(){
        super();
        this.background = new teams_CenterBackground();

        StackPane test = new StackPane();

        test.getChildren().addAll(background);

        AnchorPane.setTopAnchor(test, 0.0);
        AnchorPane.setLeftAnchor(test, 0.0);
        AnchorPane.setBottomAnchor(test, 0.0);
        AnchorPane.setRightAnchor(test, 0.0);

        this.getChildren().addAll(test);
    }
}

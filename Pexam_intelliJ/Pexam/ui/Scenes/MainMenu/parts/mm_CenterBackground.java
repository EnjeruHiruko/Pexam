package Pexam.ui.Scenes.MainMenu.parts;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class mm_CenterBackground extends Group {

    public mm_CenterBackground(){
        super();



        //this.setPadding(new Insets(10,10,10,10));

        Image front_cover = new Image("./Pexam/ui/resources/Pexam_frontcover.png");
        ImageView iv = new ImageView(front_cover);

        this.getChildren().add(iv);

    }

}

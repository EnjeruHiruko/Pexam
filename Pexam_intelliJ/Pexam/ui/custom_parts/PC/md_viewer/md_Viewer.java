package Pexam.ui.custom_parts.PC.md_viewer;

import Pexam.data.Combatant.Pokemon.Species;
import Pexam.data.Moves.Moves;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;

public class md_Viewer extends HBox {
    public md_Viewer(){
        super();

        //TableView
        TableView<Moves> dex = new md_DexView().getTableView();

        //Preview
        md_Preview full = new md_Preview();

        //Event
        dex.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Moves>() {
            @Override
            public void changed(ObservableValue<? extends Moves> observable, Moves oldValue, Moves newValue) {
                full.changeView(newValue);
            }
        });

        this.getChildren().addAll(dex, full);
        this.setPadding(new Insets(0,10,0,10));

    }
}

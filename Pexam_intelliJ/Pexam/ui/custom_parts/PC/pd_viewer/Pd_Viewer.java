package Pexam.ui.custom_parts.PC.pd_viewer;

import Pexam.data.Combatant.Pokemon.Species;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;

public class Pd_Viewer extends HBox {



    public Pd_Viewer(){
        super();



        //ListViewer
        TableView<Species> dex = new pd_DexView().getTableView();

        //GridPane
        pd_Prieview full = new pd_Prieview();

        //Event
        dex.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Species>() {
            @Override
            public void changed(ObservableValue<? extends Species> observable, Species oldValue, Species newValue) {
                full.changeView(newValue);
            }
        });

        this.getChildren().addAll(dex, full);
        this.setPadding(new Insets(0,10,0,10));

    }


}

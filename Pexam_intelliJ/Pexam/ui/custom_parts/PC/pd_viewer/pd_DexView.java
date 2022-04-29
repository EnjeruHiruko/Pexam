package Pexam.ui.custom_parts.PC.pd_viewer;

import Pexam.data.Combatant.Pokemon.Species;
import Pexam.data.utility.Enums.Type;
import Pexam.ui.custom_parts.PC.Creator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class pd_DexView {

    TableView<Species> table;

    public pd_DexView(){

        String bg_hex = "#121212";
        // Species Column
        TableColumn<Species, String> speciesColumn = new TableColumn<>("Species");
        speciesColumn.setMinWidth(200);
        speciesColumn.setMaxWidth(300);
        speciesColumn.setCellValueFactory(new PropertyValueFactory<>("species"));

        // Dexnumber Column
        TableColumn<Species, Integer> dexnumberColumn = new TableColumn<>("Dex Number");
        dexnumberColumn.setMinWidth(100);
        dexnumberColumn.setMaxWidth(100);
        dexnumberColumn.setCellValueFactory(new PropertyValueFactory<>("DexNumber"));

        // Type Column
        TableColumn<Species, ArrayList<Type>> typeColumn = new TableColumn<>("Type");
        typeColumn.setMinWidth(200);
        typeColumn.setMaxWidth(200);
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("types"));

        table = new TableView<>();
        table.setItems(getView());
        table.getColumns().addAll(speciesColumn,dexnumberColumn,typeColumn);
        table.setMaxWidth(600);
        table.setStyle("-fx-background-color: "+bg_hex+";");
        table.setEditable(false);
        table.setPadding(new Insets(0,10,0,0));


    }
    private ObservableList<Species> getView(){
        ObservableList<Species> viewer = FXCollections.observableArrayList();
        viewer.addAll(Creator.getTest().getPokemonPreview());
        return viewer;
    }

    public TableView<Species> getTableView(){
        return table;
    }

}

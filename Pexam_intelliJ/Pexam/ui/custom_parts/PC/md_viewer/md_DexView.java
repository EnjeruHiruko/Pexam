package Pexam.ui.custom_parts.PC.md_viewer;

import Pexam.data.Combatant.Pokemon.Species;
import Pexam.data.Moves.Moves;
import Pexam.data.utility.Damage.DamageBase;
import Pexam.data.utility.Damage.DamageClass;
import Pexam.data.utility.Enums.Frequency;
import Pexam.data.utility.Enums.Type;
import Pexam.ui.custom_parts.PC.Creator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class md_DexView {
    TableView<Moves> table;

    public md_DexView(){

        String bg_hex = "#121212";
        // Moves Name
        TableColumn<Moves, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));

        // Moves Type
        TableColumn<Moves, Type> typeColumn = new TableColumn<>("Type");
        typeColumn.setMinWidth(80);
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("Type"));

        // Move Frequency
        TableColumn<Moves, Frequency> frequencyColumn = new TableColumn<>("Freq");
        frequencyColumn.setMinWidth(70);
        frequencyColumn.setCellValueFactory(new PropertyValueFactory<>("Frequency"));

        // Move AC
        TableColumn<Moves, Integer> acColumn = new TableColumn<>("AC");
        acColumn.setMinWidth(40);
        acColumn.setCellValueFactory(new PropertyValueFactory<>("AC"));

        // Moves DamageBase
        TableColumn<Moves, DamageBase> dbColumn = new TableColumn<>("DB");
        dbColumn.setMinWidth(80);
        dbColumn.setCellValueFactory(new PropertyValueFactory<>("DB"));

        // Moves DamageClass
        TableColumn<Moves, DamageClass> dcColumn = new TableColumn<>("DC");
        dcColumn.setMinWidth(50);
        dcColumn.setCellValueFactory(new PropertyValueFactory<>("DamageClass"));

        // Moves Range
        TableColumn<Moves, String> rangeColumn = new TableColumn<>("Range");
        rangeColumn.setMinWidth(120);
        rangeColumn.setCellValueFactory(new PropertyValueFactory<>("Range"));

        // Moves Effect
        TableColumn<Moves, String> effectColumn = new TableColumn<>("Effect");
        effectColumn.setMinWidth(500);
        effectColumn.setCellValueFactory(new PropertyValueFactory<>("Effect"));

        int size = 1240;

        table = new TableView<>();
        table.setItems(getView());
        table.getColumns().addAll(nameColumn,typeColumn,frequencyColumn,acColumn,dbColumn,dcColumn,rangeColumn,effectColumn);
        table.setStyle("-fx-background-color: "+bg_hex+";");
        table.setEditable(false);
        table.setPadding(new Insets(0,10,0,0));


    }
    private ObservableList<Moves> getView(){
        ObservableList<Moves> viewer = FXCollections.observableArrayList();
        viewer.addAll(Creator.getTest().getMovesPreview());
        return viewer;
    }

    public TableView<Moves> getTableView(){
        return table;
    }
}

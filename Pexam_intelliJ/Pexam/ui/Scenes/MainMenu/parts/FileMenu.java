package Pexam.ui.Scenes.MainMenu.parts;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class FileMenu extends MenuBar {
    public FileMenu(){
        super();

        //
        Menu content = new Menu("_File");

        //Menu Items
        MenuItem settings = new MenuItem("Settings...");
        MenuItem worlds = new MenuItem("Worlds...");
        MenuItem about_us = new MenuItem("About Us...");
        MenuItem help = new MenuItem("Help...");
        MenuItem exit = new MenuItem("Exit");

        //Adding Items to Menu
        content.getItems().addAll(settings,worlds,about_us,help,exit);

        //Events
        exit.setOnAction(event -> System.exit(1));


        this.getMenus().addAll(content);

    }
}

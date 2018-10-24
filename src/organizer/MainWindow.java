/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author author name
 */
public class MainWindow extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage mainStage) {
        homeWindowBuild(mainStage);

    }

    public void homeWindowBuild(Stage mainStage) {
        mainStage.setTitle("Main Window");
        VBox vBox = new VBox();
        MenuBar menuBar = new MenuBar();
        BorderPane contentPane = new BorderPane();

        //menu --file [] move to separate class maybe if it gets big enough
        Menu menuFile = new Menu("File");

        //menu --options [] move to separate class?
        Menu menuOption = new Menu("Options");

        //** put a try and catch incase file not found
        // this is for the hourglass timer
        Image imgHrGlass = new Image(getClass().getResourceAsStream("/images/hourglass.png"));
        ImageView hourGlassImage = new ImageView(imgHrGlass);
        Label timerLabel = new Label("", hourGlassImage);
        Timer timerObject = new Timer();
        timerLabel.setOnMousePressed(event -> timerObject.drawTimerWindow(contentPane));
        Menu menuTimer = new Menu("", timerLabel);

        //** put a try and catch incase file not found
        // this is for the hourglass timer
        Image imgToDo = new Image(getClass().getResourceAsStream("/images/Untitled.png"));
        ImageView toDoImage = new ImageView(imgToDo);
        Label toDoLabel = new Label("", toDoImage);
        ToDo toDoObject = new ToDo();
        toDoLabel.setOnMousePressed(event -> toDoObject.drawToDoWindow(contentPane));
        Menu menuToDo = new Menu("", toDoLabel);

        menuBar.getMenus().addAll(menuFile, menuOption, menuTimer, menuToDo);
        vBox.getChildren().addAll(menuBar, contentPane);

        Scene defaultScene = new Scene(vBox, 800, 600);
        mainStage.setScene(defaultScene);
        mainStage.show();

    }

    public void loadTimer() {

    }
}

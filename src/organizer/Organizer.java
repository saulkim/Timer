/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizer;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author
 */
public class Organizer extends Application {

    private static BorderPane root = new BorderPane();

    public static BorderPane getRoot() {
        return root;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        URL menuBarURL = getClass().getResource("MainMenu.fxml");
        MenuBar menuBar = FXMLLoader.load(menuBarURL);

        //default behavior loading timer, make it load a home page first later
        URL timerURL = getClass().getResource("TimerView.fxml");
        AnchorPane timerAPane = FXMLLoader.load(timerURL);

//        URL toDoURL = getClass().getResource("Todo.fxml");
//        AnchorPane toDoAPane = FXMLLoader.load(toDoURL);

        root.setTop(menuBar);
        root.setCenter(timerAPane);

        Scene scene = new Scene(root, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

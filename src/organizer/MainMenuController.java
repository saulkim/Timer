/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizer;

import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author
 */
public class MainMenuController {

    @FXML
    private Label timerLabel;
    @FXML
    private Label toDoLabel;

    @FXML
    private void openTimer(MouseEvent event) {
        try {
            System.out.println("timer clicked");
            URL timerURL = getClass().getResource("TimerView.fxml");
            AnchorPane timerAPane = FXMLLoader.load(timerURL);

            BorderPane border = Organizer.getRoot();
            border.setCenter(timerAPane);
            System.out.println("timer clicked ended");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void openToDo(MouseEvent event) {
        try {
            System.out.println("todo clicked");
            URL toDoURL = getClass().getResource("ToDo.fxml");
            AnchorPane toDoAPane = FXMLLoader.load(toDoURL);

            BorderPane border = Organizer.getRoot();
            border.setCenter(toDoAPane);
            System.out.println("todo clicked ended");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

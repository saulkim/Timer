/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizer;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author
 */
public class ToDo {

    public void drawToDoWindow(BorderPane contentPane) {
        contentPane.getChildren().clear();
        StackPane toDoPane = new StackPane();
        double r = Math.random();
        double g = Math.random();
        double b = Math.random();
        Color randColor = new Color(r, g, b, 1);

        toDoPane.getChildren().addAll(new Rectangle(200, 400, randColor));
        contentPane.setCenter(toDoPane);
    }
}

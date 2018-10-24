/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizer;

import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


/**
 *
 * icon: hourglass
 */
public class Timer {
    
    //make it have innate stuff later
    public Timer timerObject;
    
    //when opened
    private void clickedMainIcon() {
        double d = Math.random();
        System.out.println("mouse clicked, rng: " + d);
 
    }
    
    public void drawTimerWindow(BorderPane contentPane){
        clickedMainIcon();
        contentPane.getChildren().clear();
        
        //hourglass box
        StackPane timerPane = new StackPane();
        double r = Math.random();
        double g = Math.random();
        double b = Math.random();
        Color randColor = new Color(r, g, b, 1);
        timerPane.getChildren().addAll(new Rectangle(300, 300, randColor));
        
        //countdown timer box
        StackPane countDownPane = new StackPane();
        Rectangle cdBox = new Rectangle(400,200, Color.BLUE);
        countDownPane.getChildren().addAll(cdBox);
        
        //setting actual window
        contentPane.setCenter(timerPane);
        contentPane.setBottom(countDownPane);
    }


}

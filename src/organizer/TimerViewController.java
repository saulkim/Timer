/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizer;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.control.ToggleButton;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author
 */
public class TimerViewController implements Initializable {

    @FXML
    private Label countdownTimerLbl;
    @FXML
    private Label cdTimerHnM; //the label below the progress bar for when i want a min/sec display
    @FXML
    private Spinner<Integer> minSpin;
    @FXML
    private Spinner<Integer> secSpin;
    @FXML
    private Button startBtn;
    @FXML
    private ToggleButton pauseToggleBtn;
    @FXML
    private ProgressBar progressBar;

    private Timeline timeline;
    private Boolean running = false;

    @FXML
    //make this thing get the value as is in spinner field, not having to press enter into spinner
    private void startTimer() {

//        int minutes = minSpin.getValue();
//        int seconds = secSpin.getValue();
        String minutesStr = minSpin.getEditor().getText(); //done because javafx does not commit on text field change
        if (minutesStr.equals("")) {
            minutesStr = "0";
        }
        String secondsStr = secSpin.getEditor().getText();
        if (secondsStr.equals("")) {
            minutesStr = "0";
        }
        int minutesValue = Integer.parseInt(minutesStr);
        int secondsValue = Integer.parseInt(secondsStr);

        int minutesToSeconds = minutesValue * 60;
        int totalSeconds = minutesToSeconds + secondsValue;

        IntegerProperty timeLeft = new SimpleIntegerProperty(totalSeconds);

        progressBar.progressProperty().bind(timeLeft.divide(totalSeconds * 1.0));
        countdownTimerLbl.textProperty().bind(timeLeft.asString());

        //IntegerProperty timeLeft2 = timeLeft;
        countDownStart(timeLeft, totalSeconds);

    }

    private void countDownStart(IntegerProperty timeLeft, int totalSeconds) {

        running = true;
        pauseToggleBtn.setVisible(true);
        pauseToggleBtn.setSelected(false);
        pauseToggleBtn.setText("pause");
        pauseToggleBtn.arm();

        if (timeline != null) {
            timeline.stop();
        }

        timeLeft.set(totalSeconds);
        timeline = new Timeline();
        KeyValue keyValue = new KeyValue(timeLeft, 0);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(totalSeconds), e -> {
            pauseToggleBtn.disarm();
        }, keyValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.playFromStart();

    }

    @FXML
    private void pauseToggleTimer() {
        if (pauseToggleBtn.isSelected() == true) {
            timeline.pause();
            pauseToggleBtn.setText("resume");
            running = false;

        } else {
            timeline.play();
            pauseToggleBtn.setText("pause");
            running = true;
        }
    }

    private void doStuff() {
        System.out.println("organizer.TimerViewController.dostuff()");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //make these initializable custom
        int minStartValue = 2;
        int secStartValue = 0;

        SpinnerValueFactory<Integer> minValueFac = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, minStartValue);
        SpinnerValueFactory<Integer> secValueFac = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, secStartValue);
        minSpin.setValueFactory(minValueFac);
        secSpin.setValueFactory(secValueFac);

        //text filter so only numbers are allowed
        UnaryOperator<Change> filter = change -> {
            String text = change.getText();
            if (text.matches("[0-9]*")) {
                return change;
            } else {
                return null;
            }
        };

        TextFormatter<String> minTextFormatter = new TextFormatter<>(filter);
        TextFormatter<String> secTextFormatter = new TextFormatter<>(filter);
        minSpin.getEditor().setTextFormatter(minTextFormatter);
        secSpin.getEditor().setTextFormatter(secTextFormatter);

        minSpin.setEditable(true);
        secSpin.setEditable(true);

        pauseToggleBtn.setVisible(false);
        pauseToggleBtn.disarm();

    }

}

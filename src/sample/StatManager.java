package sample;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

/**
* Class for managing the stat pane. Contains methods for incrementing and resetting the score. The other methods
* are used for initializing the object.
*/

public class StatManager {

    private sample.Game game;
    private VBox statPane;
    private Label scoreLabel;
    private Label triesLabel;
    private int score;
    private int tries;
    private Button resetButton;

    public StatManager(Game game) {
        this.game = game;
        statPane = new VBox();
        statPane.setAlignment(Pos.CENTER);
        initTriesLabel();
        initScoreLabel();
        initResetButton();
    }

    private void initScoreLabel() {
        scoreLabel = new Label();
        score = 0;
        scoreLabel.setText("Score: " + score);
        statPane.getChildren().add(scoreLabel);
    }

    private void initTriesLabel() {
        triesLabel = new Label();
        tries = 0;
        triesLabel.setText("Tries: " + tries);
        statPane.getChildren().add(triesLabel);
    }

    private void initResetButton() {
        resetButton = new Button();
        resetButton.setText("Retry");
        resetButton.setOnAction(event -> game.restart());
        resetButton.setPrefHeight(200);
        resetButton.setPrefWidth(50);
        statPane.getChildren().add(resetButton);
    }

    public void resetScore() {
        score = 0;
        scoreLabel.setText("Score: " + score);
    }

    public void resetTries() {
        tries = 0;
        triesLabel.setText("Tries: " + tries);
    }

    public void incrementScore() {
        score++;
        scoreLabel.setText("Score: " + score);
    }

    public void incrementTries() {
        tries++;
        triesLabel.setText("Tries: " + tries);
    }

    public void checkForWin() {
        if (score == 8) { // max score is achieved
            ButtonType playAgain = new ButtonType("Play again", ButtonBar.ButtonData.OK_DONE);
            ButtonType exitGame = new ButtonType("Exit game", ButtonBar.ButtonData.CANCEL_CLOSE);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "You won!\nPlay again or exit game?", playAgain, exitGame);
            alert.showAndWait();

            if (alert.getResult() == playAgain) {
                game.restart();
            } else {
                System.exit(0);
            }
        }
    }

    public VBox getStatPane() {
        return statPane;
    }


}

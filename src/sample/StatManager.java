package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class StatManager {

    private Game game;
    private VBox statPane;
    private Label scoreLabel;
    private int score;
    private Button resetButton;

    public StatManager(Game game) {
        this.game = game;
        statPane = new VBox();
        statPane.setAlignment(Pos.CENTER);
        initScoreLabel();
        initResetButton();

    }

    private void initScoreLabel() {
        scoreLabel = new Label();
        score = 0;
        scoreLabel.setText("Score: " + score);
        statPane.getChildren().add(scoreLabel);
    }

    private void initResetButton() {
        resetButton = new Button();
        resetButton.setText("Retry");
        resetButton.setOnAction(event -> {
            game.restart();
        });
        resetButton.setPrefHeight(200);
        resetButton.setPrefWidth(50);
        statPane.getChildren().add(resetButton);
    }

    public void resetScore() {
        score = 0;
        scoreLabel.setText("Score: " + score);
    }

    public void incrementScore() {
        score++;
        scoreLabel.setText("Score: " + score);
    }

    public VBox getStatPane() {
        return statPane;
    }


}

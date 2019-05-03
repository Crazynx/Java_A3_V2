package sample;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Game {

    private CardManager cardManager;
    private StatManager statManager;
    private Scene mainScene;
    private BorderPane mainPane;
    private GridPane cardPane;
    private VBox statPane;

    public Game() {

        statManager = new StatManager(this);
        cardManager = new CardManager(statManager);
        mainPane = new BorderPane();
        statPane = statManager.getStatPane();
        cardPane = cardManager.getCardPane();
        mainPane.setRight(statPane);
        mainPane.setLeft(cardPane);

        mainScene = new Scene(mainPane);
    }

    public Scene getMainScene() {
        return mainScene;
    }

    public void restart() {
        cardManager.clearMatchedCards();
        cardManager.resetCards();
        cardManager.shuffleCards();
        cardManager.removeCardsFromPane();
        cardManager.setCardsToPane();
        statManager.resetScore();
    }



}

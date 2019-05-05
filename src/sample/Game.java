package sample;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
* Class that's responsible for creating the memory game. It's initializing other objects used for the game and
* sets the needed objects to the mainPane.
*/

public class Game {

    private CardManager cardManager;
    private StatManager statManager;
    private Scene mainScene;
    private BorderPane mainPane;
    private GridPane cardPane;
    private VBox statPane;

    public Game() {
        // create objects that handle the cards and statistics about the game
        statManager = new StatManager(this);
        cardManager = new CardManager(statManager);
        // set panes
        mainPane = new BorderPane();
        statPane = statManager.getStatPane();
        cardPane = cardManager.getCardPane();
        // set position of panes
        mainPane.setRight(statPane);
        mainPane.setLeft(cardPane);
        // create new scene
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

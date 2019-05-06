package sample;

import javafx.animation.PauseTransition;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import java.util.*;

/**
* Class for managing the card pane, this class initializes the pane, variables needed in checkForMatch when
* a object is created from this class. It also has methods which are used when resetting the game
*/

public class CardManager {

    private GridPane cardPane;
    private List<Card> cardList;
    private List<Card> matchedCards;
    private StatManager statManager;
    private Card previousCard;
    private boolean isCheckingForMatch;

    public CardManager(StatManager statManager) {
        this.statManager = statManager;
        cardPane = new GridPane();
        cardList = new ArrayList<>();
        matchedCards = new ArrayList<>();
        isCheckingForMatch = false;
        initCardList();
        shuffleCards();
        setCardsToPane();
    }

    public GridPane getCardPane() {
        return cardPane;
    }

    public void clearMatchedCards() {
        matchedCards.clear();
    }

    public void  resetCards() {
        for (Card card : cardList) {
            card.setTurnable();
        }
    }

    public void shuffleCards() {
        Collections.shuffle(cardList);
    }

    public void removeCardsFromPane() {
        for (Card card : cardList) {
            cardPane.getChildren().remove(card);
        }
    }

    public void setCardsToPane() {
        int cardIndex = 0;
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                cardPane.add(cardList.get(cardIndex), column, row);
                cardIndex++;
            }
        }
    }

    private void checkForMatch(Card card) {
        if (!isCheckingForMatch) { // check if not already checking for match
            card.turnCard();
            if (previousCard != null && previousCard != card) {
                if (!matchedCards.contains(card) && !matchedCards.contains(previousCard)) {
                    isCheckingForMatch = true;
                    if (card.getValue() == previousCard.getValue()) { // match
                        if (card != previousCard) {
                            card.setUnturnable();
                            previousCard.setUnturnable();
                            statManager.incrementScore();
                            matchedCards.add(card);
                            matchedCards.add(previousCard);
                            previousCard = null;
                            isCheckingForMatch = false;
                            statManager.checkForWin();
                        }
                    } else { // no match
                        PauseTransition delay = new PauseTransition(Duration.millis(700));
                        delay.setOnFinished(event -> {
                            card.turnCard();
                            previousCard.turnCard();
                            previousCard = null;
                            isCheckingForMatch = false;
                            statManager.incrementTries();
                        });
                        delay.play();
                    }
                }
            } else if (!matchedCards.contains(card)) {
                if (!card.isTurned()) { // prevent one card being turned and the other being unturned
                    card.turnCard();
                }
                previousCard = card;
            }
        }
    }

    private void initCardList() {
        int cardValue = 1;
        for (int x = 0; x < 16; x++) {
            if (x % 2 == 0) {
                cardValue++;
            }
            Card card = new Card(cardValue);
            card.setOnAction(event -> checkForMatch(card));
            cardList.add(card);
        }
    }
}

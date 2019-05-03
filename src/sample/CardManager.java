package sample;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.*;

public class CardManager {

    private GridPane cardPane;
    private List<Card> cardList;
    private List<Card> matchedCards;
    private StatManager statManager;
    private Card previousCard;

    public CardManager(StatManager statManager) {
        this.statManager = statManager;
        cardPane = new GridPane();
        cardList = new ArrayList<>();
        matchedCards = new ArrayList<>();
        initCardList();
        shuffleCards();
        setCardsToPane();
    }

    public GridPane getCardPane() {
        return cardPane;
    }

    public void clearMatchedCards() {
        System.out.println(matchedCards.toString());
        matchedCards.clear();
        System.out.println(matchedCards.toString());
    }

    public void  resetCards() {
        for (Card card : cardList) {
            System.out.println(card);
            card.setTurnable();
            System.out.println("--------------------------------");
            System.out.println(card);
        }
    }

    public void shuffleCards() {
        Collections.shuffle(cardList);
    }

    public void removeCardsFromPane() {
        for (int x = 0; x < cardList.size(); x++) {
            cardPane.getChildren().remove(cardList.get(x));
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
        card.turnCard();
        if (previousCard != null) {
            if (!matchedCards.contains(card) && !matchedCards.contains(previousCard)) {
                if (card.getValue() == previousCard.getValue()) {
                    if (card != previousCard) {
                        card.setUnturnable();
                        previousCard.setUnturnable();

                        statManager.incrementScore();
                        matchedCards.add(card);
                        matchedCards.add(previousCard);
                        System.out.println(card);
                        System.out.println(previousCard);
                        previousCard = null;
                    }
                } else {
                    System.out.println("No match");
                    System.out.println("Prev. card: " + previousCard.getValue());
                    System.out.println(card.getValue());
                    PauseTransition delay = new PauseTransition(Duration.seconds(1));
                    delay.setOnFinished( event -> {
                        card.turnCard();
                        previousCard.turnCard();
                        previousCard = null;
                    });
                    delay.play();
                }
            }
        } else {
            previousCard = card;
        }
    }

    private void initCardList() {
        int cardValue = 1;
        for (int x = 0; x < 16; x++) {
            if (x % 2 == 0) {
                cardValue++;
            }
            Card card = new Card(cardValue);
            card.setOnAction(event -> {
                checkForMatch(card);
            });
            cardList.add(card);
        }
    }
}

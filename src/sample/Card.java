package sample;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
* Class that inherits the JavaFX button but has some homemade methods such as setValue which are useful for comparing
* two cards. It also has methods which "turn" the card, but in reality it just sets the opposite ImageView to the card.
*/


public class Card extends Button {

    private int value;
    private boolean isTurned;
    private boolean isTurnable;
    private Image frontSideImage;
    private Image backSideImage;
    private ImageView frontSide;
    private ImageView backSide;

    public Card(int value) {
        this.value = value;
        isTurned = false;
        isTurnable = true;
        setFrontSide();
        setBackSide();

        setGraphic(backSide);
    }

    public void setTurnable() {
        setGraphic(backSide);
        isTurnable = true;
        isTurned = false;
    }

    public void setUnturnable() {
        setGraphic(frontSide);
        isTurnable = false;
        isTurned = true;
    }

    public boolean isTurned() {
        return isTurned;
    }

    public void turnCard() {
        if (isTurnable) {
            if (isTurned) {
                setGraphic(backSide);
                isTurned = false;
            } else {
                setGraphic(frontSide);
                isTurned = true;
            }
        }
    }

    public int getValue() {
        return value;
    }

    private void setFrontSide() {
        frontSideImage = new Image(String.valueOf(getClass().getResource("resources/card_front_" + value + ".png")));
        frontSide = new ImageView(frontSideImage);
        frontSide.setFitHeight(100);
        frontSide.setFitWidth(75);
    }

    private void setBackSide() {
        backSideImage = new Image(String.valueOf(getClass().getResource("resources/card_back.png")));
        backSide = new ImageView(backSideImage);
        backSide.setFitHeight(100);
        backSide.setFitWidth(75);
    }

    public String toString() {
        return "Value: " + value + "\n IsTurned: " + isTurned + "\n IsTurnable: " + isTurnable + "\n";
    }
}

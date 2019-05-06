import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Card extends Button {

    private int value;
    private boolean isCardTurned;
    private final String cardBackSideLocation = "resources/card_back.png";
    private ImageView frontSide;
    private ImageView backSide;

    public Card (int cardValue) {
        setValue(cardValue);
        setBackSide();
        setFrontSide();
        setLayoutX(cardValue*10);
        setLayoutY(cardValue*10);
    }

    private void setValue(int value) {
        this.value = value;
    }

    public int getValue() { return value; }

    private void setFrontSide() { // set front of card based on value
        Image frontSideImage = new Image("resources/card_front_" + value + ".png");
        frontSide = new ImageView(frontSideImage);
    }

    private void setBackSide() { // set back of card, the same for every card
        Image backSideImage = new Image(cardBackSideLocation);
        backSide = new ImageView(backSideImage);
    }

    public void turnCard() {
        if (isCardTurned) {
            setGraphic(backSide);
            isCardTurned = false;
        } else {
            setGraphic(frontSide);
            isCardTurned = true;
        }
    }



}

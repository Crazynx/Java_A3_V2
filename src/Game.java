import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Game {

    private static final int HEIGHT = 600;
    private static final int WIDTH = 800;
    private BorderPane mainPane;
    private FlowPane cardsPane;
    private VBox infoPane;
    private Scene mainScene;
    private Stage mainStage;

    public Game(int lengthAndWidth) {
        mainPane = new BorderPane();
        cardsPane = new FlowPane();
        cardsPane.setPrefWrapLength(130 * lengthAndWidth);

        mainScene = new Scene(mainPane, WIDTH, HEIGHT);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        createCards(lengthAndWidth * lengthAndWidth); // multiply to get amount of cards
    }

    public Stage getMainStage() {
        return mainStage;
    }

    private void createCards(int amount) {
        for (int x = 0; x < amount; x++) {
            Card card = new Card(x+1);
            cardsPane.getChildren().add(card);

            card.setOnMouseClicked(new EventHandler<Event>() {
                @Override
                public void handle(Event event) {
                    System.out.println("mouse clicked: card: " + card.getValue());
                }

            });
        }

    }

}

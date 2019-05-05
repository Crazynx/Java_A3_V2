package sample;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Game game = new Game();
        primaryStage.setScene(game.getMainScene());
        primaryStage.setHeight(460);
        primaryStage.setWidth(430);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(String.valueOf(getClass().getResource("resources/icons/memory.png"))));
        primaryStage.setTitle("Java A3 V2");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

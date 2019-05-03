package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Game game = new Game();
        primaryStage.setScene(game.getMainScene());
        primaryStage.setHeight(460);
        primaryStage.setWidth(430);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Java A3 V2 - Chad Version, Mady by Crazynx");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

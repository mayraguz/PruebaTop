package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.ui.Memorama;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Práctica de Topicos 2020");
        primaryStage.setMaximized(true);
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();

        new Memorama();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

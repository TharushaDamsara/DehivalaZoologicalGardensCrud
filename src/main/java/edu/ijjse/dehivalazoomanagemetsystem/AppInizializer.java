package edu.ijjse.dehivalazoomanagemetsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppInizializer extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Parent load = FXMLLoader.load(getClass().getResource("/view/UserPage.fxml"));
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.show();
    }
}

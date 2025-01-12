package edu.ijjse.dehivalazoomanagemetsystem;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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

        // Load and display the loading view
//        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/LoadingScreenView.fxml"))));
//        stage.show();
//
//        // Create a background task to load the main scene
//        Task<Scene> loadingTask = new Task<>() {
//            @Override
//            protected Scene call() throws Exception {
//                // Load the main layout from FXML
//                FXMLLoader fxmlLoader = new FXMLLoader(AppInizializer.class.getResource("/view/UserPage.fxml"));
//                return new Scene(fxmlLoader.load());
//            }
//        };
//
//        // What to do when loading is successful
//        loadingTask.setOnSucceeded(event -> {
//            Scene value = loadingTask.getValue();
//
            stage.setTitle("Dehivala Zoological Gardens");
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/media/logo.png")));
           // stage.setMaximized(true);
        stage.resizableProperty().setValue(Boolean.FALSE);
//
//            // Switch to the main scene
//            stage.setScene(value);
//        });
//
//        // What to do in case of loading failure (optional)
//        loadingTask.setOnFailed(event -> {
//            System.err.println("Failed to load the main layout."); // Print error message
//        });
//
//
//        // Start the task in a separate thread
//        new Thread(loadingTask).start();

    }
}

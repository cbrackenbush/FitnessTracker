package com.example.fitnesstracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class FitnessTrackerApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Load the FXML file
        FXMLLoader fxmlLoader = new FXMLLoader(FitnessTrackerApplication.class.getResource("tracker-view.fxml"));

        // Get the root VBox from the FXML file
        VBox root = fxmlLoader.load();

        // Ensure the VBox grows to fill the available space
        VBox.setVgrow(root, Priority.ALWAYS);

        // Create a Scene with the root VBox and set the window size dynamically
        Scene scene = new Scene(root, 800, 600);

        // Set the stage to be maximized
        stage.setMaximized(true);

        // Set up the stage
        stage.setTitle("Fitness Tracker");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

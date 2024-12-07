package com.example.fitnesstracker.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class TrackerController {

    @FXML
    private Button logActivityButton; // Reference to a button in the FXML file (used to get the current stage)

    @FXML
    private void showActivityLog() throws IOException {
        System.out.println("Log Activity button clicked");
        switchScene("/com/example/fitnesstracker/activity-log.fxml");
    }

    @FXML
    private void showProgress() throws IOException {
        System.out.println("View Progress button clicked");
        switchScene("/com/example/fitnesstracker/progress-view.fxml");
    }

    @FXML
    private void showGoals() throws IOException {
        System.out.println("Set Goals button clicked");
        switchScene("/com/example/fitnesstracker/goals-view.fxml");
    }

    private void switchScene(String fxmlFile) throws IOException {
        // Get the current stage using a reference to any node (logActivityButton in this case)
        Stage currentStage = (Stage) logActivityButton.getScene().getWindow();

        // Load the new scene
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));

        // Keep the same width and height as the current scene
        Scene currentScene = currentStage.getScene();
        Scene newScene = new Scene(root, currentScene.getWidth(), currentScene.getHeight());

        // Set the new scene to the stage
        currentStage.setScene(newScene);
        currentStage.show();
    }
}

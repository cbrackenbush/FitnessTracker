package com.example.fitnesstracker.controllers;

import com.example.fitnesstracker.models.Activity;
import com.example.fitnesstracker.data.FitnessTrackerData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ActivityLogController {

    @FXML
    private TextField typeField;
    @FXML
    private TextField durationField;
    @FXML
    private TextField distanceField;
    @FXML
    private TextField caloriesField;

    @FXML
    private void logActivity() throws IOException {
        try {
            // Retrieve input from the fields
            String type = typeField.getText();
            double duration = Double.parseDouble(durationField.getText());
            double distance = Double.parseDouble(distanceField.getText());
            int calories = Integer.parseInt(caloriesField.getText());

            // Add the activity to the data store
            FitnessTrackerData.addActivity(new Activity(type, duration, distance, calories));

            // Clear fields after logging the activity
            typeField.clear();
            durationField.clear();
            distanceField.clear();
            caloriesField.clear();

            // Return to the main page
            returnToMainPage();
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please check your values.");
        }
    }

    @FXML
    private void returnToMainPage() throws IOException {
        switchScene("/com/example/fitnesstracker/tracker-view.fxml");
    }

    private void switchScene(String fxmlFile) throws IOException {
        // Get the current stage
        Stage currentStage = (Stage) typeField.getScene().getWindow();

        // Load the new scene
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));

        // Keep the same width and height
        Scene currentScene = currentStage.getScene();
        Scene newScene = new Scene(root, currentScene.getWidth(), currentScene.getHeight());

        // Set the new scene
        currentStage.setScene(newScene);
        currentStage.show();
    }
}

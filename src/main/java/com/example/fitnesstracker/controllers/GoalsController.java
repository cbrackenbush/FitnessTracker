package com.example.fitnesstracker.controllers;

import com.example.fitnesstracker.models.Goals;
import com.example.fitnesstracker.data.FitnessTrackerData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class GoalsController {

    @FXML
    private TextField durationGoalField;
    @FXML
    private TextField distanceGoalField;
    @FXML
    private TextField caloriesGoalField;
    @FXML
    private Button returnToMainButton;

    @FXML
    private void saveGoals() {
        try {
            // Retrieve and parse input values
            double durationGoal = Double.parseDouble(durationGoalField.getText());
            double distanceGoal = Double.parseDouble(distanceGoalField.getText());
            int caloriesGoal = Integer.parseInt(caloriesGoalField.getText());

            // Create a new Goals object and store it in FitnessTrackerData
            Goals goals = new Goals(durationGoal, distanceGoal, caloriesGoal);
            FitnessTrackerData.setGoals(goals);

            // Clear fields after saving
            durationGoalField.clear();
            distanceGoalField.clear();
            caloriesGoalField.clear();

            System.out.println("Goals saved successfully!");

            // Return to the main page after saving
            returnToMainPage();
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid numbers.");
        } catch (IOException e) {
            System.out.println("Error navigating back to the main page: " + e.getMessage());
        }
    }

    @FXML
    private void returnToMainPage() throws IOException {
        // Switch back to the main page
        switchScene("/com/example/fitnesstracker/tracker-view.fxml");
    }

    private void switchScene(String fxmlFile) throws IOException {
        // Get the current stage using the returnToMainButton node
        Stage currentStage = (Stage) returnToMainButton.getScene().getWindow();

        // Load the new scene
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));

        // Keep the same width and height
        Scene currentScene = currentStage.getScene();
        Scene newScene = new Scene(root, currentScene.getWidth(), currentScene.getHeight());

        // Set the new scene and show it
        currentStage.setScene(newScene);
        currentStage.show();
    }
}

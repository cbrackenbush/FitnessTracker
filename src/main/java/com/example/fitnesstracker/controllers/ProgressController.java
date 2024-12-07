package com.example.fitnesstracker.controllers;

import com.example.fitnesstracker.data.FitnessTrackerData;
import com.example.fitnesstracker.models.Activity;
import com.example.fitnesstracker.models.Goals;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class ProgressController {

    @FXML
    private Label progressMessageLabel;

    @FXML
    private TableView<Activity> activitiesTableView;

    @FXML
    private TableColumn<Activity, String> activityTypeColumn;

    @FXML
    private TableColumn<Activity, Double> durationColumn;

    @FXML
    private TableColumn<Activity, Double> distanceColumn;

    @FXML
    private TableColumn<Activity, Integer> caloriesColumn;

    @FXML
    private Button returnToMainButton;

    @FXML
    public void initialize() {
        // Set up table columns
        activityTypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));
        distanceColumn.setCellValueFactory(new PropertyValueFactory<>("distance"));
        caloriesColumn.setCellValueFactory(new PropertyValueFactory<>("calories"));

        // Bind column widths to 25% of the table width
        activitiesTableView.widthProperty().addListener((obs, oldWidth, newWidth) -> {
            double tableWidth = newWidth.doubleValue();
            activityTypeColumn.setPrefWidth(tableWidth * 0.25);
            durationColumn.setPrefWidth(tableWidth * 0.25);
            distanceColumn.setPrefWidth(tableWidth * 0.25);
            caloriesColumn.setPrefWidth(tableWidth * 0.25);
        });

        // Hide table by default if no goals
        activitiesTableView.setVisible(false);

        // Get goals and progress data
        Goals currentGoals = FitnessTrackerData.getGoals();

        if (currentGoals == null) {
            progressMessageLabel.setText("No goals set. Please set your goals first.");
        } else {
            // Show progress summary
            double totalDuration = FitnessTrackerData.getTotalDuration();
            double totalDistance = FitnessTrackerData.getTotalDistance();
            int totalCalories = FitnessTrackerData.getTotalCaloriesBurned();

            String progressMessage = String.format(
                    "Progress:\n- Duration: %.1f / %.1f\n- Distance: %.1f / %.1f\n- Calories: %d / %d",
                    totalDuration, currentGoals.getDurationGoal(),
                    totalDistance, currentGoals.getDistanceGoal(),
                    totalCalories, currentGoals.getCaloriesGoal()
            );
            progressMessageLabel.setText(progressMessage);

            // Populate the table with activities
            ObservableList<Activity> activities = FXCollections.observableArrayList(FitnessTrackerData.getActivities());
            activitiesTableView.setItems(activities);
            activitiesTableView.setVisible(true); // Show table if goals are set
        }
    }


    @FXML
    private void returnToMainPage() throws IOException {
        // Logic to switch back to main page
        Stage currentStage = (Stage) returnToMainButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/fitnesstracker/tracker-view.fxml"));
        currentStage.getScene().setRoot(root);
    }
}

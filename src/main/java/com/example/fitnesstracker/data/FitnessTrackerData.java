package com.example.fitnesstracker.data;

import com.example.fitnesstracker.models.Activity;
import com.example.fitnesstracker.models.Goals;

import java.util.ArrayList;
import java.util.List;

public class FitnessTrackerData {
    private static List<Activity> activities = new ArrayList<>();
    private static Goals goals;

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static List<Activity> getActivities() {
        return new ArrayList<>(activities); // Return a copy to avoid direct modification
    }

    public static double getTotalDuration() {
        return activities.stream().mapToDouble(Activity::getDuration).sum();
    }

    public static double getTotalDistance() {
        return activities.stream().mapToDouble(Activity::getDistance).sum();
    }

    public static int getTotalCaloriesBurned() {
        return activities.stream().mapToInt(Activity::getCalories).sum();
    }

    public static void setGoals(Goals goals) {
        FitnessTrackerData.goals = goals;
    }

    public static Goals getGoals() {
        return goals;
    }
}

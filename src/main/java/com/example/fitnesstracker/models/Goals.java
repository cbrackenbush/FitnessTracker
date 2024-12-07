package com.example.fitnesstracker.models;

public class Goals {
    private double durationGoal;
    private double distanceGoal;
    private int caloriesGoal;

    public Goals(double durationGoal, double distanceGoal, int caloriesGoal) {
        this.durationGoal = durationGoal;
        this.distanceGoal = distanceGoal;
        this.caloriesGoal = caloriesGoal;
    }

    public double getDurationGoal() {
        return durationGoal;
    }

    public double getDistanceGoal() {
        return distanceGoal;
    }

    public int getCaloriesGoal() {
        return caloriesGoal;
    }
}

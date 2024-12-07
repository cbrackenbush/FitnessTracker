package com.example.fitnesstracker.models;

public class Activity {
    private String type;
    private double duration; // in hours
    private double distance; // in kilometers
    private int calories;

    public Activity(String type, double duration, double distance, int calories) {
        this.type = type;
        this.duration = duration;
        this.distance = distance;
        this.calories = calories;
    }

    public String getType() {
        return type;
    }

    public double getDuration() {
        return duration;
    }

    public double getDistance() {
        return distance;
    }

    public int getCalories() {
        return calories;
    }
}

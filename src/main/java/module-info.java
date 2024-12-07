module com.example.fitnesstracker {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fitnesstracker to javafx.fxml;
    exports com.example.fitnesstracker;
    exports com.example.fitnesstracker.controllers;
    opens com.example.fitnesstracker.controllers to javafx.fxml;
    exports com.example.fitnesstracker.models;
    opens com.example.fitnesstracker.models to javafx.fxml;
    exports com.example.fitnesstracker.data;
    opens com.example.fitnesstracker.data to javafx.fxml;
}
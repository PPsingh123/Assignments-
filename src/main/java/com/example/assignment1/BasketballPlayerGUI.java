package com.example.assignment1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.sql.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.sql.*;

public class BasketballPlayerGUI {
    private BarChart<String, Number> chart;
    private TableView<BasketballPlayer> tableView;
    private ObservableList<BasketballPlayer> players;

    public BorderPane createMainScene() {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        // Create the chart and set its initial data
        chart = new BarChart<>(new CategoryAxis(), new NumberAxis());
        chart.setTitle("Basketball Player Statistics");
        chart.setLegendVisible(false);
        retrieveDataAndPopulateChart();

        // Create the table view
        tableView = new TableView<>();
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        retrieveDataAndPopulateTableView();

        // Create a button to switch between chart and table view
        Button switchButton = new Button("Switch View");
        switchButton.setOnAction(event -> {
            if (root.getCenter() == chart) {
                root.setCenter(tableView);
                switchButton.setText("Switch to Chart");
            } else {
                root.setCenter(chart);
                switchButton.setText("Switch to Table");
            }
        });

        // Add components to the root pane
        root.setCenter(chart);
        root.setBottom(switchButton);
        BorderPane.setAlignment(switchButton, Pos.CENTER);

        // Apply CSS styling
        root.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        return root;
    }

    private void retrieveDataAndPopulateChart() {
        // Connect to the MySQL database
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password")) {
            // Execute a query to retrieve basketball player statistics from the database
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT name, points FROM basketball_players");

            // Prepare the chart data
            XYChart.Series<String, Number> series = new XYChart.Series<>();
            while (resultSet.next()) {
                String playerName = resultSet.getString("name");
                int points = resultSet.getInt("points");
                series.getData().add(new XYChart.Data<>(playerName, points));
            }

            // Update the chart with the data
            chart.getData().clear();
            chart.getData().add(series);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void retrieveDataAndPopulateTableView() {
        players = FXCollections.observableArrayList();

        // Connect to the MySQL database
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/basketball_stats", "root", "sql@1234567")) {
            // Execute a query to retrieve basketball player data from the database
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM basketball_players");

            // Populate the players list with data from the database
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String playerName = resultSet.getString("name");
                int time = resultSet.getInt("time");
                int age = resultSet.getInt("age");
                String nationality = resultSet.getString("nationality");
                double height = resultSet.getDouble("height");
                double weight = resultSet.getDouble("weight");
                int points = resultSet.getInt("points");
                int assists = resultSet.getInt("assists");
                int rebounds = resultSet.getInt("rebounds");
                players.add(new BasketballPlayer(id, playerName, time, age, nationality, height, weight, points, assists, rebounds));
            }

            // Update the table view with the data
            tableView.setItems(players);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


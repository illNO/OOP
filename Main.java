package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Registration Window");

        // Create the registration form grid pane
        GridPane gridPane = createRegistrationFormPane();

        // Add UI controls to the registration form grid pane
        addUIControls(gridPane);

        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(gridPane, 800, 500);

        // Set the scene in primary stage
        primaryStage.setScene(scene);

        primaryStage.show();
    }


    private GridPane createRegistrationFormPane() {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(10);

        // Set the vertical gap between rows
        gridPane.setVgap(10);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    private void addUIControls(GridPane gridPane) {

        // Add Header
        Label headerLabel = new Label("Registration Form");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        // Add Name Label
        Label nameLabel = new Label("Full Name : ");
        gridPane.add(nameLabel, 0,1);

        // Add Name Text Field
        TextField nameField = new TextField();
        nameField.setPrefHeight(40);
        gridPane.add(nameField, 1,1);


        // Add Email Label
        Label emailLabel = new Label("Surname : ");
        gridPane.add(emailLabel, 0, 2);

        // Add Email Text Field
        TextField emailField = new TextField();
        emailField.setPrefHeight(40);
        gridPane.add(emailField, 1, 2);

        // Add Registration Number Label
        Label RegNumLabel = new Label("Id : ");
        gridPane.add(RegNumLabel, 0, 3);

        // Add Registration Number Text Field
        TextField RegNumField = new TextField();
        RegNumField.setPrefHeight(40);
        gridPane.add(RegNumField, 1, 3);

        // Add Registration Date Label
        Label RegDateLabel = new Label("Reg Date : ");
        gridPane.add(RegDateLabel, 0, 4);

        // Add Registration Date Text Field

        TextField RegDateField = new TextField();
        RegDateField.setPrefHeight(40);
        gridPane.add(RegDateField, 1, 4);

        // Add Gender Label
        Label GendLabel = new Label("Gender : ");
        gridPane.add(GendLabel, 0, 5);

        // Add Gender Text Field
        TextField GendField = new TextField();
        GendField.setPrefHeight(40);
        gridPane.add(GendField, 1, 5);

        // Add Submit Button
        Button submitButton = new Button("Submit");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 6, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));

        //Add Delete File Button
        Button deleteButton = new Button("Delete");
        deleteButton.setPrefHeight(40);
        deleteButton.setDefaultButton(true);
        deleteButton.setPrefWidth(100);
        gridPane.add(deleteButton, 0, 6, 2, 1);
        GridPane.setHalignment(deleteButton, HPos.RIGHT);
        GridPane.setMargin(deleteButton, new Insets(20, 0,20,0));

        //Add Auto Filling Button
        Button autoButton = new Button("AutoFill");
        autoButton.setPrefHeight(40);
        autoButton.setDefaultButton(true);
        autoButton.setPrefWidth(100);
        gridPane.add(autoButton, 0, 6, 2, 1);
        GridPane.setHalignment(autoButton, HPos.LEFT);
        GridPane.setMargin(autoButton, new Insets(20, 0,20,0));

        autoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showAlert(Alert.AlertType.WARNING, gridPane.getScene().getWindow(), "Autofilling", "File Autofilled!");
                File myFile = new File("C:\\Users\\DareBlig\\IdeaProjects\\Labs\\Lab_15\\Information.txt");
                ArrayList writelist;
                writelist = new ArrayList();
                writelist.add("AutoName");
                writelist.add("AutoEmail");
                writelist.add("AutoDate");
                writelist.add("AutoNumber");
                writelist.add("AutoGender");
                try {
                    PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(myFile, true)));
                    writer.println(writelist);
                    writer.flush();
                    writer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                File myFile = new File("C:\\Users\\DareBlig\\IdeaProjects\\Labs\\Lab_15\\Information.txt");
                if(myFile.delete()){
                    showAlert(Alert.AlertType.WARNING, gridPane.getScene().getWindow(), "Removal", "File successfully deleted!");
                }
                else
                    showAlert(Alert.AlertType.WARNING, gridPane.getScene().getWindow(), "Removal error!", "File wasn`t found!");
                return;
            }
        });

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(nameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your name");
                    return;
                }
                if(emailField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your email id");
                    return;
                }
                if(RegDateField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a registration date");
                    return;
                }
                if(RegNumField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a registration number");
                    return;
                }
                if(GendField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your gender");
                    return;
                }
                if(!isWord(nameField.getText())) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Your name should contain only letters");
                    return;
                }
                if(!validDate(RegDateField.getText())) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Format of Registration date is DD.MM.YYYY");
                    return;
                }
                if(!isNumber(RegNumField.getText())) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Registration number should contain only digits");
                    return;
                }
                if(!isWord(GendField.getText())) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your gender (Male/Female)");
                    return;
                }
                showAlert(Alert.AlertType.WARNING, gridPane.getScene().getWindow(), "Registration Successful!", "Success!");

                File myFile = new File("C:\\Users\\Igor\\IdeaProjects\\Lab15OOP\\Prison.txt");
                ArrayList writelist;
                writelist = new ArrayList();
                writelist.add(nameField.getText());
                writelist.add(emailField.getText());
                writelist.add(RegDateField.getText());
                writelist.add(RegNumField.getText());
                writelist.add(GendField.getText());
                try {
                    PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(myFile, true)));
                    writer.println(writelist);
                    writer.flush();
                    writer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static boolean isWord(String in){
        return Pattern.matches("[a-zA-Z]+",in);
    }

    public static boolean isNumber(String in){
        return Pattern.matches("[0-9]+",in);
    }

    public static boolean validDate(String in){
        return Pattern.matches("[0-9.,]+",in);
    }
}

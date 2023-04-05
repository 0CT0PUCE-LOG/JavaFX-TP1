package fr.umontpellier.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Premier exemple manipulant les conteneurs");

        Menu menu1 = new Menu("File");
        MenuItem item1 = new MenuItem("New");
        MenuItem item2 = new MenuItem("Open");
        MenuItem item3 = new MenuItem("Save");
        MenuItem item4 = new MenuItem("Close");
        menu1.getItems().addAll(item1, item2, item3, item4);
        Menu menu2 = new Menu("Edit");
        MenuItem item5 = new MenuItem("Cut");
        MenuItem item6 = new MenuItem("Copy");
        MenuItem item7 = new MenuItem("Paste");
        menu2.getItems().addAll(item5, item6, item7);
        Menu menu3 = new Menu("Help");
        MenuBar menuBar = new MenuBar(menu1, menu2, menu3);
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuBar);

        Label bottom = new Label("Ceci est un label de bas de page");
        bottom.setAlignment(javafx.geometry.Pos.CENTER);
        Separator separator1 = new Separator(Orientation.HORIZONTAL);
        VBox vBox1 = new VBox(separator1, bottom);
        vBox1.setAlignment(javafx.geometry.Pos.CENTER);
        borderPane.setBottom(vBox1);

        Label boutons = new Label("Boutons :");
        Button b1 = new Button("Bouton 1");
        Button b2 = new Button("Bouton 2");
        Button b3 = new Button("Bouton 3");
        VBox vBox = new VBox(boutons, b1, b2, b3);
        vBox.setAlignment(javafx.geometry.Pos.CENTER);
        Separator separator = new Separator(Orientation.VERTICAL);
        vBox.setSpacing(10);
        HBox hBox = new HBox(vBox, separator);

        borderPane.setLeft(hBox);


        GridPane gridPane = new GridPane();

        Label name = new Label("Name :");
        Label email = new Label("Email :");
        Label password = new Label("Password :");
        TextField nameField = new TextField();
        TextField emailField = new TextField();
        TextField passwordField = new TextField();
        gridPane.add(name, 0, 0);
        gridPane.add(email, 0, 1);
        gridPane.add(password, 0, 2);
        gridPane.add(nameField, 1, 0);
        gridPane.add(emailField, 1, 1);
        gridPane.add(passwordField, 1, 2);
        Button submit = new Button("Submit");
        Button cancel = new Button("Cancel");
        HBox hBox1 = new HBox(submit, cancel);
        hBox1.setSpacing(10);
        hBox1.setAlignment(javafx.geometry.Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(javafx.geometry.Pos.CENTER);

        VBox MIDDLE = new VBox(gridPane,hBox1);
        MIDDLE.setSpacing(10);
        MIDDLE.setAlignment(javafx.geometry.Pos.CENTER);
        borderPane.setCenter(MIDDLE);

        primaryStage.setScene(new javafx.scene.Scene(borderPane, 300, 250));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}


package fr.umontpellier.iut.exercice6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class IHMPendu extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //setup mot à trouver
        Dico dico = new Dico();
        String mot = dico.getMot();
        System.out.println(mot);

        //setup scene
        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);

        Label label_nbvie = new Label("Nombre de vie : ");

        Label lebel_mot = new Label("");

        TextField textField = new TextField();
        textField.setPrefWidth(100);
        textField.setPrefHeight(10);
        //textField.setLayoutX(50);
        //textField.setLayoutY(50);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(label_nbvie, textField);

        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

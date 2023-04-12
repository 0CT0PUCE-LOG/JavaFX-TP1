package fr.umontpellier.iut.exercice6;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

        //setup nombre de vies
        int nbVie = 10;

        //setup scene
        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);

        Label label_nbvie = new Label("Nombre de vie : "+ nbVie);

        Label label_mot = new Label(cacherMot(mot));

        TextField textField = new TextField();
        textField.setPrefWidth(100);
        textField.setPrefHeight(10);
        //textField.setLayoutX(50);
        //textField.setLayoutY(50);

        //submit buuton
        Button bouton = new Button();
        final EventHandler event = new EventHandler() {
            @Override
            public void handle(Event event) {
                bonjour.setText("Bonjour à toi "+saisir_nom.getText()+" !");
            }
        };
        bouton.setOnAction(event);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(label_nbvie,label_mot, textField);
        vBox.setAlignment(javafx.geometry.Pos.CENTER);
        vBox.setSpacing(15);



        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public String cacherMot(String mot) {
        String motCache = "";
        for (int i = 0; i < mot.length(); i++) {
            motCache += "*";
        }
        return motCache;
    }
}

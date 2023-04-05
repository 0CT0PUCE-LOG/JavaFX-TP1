package fr.umontpellier.iut.exercice3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class MaPremiereFenetreJavaFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello Application");
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);


        VBox vBox = new VBox();
        vBox.setAlignment(javafx.geometry.Pos.CENTER);
        Label bonjour = new Label("Bonjour à tous !");
        bonjour.setFont(Font.font("Courrier", FontWeight.BOLD, 30));

        TextField saisir_nom = new TextField();
        saisir_nom.setMaxWidth(150);
        saisir_nom.setFont(Font.font("Courrier", FontWeight.NORMAL, 15));

        Button bouton = new Button();
        ImageView imageButton= new ImageView("exercice3/Bonjour.jpg");
        bouton.setGraphic(imageButton);
        final EventHandler event = new EventHandler() {
            @Override
            public void handle(Event event) {
                bonjour.setText("Bonjour à toi "+saisir_nom.getText()+" !");
            }
        };
        bouton.setOnAction(event);
        saisir_nom.setOnAction(event);


        vBox.getChildren().addAll(bonjour, saisir_nom, bouton);


        Pane pane = new Pane();
        pane.getChildren().add(vBox);

        Scene scene = new Scene(pane);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("exercice3/Bonjour.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

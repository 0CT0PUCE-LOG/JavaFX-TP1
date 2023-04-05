package fr.umontpellier.iut.exercice4;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Label label;
    private Pane panneau;
    private HBox bas;

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox hBox = new HBox();
        Button vert = new Button("Vert");
        Button rouge = new Button("Rouge");
        Button bleu = new Button("Bleu");
        hBox.getChildren().addAll(vert, rouge, bleu);
        hBox.setAlignment(javafx.geometry.Pos.CENTER);

        BorderPane rectangle = new BorderPane();
        rectangle.setPrefSize(400, 200);
        Label topLabel = new Label();
        HBox topHBox = new HBox();
        topHBox.getChildren().add(topLabel);
        topHBox.setAlignment(javafx.geometry.Pos.CENTER);
        Pane panneau = new Pane();
        rectangle.setCenter(panneau);
        rectangle.setTop(topHBox);
        rectangle.setBottom(hBox);

        vert.setOnAction(event -> {
            panneau.setStyle("-fx-background-color: green");
            topLabel.setText("Vert choisi " + ++nbVert + " fois");
        });

        rouge.setOnAction(event -> {
            panneau.setStyle("-fx-background-color: red");
            topLabel.setText("Rouge choisi " + ++nbRouge + " fois");
        });

        bleu.setOnAction(event -> {
            panneau.setStyle("-fx-background-color: blue");
            topLabel.setText("Bleu choisi " + ++nbBleu + " fois");
        });

        primaryStage.setScene(new javafx.scene.Scene(rectangle));
        primaryStage.show();
    }
}


package fr.umontpellier.iut.exercice3;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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
        Label bjr = new Label("Bonjour à tous !");
        TextField saisir_nom = new TextField();
        saisir_nom.setMaxWidth(150);
        Button btn = new Button("Dire bonjour");
        vBox.getChildren().addAll(bjr, saisir_nom, btn);

        Pane pane = new Pane();
        pane.getChildren().add(vBox);


        primaryStage.setScene(new javafx.scene.Scene(pane));
        primaryStage.show();
    }
}

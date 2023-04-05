package fr.umontpellier.iut.exercice3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
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
        Label bonjour = new Label("Bonjour à tous !");
        TextField saisir_nom = new TextField();
        saisir_nom.setMaxWidth(150);
        Button bouton = new Button();
        ImageView imageButton= new ImageView("https://gitlabinfo.iutmontp.univ-montp2.fr/ihm/tp1/-/raw/master/images/logo.jpeg");
        bouton.setGraphic(imageButton);
        final EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                if(saisir_nom.getText().equals("César")){
                    bonjour.setText("Bonjour à toi César");
                }
            }
        };
        //bouton.addEventHandler(MouseEvent.MOUSE_CLICKED, event);
        bouton.setOnAction(event);
        vBox.getChildren().addAll(bonjour, saisir_nom, bouton);
        saisir_nom.setOnKeyPressed( ActionEvent -> {
            if( ActionEvent.getCode() == KeyCode.ENTER ) {
                //call event action
            }
        } );


        Pane pane = new Pane();
        pane.getChildren().add(vBox);


        primaryStage.setScene(new javafx.scene.Scene(pane));
        primaryStage.show();
    }
}

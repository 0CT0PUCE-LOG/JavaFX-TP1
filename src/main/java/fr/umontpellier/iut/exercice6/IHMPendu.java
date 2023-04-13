package fr.umontpellier.iut.exercice6;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class IHMPendu extends Application {

    private String motCache;

    private String mot;

    private boolean correct;

    private int nbVie;

    private int old_vie;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //setup mot à trouver
        Dico dico = new Dico();
        mot = dico.getMot();
        System.out.println(mot);

        //setup nombre de vies
        nbVie = 7;

        //setup scene
        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);

        Label label_nbvie = new Label("Nombre de vie : "+ nbVie);

        //cacher le mot à trouver
        cacherMot(mot);
        Label label_mot = new Label(motCache);

        //label pendu
        Label pendu = new Label();
        pendu.setGraphic(new ImageView("exercice6/pendu7.png"));

        //label lettre déjà testée
        Label label_lettre = new Label();

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
                char lettre = textField.getText().charAt(0);
                correct=ajouterLettreAMot(mot,lettre);
                old_vie= nbVie;
                if(correct){
                    System.out.println("good");
                    label_mot.setText(motCache);
                }
                else{
                    System.out.println("bad");
                    nbVie--;
                    label_lettre.setText(label_lettre.getText()+lettre+", ");

                }
                actualiserPendu(nbVie, pendu, label_nbvie);
                textField.clear();

            }
        };
        bouton.setOnAction(event);
        textField.setOnAction(event);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(pendu,label_nbvie, label_mot, textField, label_lettre);
        vBox.setAlignment(javafx.geometry.Pos.CENTER);
        vBox.setSpacing(15);



        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void cacherMot(String mot) {
        motCache="";
        for (int i = 0; i < mot.length(); i++) {
            motCache += "*";
        }
    }

    public boolean contenirLettre(String mot, char lettre){
        for(int i = 0; i<mot.length();i++){
            if(mot.charAt(i)==lettre){
                return true;
            }
        }
        return false;
    }

    public boolean ajouterLettreAMot(String mot, char lettre){
        char hidden = '*';
        String copy = motCache;
        System.out.println("copy : "+copy+" mot : "+mot+" lettre : "+lettre+" motCache : "+motCache);
        if(contenirLettre(mot,lettre)){
            motCache="";
            for(int i = 0; i<mot.length();i++){
                if(copy.charAt(i)==hidden && mot.charAt(i)==lettre){
                    motCache+=lettre;
                }
                else if(!(copy.charAt(i) == hidden)){
                    motCache+=copy.charAt(i);
                }
                else{
                    motCache+="*";
                }
            }
            return true;
        }
        return false;
    }

    public void actualiserPendu(int nb_vie, Label pendu,Label label_nbvie){
        System.out.println("motCache : "+motCache+" mot : "+mot+" equals:"+motCache.equals(mot));
        if(motCache.equals(mot)){
            System.out.println("gagné");
            pendu.setGraphic(new ImageView("exercice6/penduWin.png"));
        }
        else if(nb_vie==0){
            System.out.println("perdu");
            pendu.setGraphic(new ImageView("exercice6/pendu0.png"));
        }else if(nb_vie!=old_vie){
            label_nbvie.setText("Nombre de vie : "+ nb_vie);
            String idImage = "exercice6/pendu";
            //int nbImage = 7-nb_vie;
            idImage += Integer.toString(nb_vie);
            idImage += ".png";
            pendu.setGraphic(new ImageView(idImage));
        }

    }
}

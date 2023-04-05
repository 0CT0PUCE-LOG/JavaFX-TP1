package fr.umontpellier.iut.exercice2;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Random;

public class TicTacToe extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UTILITY);


        //label
        ImageView croix = new ImageView("exercice2/Croix.png");
        ImageView rond = new ImageView("exercice2/Rond.png");

        Random random = new Random();
        int nombre = 0;

        GridPane gridPane = new GridPane();

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                nombre = random.nextInt(3);
                if(nombre == 0){
                    gridPane.add(new Label("Croix", croix), i, j);
                    System.out.println("croix at poition " + i + " " + j + "");
                }else if(nombre == 1){
                    gridPane.add(new Label("Rond", rond), i, j);
                    System.out.println("rond at poition " + i + " " + j + "");
                }else{
                    gridPane.add(new Label(), i, j);
                    System.out.println("vide at poition " + i + " " + j + "");
                }
            }
        }



        primaryStage.setScene(new javafx.scene.Scene(gridPane, 300, 300));
        System.out.println("primaryStage.show();");


        primaryStage.show();
    }
}


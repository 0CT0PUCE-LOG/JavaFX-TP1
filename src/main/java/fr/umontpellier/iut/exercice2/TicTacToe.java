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
        Label label_croix = new Label("Croix", croix);
        ImageView rond = new ImageView("exercice2/Rond.png");
        Label label_rond = new Label("Rond", rond);

        Random random = new Random();
        int nombre = 0;

        GridPane gridPane = new GridPane();

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                nombre = random.nextInt(3);
                if(nombre == 0){
                    gridPane.add(label_croix, i, j);
                }else if(nombre == 1){
                    gridPane.add(label_rond, i, j);
                }else{
                    gridPane.add(new Label(), i, j);
                }
            }
        }

        primaryStage.setScene(new javafx.scene.Scene(gridPane, 300, 300));
        primaryStage.show();
    }
}


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
        //primaryStage.initStyle(StageStyle.UTILITY);


        Random random = new Random();
        int nombre = 0;

        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);

        for(int i =0;i<3;i++){
            for(int j=0;j<3;j++){
                nombre = random.nextInt(3);
                System.out.println(nombre);
                Label label = new Label();
                if(nombre == 1){
                    System.out.println("croix");
                    label.setGraphic(new ImageView("exercice2/Croix.png"));
                    gridPane.add(label,i,j);
                }else if(nombre == 2){
                    System.out.println("rond");
                    label.setGraphic(new ImageView("exercice2/Rond.png"));
                    gridPane.add(label,i,j);
                }
                else{
                    label.setGraphic(new ImageView("exercice2/Vide.png"));
                    gridPane.add(label,i,j);
                }
            }
        }





        primaryStage.setScene(new javafx.scene.Scene(gridPane));
        System.out.println("primaryStage.show();");


        primaryStage.show();
    }
}


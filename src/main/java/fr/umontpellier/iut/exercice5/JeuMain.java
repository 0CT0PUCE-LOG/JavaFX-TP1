package fr.umontpellier.iut.exercice5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class JeuMain extends Application {

    private Scene scene;
    private BorderPane root;

    @Override
    public void start(Stage primaryStage) {

        root = new BorderPane();

        //Acteurs du jeu
        Personnage pacman = new Pacman();
        Personnage fantome = new Fantome();
        // on positionne le fantôme 20 positions vers la droite
        fantome.setLayoutX(20 * 10);

        //obstacle
        Obstacle obstacle = new Obstacle(170, 170, 150, 150);

        //panneau du jeu
        Pane jeu = new Pane();
        jeu.setPrefSize(640, 480);
        jeu.getChildren().add(pacman);
        jeu.getChildren().add(fantome);
        jeu.getChildren().add(obstacle);
        root.setCenter(jeu);
        //on construit une scene 640 * 480 pixels
        scene = new Scene(root);

        //Gestion du déplacement du personnage
        deplacer(pacman, fantome, obstacle);



        primaryStage.setTitle("... Pac Man ...");

        primaryStage.setScene(scene);
        primaryStage.show();
        /*
        while(true){
            //deplacerFantome(fantome, pacman, obstacle);
        }

         */


    }

    /**
     * Permet de gérer les événements de type clavier, pression des touches
     * pour le j1(up,down, right, left), pour le j2( z,q,s,d)
     *
     * @param j1
     * @param j2
     */
    private void deplacer(Personnage j1, Personnage j2, Obstacle obstacle) {
        AtomicReference<Double> hx1 = new AtomicReference<>(j1.getLayoutX());
        AtomicReference<Double> hy1 = new AtomicReference<>(j1.getLayoutY());
        AtomicReference<Double> hx2 = new AtomicReference<>(j2.getLayoutX());
        AtomicReference<Double> hy2 = new AtomicReference<>(j2.getLayoutY());
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()) {
                //j1
                case LEFT:
                    //sauvegarde des coordonnées du personnage
                    hx1.set(j1.getLayoutX());
                    hy1.set(j1.getLayoutY());
                    //move initial
                    j1.deplacerAGauche();
                    if(j1.estEnCollision(obstacle,j1)){
                        System.out.println("collision a gauche");
                        j1.deplacerAPosition(hx1.get(),hy1.get());
                    }
                    break;

                case RIGHT:
                    hx1.set(j1.getLayoutX());
                    hy1.set(j1.getLayoutY());
                    j1.deplacerADroite(scene.getWidth());
                    if(j1.estEnCollision(obstacle,j1)){
                        System.out.println("collision a droite");
                        j1.deplacerAPosition(hx1.get(),hy1.get());
                    }
                    break;
                case UP:
                    hx1.set(j1.getLayoutX());
                    hy1.set(j1.getLayoutY());
                    j1.deplacerEnHaut();
                    if(j1.estEnCollision(obstacle,j1)){
                        System.out.println("collision en haut");
                        j1.deplacerAPosition(hx1.get(),hy1.get());
                    }
                    break;
                case DOWN:
                    hx1.set(j1.getLayoutX());
                    hy1.set(j1.getLayoutY());
                    j1.deplacerEnBas(scene.getWidth());
                    if(j1.estEnCollision(obstacle,j1)){
                        System.out.println("collision en bas");
                        j1.deplacerAPosition(hx1.get(),hy1.get());
                    }
                    break;
                //j2
                //mode manuel
                /*
                case Z:
                    hx2.set(j2.getLayoutX());
                    hy2.set(j2.getLayoutY());
                    j2.deplacerEnHaut();
                    if (j2.estEnCollision(obstacle,j2)){
                        System.out.println("collision en haut");
                        j2.deplacerAPosition(hx2.get(),hy2.get());
                    }
                    break;
                case Q:
                    hx2.set(j2.getLayoutX());
                    hy2.set(j2.getLayoutY());
                    j2.deplacerAGauche();
                    if (j2.estEnCollision(obstacle,j2)){
                        System.out.println("collision a gauche");
                        j2.deplacerAPosition(hx2.get(),hy2.get());
                    }
                    break;
                case S:
                    hx2.set(j2.getLayoutX());
                    hy2.set(j2.getLayoutY());
                    j2.deplacerEnBas(scene.getWidth());
                    if (j2.estEnCollision(obstacle,j2)){
                        System.out.println("collision en bas");
                        j2.deplacerAPosition(hx2.get(),hy2.get());
                    }
                    break;

                case D:
                    hx2.set(j2.getLayoutX());
                    hy2.set(j2.getLayoutY());
                    j2.deplacerADroite(scene.getWidth());
                    if (j2.estEnCollision(obstacle,j2)){
                        System.out.println("collision a droite");
                        j2.deplacerAPosition(hx2.get(),hy2.get());
                    }
                    break;

                 */

                //mode automatique
                default:
                    deplacerFantome(j1, j2, obstacle);
                    break;


            }
            if (j1.estEnCollision(j2)){
                System.out.println("Collision....");
                //stop le jeu
                scene.setOnKeyPressed(null);
            }
        });
        for(int i = 0; i < 10000; i++){
            System.out.println("move i : " + i);
            //deplacerFantome(j1, j2, obstacle);
        }
    }

    public void deplacerFantome(Personnage j1, Personnage j2, Obstacle obstacle){
        Double hx2 = j2.getLayoutX();
        Double hy2 = j2.getLayoutY();
        /*
        try {
            Thread.sleep(1000); // wait for 1 second
        } catch (InterruptedException e) {
            // handle the exception if necessary
        }

         */
        System.out.println("move");
        double px1 = j1.getLayoutX();
        double py1 = j1.getLayoutY();
        hx2 = j2.getLayoutX();
        hy2 =j2.getLayoutY();
        if (j2.getLayoutX() > px1) {
            j2.deplacerAGauche();
            if (j2.estEnCollision(obstacle, j2)) {
                System.out.println("collision a gauche");
                j2.deplacerAPosition(hx2, hy2);
            }
        } else if (j2.getLayoutX() < px1) {
            j2.deplacerADroite(scene.getWidth());
            if (j2.estEnCollision(obstacle, j2)) {
                System.out.println("collision a droite");
                j2.deplacerAPosition(hx2, hy2);
            }
        } else if (j2.getLayoutY() > py1) {
            j2.deplacerEnHaut();
            if (j2.estEnCollision(obstacle, j2)) {
                System.out.println("collision en haut");
                j2.deplacerAPosition(hx2, hy2);
            }
        } else if (j2.getLayoutY() < py1) {
            j2.deplacerEnBas(scene.getWidth());
            if (j2.estEnCollision(obstacle, j2)) {
                System.out.println("collision en bas");
                j2.deplacerAPosition(hx2, hy2);
            }
        }
    }


}

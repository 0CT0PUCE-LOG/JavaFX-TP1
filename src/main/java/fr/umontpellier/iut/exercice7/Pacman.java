package fr.umontpellier.iut.exercice7;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Pacman extends Personnage {

    private Circle corps;
    private Line bouche;


    public Pacman() {
        super();
        corps = new Circle(10, 10, LARGEURMOITIEPERSONNAGE, Color.BLACK);
        corps.setFill(Paint.valueOf("yellow"));
        bouche = new Line(LARGEURMOITIEPERSONNAGE, LARGEURMOITIEPERSONNAGE, LARGEURMOITIEPERSONNAGE * 2, LARGEURMOITIEPERSONNAGE);
        bouche.setFill(Paint.valueOf("black"));
        direction = "droite";

        this.getChildren().add(corps);
        this.getChildren().add(bouche);
    }

    @Override
    public void directionGauche() {
        super.directionGauche();
        //sens de la bouche
        bouche.setEndX(bouche.getStartX() - LARGEURMOITIEPERSONNAGE);
        bouche.setEndY(bouche.getStartY());
    }

    @Override
    public void directionDroite(double largeurJeu) {
        super.directionDroite(largeurJeu);
        //sens de la bouche
        bouche.setEndX(bouche.getStartX() + LARGEURMOITIEPERSONNAGE);
        bouche.setEndY(bouche.getStartY());
    }

    @Override
    void directionBas(double hauteurJeu) {

    }

    @Override
    void directionHaut() {

    }

}

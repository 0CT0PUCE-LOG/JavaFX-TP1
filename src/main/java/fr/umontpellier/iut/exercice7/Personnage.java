package fr.umontpellier.iut.exercice7;

import javafx.scene.Group;

class Personnage extends Group {
    protected final static double LARGEUR_MOITIE_PERSONNAGE = 10;
    protected final static double LARGEUR_PERSONNAGE = LARGEUR_MOITIE_PERSONNAGE * 2;
    protected String direction;

    void directionGauche() {
        //    ****
        //   *    *
        //  *---   *
        //   *    *
        //    ****

        //déplacement <----
        if (this.getLayoutX() >= LARGEUR_PERSONNAGE) {
            this.setLayoutX(this.getLayoutX() - LARGEUR_PERSONNAGE);
        }
        if (direction != "gauche") {
            direction = "gauche";
        }
    }

    void directionDroite(double largeurJeu) {
        //    ****
        //   *    *
        //  *   ---*
        //   *    *
        //    ****
        //déplacement ---->
        if (this.getLayoutX() < largeurJeu - LARGEUR_PERSONNAGE) {
            this.setLayoutX(this.getLayoutX() + LARGEUR_PERSONNAGE);
        }
        if (direction != "droite") {
            direction = "droite";
        }
    }

    void directionBas(double hauteurJeu) {
        //    *****
        //   *     *
        //  *   |   *
        //   *  |  *
        //    *****

    }

    void directionHaut() {
        //    *****
        //   *  |  *
        //  *   |   *
        //   *     *
        //    *****

    }

    boolean collision(Personnage autrePersonnage) {
        return this.getBoundsInParent().contains(autrePersonnage.getBoundsInParent())
                || autrePersonnage.getBoundsInParent().contains(this.getBoundsInParent());
    }

}

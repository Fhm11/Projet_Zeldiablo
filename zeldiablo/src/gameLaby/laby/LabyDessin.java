package gameLaby.laby;

import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;
import javafx.scene.image.Image;

import java.util.List;
import java.util.Objects;

public class LabyDessin implements DessinJeu {
    private Image amuletteImage;
    private Image monstreImage;
    private Image persoImage;
    private Image murImage;
    private Image solImage;



    public LabyDessin() {
        try {
            // Chemin vers ton image dans ressources, adapte ce chemin à ton projet
            amuletteImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/amulette.png")));
            monstreImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/monstre.png")));
            persoImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/perso.png")));
            murImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/t.jpg")));
            solImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/img/lave.jpg")));
            if (amuletteImage.isError() || monstreImage.isError()) {
                System.err.println("Erreur lors du chargement de l'image");
            }
        } catch (Exception e) {
            System.err.println("Exception lors du chargement de l'image : " + e.getMessage());
            amuletteImage = null;
        }
    }

    private void dessinerEffetAttaque(GraphicsContext gc, double x, double y, double taille) {
        gc.setFill(Color.rgb(255, 0, 0, 0.5)); // rouge semi-transparent
        gc.fillOval(x, y, taille, taille);
    }


    private void dessinerBarreVie(GraphicsContext gc, int x, int y, int dimension, int vieActuelle, int vieMax,
            Color couleurFond, Color couleurVie) {
        int largeurBarre = dimension;
        int hauteurBarre = 5;
        int posX = x * dimension;
        int posY = y * dimension - hauteurBarre - 2;

        double pourcentageVie = Math.max(0, (double) vieActuelle / vieMax);

        gc.setFill(couleurFond);
        gc.fillRect(posX, posY, largeurBarre, hauteurBarre);

        gc.setFill(couleurVie);
        gc.fillRect(posX, posY, largeurBarre * pourcentageVie, hauteurBarre);
    }

    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {
        LabyJeu lj = (LabyJeu) jeu;
        Labyrinthe laby = lj.getLaby();
        final GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        int nbColonnes = laby.getLength(); // axe X
        int nbLignes = laby.getLengthY(); // axe Y
        int dimension = (int) (canvas.getWidth() / nbColonnes);

        if (lj.getStage() == null) {
            Stage stage = (Stage) canvas.getScene().getWindow();
            lj.setStage(stage);
        }



        for (int x = 0; x < nbColonnes; x++) {
            for (int y = 0; y < nbLignes; y++) {
                if (murImage == null || solImage == null) {
                    if (laby.getMur(x, y)) {
                        gc.setFill(Color.BLACK);
                    } else {
                        gc.setFill(Color.WHITE);
                    }
                    gc.fillRect(x * dimension, y * dimension, dimension, dimension);
                } else {
                    if (laby.getMur(x, y)) {
                        gc.drawImage(murImage, x * dimension, y * dimension, dimension, dimension);
                    } else {
                        gc.drawImage(solImage, x * dimension, y * dimension, dimension, dimension);
                    }
                }
            }
        }


        // Dessiner un cercle pour représenter l'entrée
        gc.setFill(Color.BLACK);
        gc.fillOval(laby.getxDepart() * dimension, laby.getyDepart() * dimension, dimension, dimension);

        // Dessiner le personnage
        Perso p = lj.getPerso();
        if (p != null) {
            gc.drawImage(persoImage, p.getX() * dimension, p.getY() * dimension, dimension, dimension);
            dessinerBarreVie(gc, p.getX(), p.getY(), dimension, p.getV(), 5, Color.GRAY, Color.GREEN);
        }

        // effet degat perso
        if (p.getV() > 0 && p.afficherEffetDegat()) {
            dessinerEffetAttaque(gc, p.getX() * dimension, p.getY() * dimension, dimension);
        }



        if (p.possedeAmulette()) {
            double xImg = p.getX() * dimension;
            double yImg = p.getY() * dimension - (dimension * 0.5); // au dessus du perso
            gc.drawImage(amuletteImage, xImg, yImg, dimension * 0.5, dimension * 0.5);
        }

        // Dessiner le monstre
        List<Monstre> monstres = lj.getMonstres();
        if (monstres != null) {
            for (Monstre m : monstres) {
                if (monstreImage != null) {
                    gc.drawImage(monstreImage, m.getX() * dimension, m.getY() * dimension, dimension, dimension);
                } else {
                    gc.setFill(Color.PURPLE); // au cas où l'image est introuvable
                    gc.fillOval(m.getX() * dimension, m.getY() * dimension, dimension, dimension);
                }
                dessinerBarreVie(gc, m.getX(), m.getY(), dimension, m.getV(), 2, Color.GRAY, Color.ORANGERED);
                // effet degat monstre
                if (m.afficherEffetDegat()) {
                    dessinerEffetAttaque(gc, m.getX() * dimension, m.getY() * dimension, dimension);

                }
            }
        }

        // Dessiner l'amulette
        Amulette am = lj.getLaby().getAmulette();
        if (am != null) {
            double xImg = am.getX() * dimension + dimension * 0.25;
            double yImg = am.getY() * dimension + dimension * 0.25;
            gc.drawImage(amuletteImage, xImg, yImg, dimension * 0.5, dimension * 0.5);
        }


    }
}

package gameLaby.laby;

import java.io.IOException;
import moteurJeu.MoteurJeu;

/**
 * Classe principale pour lancer le jeu du labyrinthe.
 */
public class MainLaby {
    /**
     * Point d'entrée du programme. Initialise et lance le jeu.
     * 
     * @param args arguments de la ligne de commande (non utilisés)
     */
    public static void main(String[] args) throws IOException {
        int width = 600;
        int height = 800;
        int pFPS = 7;

        // creation des objets
        LabyJeu jeu_laby = new LabyJeu();
        LabyDessin laby_dessin = new LabyDessin();

        // parametrage du moteur de jeu
        MoteurJeu.setTaille(height, width);
        MoteurJeu.setFPS(pFPS);

        // lancement du jeu
        MoteurJeu.launch(jeu_laby, laby_dessin);
    }
}
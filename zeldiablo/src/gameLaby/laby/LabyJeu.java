package gameLaby.laby;

import moteurJeu.Clavier;
import moteurJeu.Jeu;

import java.io.IOException;
import java.util.*;

public class LabyJeu implements Jeu {
    private Labyrinthe laby;
    private Perso perso;
    private List<Monstre> monstres;

    public LabyJeu() {
        try {
            this.laby = new Labyrinthe("zeldiablo/labySimple/laby1.txt");
            this.perso = this.laby.getPerso();
            this.monstres = this.laby.getMonstres();
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement du labyrinthe : " + e.getMessage());
        }
    }

    /**
     * methode mise a jour du jeu
     * @param secondes temps ecoule depuis la derniere mise a jour
     * @param clavier objet contenant l'état du clavier'
     */
    public void update(double secondes, Clavier clavier) {
        if (clavier.haut && !perso.estmort()) {
            laby.deplacerPerso(Labyrinthe.HAUT);
        } else if (clavier.bas && !perso.estmort()) {
            laby.deplacerPerso(Labyrinthe.BAS);
        } else if (clavier.gauche && !perso.estmort()) {
            laby.deplacerPerso(Labyrinthe.GAUCHE);
        } else if  (clavier.droite && !perso.estmort()) {
            laby.deplacerPerso(Labyrinthe.DROITE);
        }
        for (Monstre m : monstres) {
            if (!m.estmort()) {
                m.deplacerMonstre(laby, perso, secondes);
            }
        }
        if (clavier.espace && !perso.estmort()) {
            perso.attaquer(monstres);
        }
        laby.nettoyerMonstresMorts();
      
    }

    /**
     * initialisation du jeu
     */
    public void init() {
        //rien nécessaire
    }

    /**
     * verifie si le jeu est fini
     * @return booleen true si le jeu est fini
     */
    public boolean etreFini() {
        return laby.etreFini();
    }

    public Labyrinthe getLaby() {
        return this.laby;
    }

    public Perso getPerso(){return this.perso;}

    public List<Monstre> getMonstres() {
        return this.monstres;
    }
}

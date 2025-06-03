package gameLaby.laby;

import java.util.List;

/**
 * gere un personnage situe en x,y
 */
public class Perso {

    /**
     * position du personnage
     */
    int x, y, v;

    /**
     * constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Perso(int dx, int dy) {
        this.x = dx;
        this.y = dy;
        this.v = 5;
    }

    /**
     * permet de savoir si le personnage est en x,y
     *
     * @param dx position testee
     * @param dy position testee
     * @return true si le personnage est bien en (dx,dy)
     */
    public boolean etrePresent(int dx, int dy) {

        return (this.x == dx && this.y == dy);
    }

    /**
     * Le personnage attaque les monstres autour de lui (haut, bas, gauche, droite).
     *
     * @param monstres liste des monstres présents dans le labyrinthe
     */
    public void attaquer(List<Monstre> monstres) {
        for (Monstre m : monstres) {
            if (m.estmort())
                continue;
            int mx = m.getX();
            int my = m.getY();
            boolean estAdjacent = (mx == this.x + 1 && my == this.y) || // droite
                    (mx == this.x - 1 && my == this.y) || // gauche
                    (mx == this.x && my == this.y + 1) || // bas
                    (mx == this.x && my == this.y - 1); // haut

            if (estAdjacent) {
                m.prendreDegat(1);
            }
        }
    }

    public boolean estmort() {
        return this.v <= 0;
    }

    // ############################################
    // GETTER
    // ############################################

    /**
     * @return position x du personnage
     */
    public int getX() {
        // getter
        return this.x;
    }

    /**
     * @return position y du personnage
     */
    public int getY() {
        // getter
        return this.y;
    }

    /**
     * Modifie la position y du personnage.
     * @param y nouvelle position y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Modifie la position x du personnage.
     * @param x nouvelle position x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Retourne la vie actuelle du personnage.
     * @return la vie du personnage
     */
    public int getV() {
        return v;
    }
}

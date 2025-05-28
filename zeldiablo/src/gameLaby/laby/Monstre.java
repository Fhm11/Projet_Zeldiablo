package gameLaby.laby;

public class Monstre {

    private int x;
    private int y;

    /**
     * Constructeur du monstre.
     * @param x position en x
     * @param y position en y
     */
    public Monstre(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return la position x du monstre
     */
    public int getX() {
        return this.x;
    }

    /**
     * @return la position y du monstre
     */
    public int getY() {
        return this.y;
    }

    /**
     * Vérifie si le monstre est à la même position qu'une position donnée
     * @param px position x testée
     * @param py position y testée
     * @return vrai si même position
     */
    public boolean estSurPosition(int px, int py) {
        return this.x == px && this.y == py;
    }
}

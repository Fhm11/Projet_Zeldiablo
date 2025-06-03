package gameLaby.laby;

/**
 * Classe qui représente l'amulette placée
 * dans le labyrinthe
 */
public class Amulette {
    private int x, y;

    /**
     * Constructeur de l'amulette
     * @param x sa position en x
     * @param y sa position en y
     */
    public Amulette(int x, int y){
        this.x=x;
        this.y=y;
    }

    /**
     * Getter pour l'attribut x
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * Getter pour l'attribut y
     * @return y
     */
    public int getY() {
        return y;
    }


}

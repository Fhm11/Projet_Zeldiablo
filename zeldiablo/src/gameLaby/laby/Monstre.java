package gameLaby.laby;

public class Monstre {
    private int x;
    private int y;
    private int v;
    private double t = 0;

    /**
     * Constructeur du monstre.
     * @param x position en x
     * @param y position en y
     */
    public Monstre(int x, int y) {
        this.x = x;
        this.y = y;
        this.v = 100;
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


    public boolean estmort(){
        return this.v<=0;
    }

    public void deplacerMonstre(Labyrinthe laby, Perso perso, double secondes) {
        if(estmort()){
            System.out.println("Monstre est mort");
            return;
        }

        t += secondes;

        if (t < 0.5) {
            return; // pas encore le temps de bouger
        }

        t=0;
        int[][] directions = {
                {0, -1},  // h
                {0, 1},   // b
                {-1, 0},  // g
                {1, 0}    // d
        };

        int choix = (int) (Math.random() * directions.length);
        int[] dir = directions[choix];

        int newX = x + dir[0];
        int newY = y + dir[1];

        if (newX < 0 || newY < 0 || newX >= laby.getLength() || newY >= laby.getLengthY()) {
            return;
        }

        if (laby.getMur(newX, newY)) {
            return;
        }

        if (newX == perso.getX() && newY == perso.getY()) {
            return;
        }
        if (laby.estCaseOccupeeParMonstre(newX, newY)) return;

        this.x = newX;
        this.y = newY;
    }

    public void prendreDegat(int degats) {
        this.v -= degats;
    }

    public int getV() {
        return v;
    }
}

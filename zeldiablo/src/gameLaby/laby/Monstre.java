package gameLaby.laby;

/**
 * Classe représentant un monstre
 */
public class Monstre {
    private int x, y, v; // Position x, position y et vie du monstre
    private double t = 0; // Temps écoulé depuis le dernier déplacement
    private StrategieComportementMonstre strategie;
    private double tempsDepuisDerniereAttaque = 0;
    private static final double DELAI_ATTAQUE = 1.0; // 1 seconde entre attaques
    private long tempsDernierDegat = 0;



    /**
     * Constructeur du monstre.
     * 
     * @param x position en x
     * @param y position en y
     */
    public Monstre(int x, int y) {
        this.x = x;
        this.y = y;
        this.v = 2;
    }

    public void setStrategie(StrategieComportementMonstre strategie) {
        this.strategie = strategie;
    }

    public void agirAvecDelai(Labyrinthe laby, Perso perso, double secondes) {
        // 1 : Mettre à jour le cooldown
        tempsDepuisDerniereAttaque += secondes;

        // 2 : Déplacer le monstre
        deplacerMonstre(laby, perso, secondes);

        // 3 : Attaquer si adjacent et cooldown écoulé
        if (tempsDepuisDerniereAttaque >= DELAI_ATTAQUE) {
            boolean aAttaque = strategie.agir(this, perso);
            if (aAttaque) {
                tempsDepuisDerniereAttaque = 0;
            }
        }
    }

    /**
     * Retourne la position x du monstre.
     * 
     * @return la position x du monstre
     */
    public int getX() {
        return this.x;
    }

    /**
     * Retourne la position y du monstre.
     * 
     * @return la position y du monstre
     */
    public int getY() {
        return this.y;
    }

    /**
     * Vérifie si le monstre est à la même position qu'une position donnée.
     * 
     * @param px position x testée
     * @param py position y testée
     * @return vrai si même position, faux sinon
     */
    public boolean estSurPosition(int px, int py) {
        return this.x == px && this.y == py;
    }

    /**
     * Vérifie si le monstre est mort (vie inférieure ou égale à 0).
     * 
     * @return vrai si le monstre est mort, faux sinon
     */
    public boolean estmort() {
        return this.v <= 0;
    }

    /**
     * Déplace le monstre dans le labyrinthe si possible.
     * Le déplacement est aléatoire et ne se fait que si un certain temps s'est
     * écoulé.
     * Le monstre ne peut pas traverser les murs, ni aller sur la case du personnage
     * ou d'un autre monstre.
     * 
     * @param laby     le labyrinthe dans lequel se trouve le monstre
     * @param perso    le personnage à éviter
     * @param secondes temps écoulé depuis la dernière mise à jour
     */
    public void deplacerMonstre(Labyrinthe laby, Perso perso, double secondes) {
        if (estmort()) {
            System.out.println("Monstre est mort");
            return;
        }

        t += secondes;

        if (t < 0.5) {
            return; // pas encore le temps de bouger
        }

        t = 0;
        int[][] directions = {
                { 0, -1 }, // haut
                { 0, 1 }, // bas
                { -1, 0 }, // gauche
                { 1, 0 } // droite
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
        if (laby.estCaseOccupeeParMonstre(newX, newY))
            return;

        this.x = newX;
        this.y = newY;
    }

    /**
     * Inflige des dégâts au monstre.
     * 
     * @param degats nombre de points de vie à retirer
     */
    public void prendreDegat(int degats) {
        this.v -= degats;
        tempsDernierDegat = System.currentTimeMillis();
    }

    /**
     * Retourne la vie actuelle du monstre.
     * 
     * @return la vie du monstre
     */
    public int getV() {
        return v;
    }

    public boolean agir(Perso perso) {
        if (strategie != null) {
            return strategie.agir(this, perso);
        }
        return false;
    }

    public boolean afficherEffetDegat() {
        return System.currentTimeMillis() - tempsDernierDegat < 1000;
    }


}

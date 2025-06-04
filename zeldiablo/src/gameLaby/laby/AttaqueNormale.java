package gameLaby.laby;

/**
 * Implémente une stratégie d'attaque normale pour un monstre.
 * Le monstre inflige 1 point de dégât si le personnage est adjacent.
 */
public class AttaqueNormale implements StrategieComportementMonstre {

    /**
     * Fait agir le monstre selon la stratégie d'attaque normale.
     * Si le personnage perso est adjacent au monstre,
     * il subit 1 point de dégât.
     * @param monstre le monstre qui attaque
     * @param perso le personnage attaqué
     * @return true si une attaque a eu lieu, false sinon
     */
    @Override
    public boolean agir(Monstre monstre, Perso perso) {
        if (estAdjacent(monstre, perso)) {
            perso.subirDegats(1);
            return true;
        }
        return false;
    }

    /**
     * Vérifie si le personnage est adjacent au monstre
     * @param m le monstre
     * @param p le personnage
     * @return true si p est adjacent à m, false sinon
     */
    private boolean estAdjacent(Monstre m, Perso p) {
        int dx = Math.abs(m.getX() - p.getX()); // valeur absolue des positions en x
        int dy = Math.abs(m.getY() - p.getY()); // valeur absolue des positions en y
        return (dx == 1 && dy == 0) || (dx == 0 && dy == 1);
    }
}

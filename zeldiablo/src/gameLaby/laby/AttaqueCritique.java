package gameLaby.laby;

public class AttaqueCritique implements ComportementMonstre {

    @Override
    public boolean agir(Monstre monstre, Perso perso) {
        if (estAdjacent(monstre, perso)) {
            double chance = Math.random(); // nombre entre 0.0 et 1.0
            int degats;
            if (chance < 0.3) {
                degats = 2; // coup critique 30% du temps
            } else {
                degats = 1; // sinon attaque normale
            }
            perso.subirDegats(degats);
            return true;
        }
        return false;
    }

    private boolean estAdjacent(Monstre m, Perso p) {
        int dx = Math.abs(m.getX() - p.getX()); // valeur absolue des positions en x
        int dy = Math.abs(m.getY() - p.getY()); // valeur absolue des positions en y
        return (dx == 1 && dy == 0) || (dx == 0 && dy == 1);
    }
}

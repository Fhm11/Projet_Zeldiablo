package gameLaby.laby;

public class AttaqueNormale implements StrategieComportementMonstre {

    @Override
    public boolean agir(Monstre monstre, Perso perso) {
        if (estAdjacent(monstre, perso)) {
            perso.subirDegats(1);
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

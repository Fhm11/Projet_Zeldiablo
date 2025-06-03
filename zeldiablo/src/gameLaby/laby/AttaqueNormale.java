package gameLaby.laby;

public class AttaqueNormale implements ComportementMonstre {

    @Override
    public boolean agir(Monstre monstre, Perso perso) {
        if (estAdjacent(monstre, perso)) {
            perso.subirDegats(1);
            return true;
        }
        return false;
    }

    private boolean estAdjacent(Monstre m, Perso p) {
        int dx = Math.abs(m.getX() - p.getX());
        int dy = Math.abs(m.getY() - p.getY());
        return (dx == 1 && dy == 0) || (dx == 0 && dy == 1);
    }
}

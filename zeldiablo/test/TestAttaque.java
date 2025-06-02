
import gameLaby.laby.LabyJeu;
import gameLaby.laby.Monstre;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestAttaque {

    @Test
    public void testPersoAttaqueMonstre() {
        LabyJeu jeu = new LabyJeu();

        List<Monstre> monstres = jeu.getLaby().getMonstres();

        assertFalse(monstres.isEmpty());

        Monstre m = monstres.get(0);
        jeu.getPerso().setX(m.getX());
        jeu.getPerso().setY(m.getY() - 1);

        jeu.getPerso().attaquer(monstres);

        int pvAvant = m.getV();
        assertTrue(m.estmort() || m.getV() < pvAvant);
    }

    @Test
    public void AttaquerMonstreMort() {
        LabyJeu jeu = new LabyJeu();
        List<Monstre> monstres = jeu.getLaby().getMonstres();

        assertFalse(monstres.isEmpty(), "La liste de monstres ne doit pas être vide");

        Monstre m = monstres.get(0);

        m.prendreDegat(999);
        assertTrue(m.estmort(), "Le monstre devrait être mort");

        jeu.getPerso().setX(m.getX());
        jeu.getPerso().setY(m.getY() - 1);

        int pvAvant = m.getV();
        jeu.getPerso().attaquer(monstres);
        int pvApres = m.getV();

        assertEquals(pvAvant, pvApres, "Les PV du monstre mort ne doivent pas changer après attaque");
    }
}

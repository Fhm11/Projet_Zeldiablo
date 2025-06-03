import gameLaby.laby.Labyrinthe;
import gameLaby.laby.Perso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestFinDuJeu {

    @Test
    public void testFinJeuPersoAmulette() {
        Labyrinthe laby = new Labyrinthe(5, 5); // laby vide
        Perso p = laby.getPerso();

        p.ramasserAmulette();

        p.setX(0);
        p.setY(0);

        assertTrue(laby.etreFini(), "Le jeu doit être fini quand le héros a l'amulette et retourne à l'entrée.");
    }

    @Test
    public void FinJeuSansAmulette() {
        Labyrinthe laby = new Labyrinthe(5, 5); // laby vide
        Perso p = laby.getPerso();

        p.setX(0);
        p.setY(0);

        assertFalse(laby.etreFini(), "Le jeu ne doit pas être fini si le héros n'a pas l'amulette.");
    }

}

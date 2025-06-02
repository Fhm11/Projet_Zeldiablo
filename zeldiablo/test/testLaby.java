import static org.junit.jupiter.api.Assertions.*;
import gameLaby.laby.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import java.io.IOException;

public class testLaby {

    private Labyrinthe laby;

    @Test
    public void testDeplacementVersCaseVide() throws IOException {
        laby = new Labyrinthe("zeldiablo\\labySimple\\labyTest.txt");
        // Vers la droite (4,2) : case libre
        laby.deplacerPerso("Droite");
        assertEquals(4, laby.getPerso().getX());
        assertEquals(2, laby.getPerso().getY());
    }

    @Test
    public void testDeplacementVersMur() throws IOException{
        laby = new Labyrinthe("zeldiablo\\labySimple\\labyTest.txt");
        // Vers le haut (3,1) : case libre
        laby.deplacerPerso("Haut"); // (3,1)
        laby.deplacerPerso("Haut"); // (3,0) mur
        // Le perso doit rester à (3,1)
        assertEquals(3, laby.getPerso().getX());
        assertEquals(1, laby.getPerso().getY());
    }

    @Test
    public void testDeplacementVersMonstre() throws IOException{
        laby = new Labyrinthe("zeldiablo\\labySimple\\labyTest.txt");
        // Depuis (3,2), va à droite (4,2), puis en bas (4,3), où se trouve le monstre
        laby.deplacerPerso("Droite"); // (4,2)
        laby.deplacerPerso("Bas");    // (4,3) → monstre => doit rester à (4,2)
        assertEquals(4, laby.getPerso().getX());
        assertEquals(2, laby.getPerso().getY());
    }
}

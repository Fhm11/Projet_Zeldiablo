import static org.junit.jupiter.api.Assertions.*;
import gameLaby.laby.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class testLaby {

    private Labyrinthe laby;

    @Test
    public void testDeplacementVersCaseVide() throws IOException {
        laby = new Labyrinthe("2025_Zeldiablo_meziani_biellmann_valeur--maselli_coquin\\zeldiablo\\labySimple\\labyTest.txt");
        // Déplacement à droite, vers case vide (2,1)
        laby.deplacerPerso("droite");
        assertEquals(2, laby.getPerso().getX());
        assertEquals(1, laby.getPerso().getY());
    }

    @Test
    public void testDeplacementVersMur() throws IOException {
        laby = new Labyrinthe("2025_Zeldiablo_meziani_biellmann_valeur--maselli_coquin\\zeldiablo\\labySimple\\labyTest.txt");
        // Déplacement vers le haut, case (1,0) qui est un mur 'X'
        laby.deplacerPerso("haut");
        // Position ne doit pas changer
        assertEquals(1, laby.getPerso().getX());
        assertEquals(1, laby.getPerso().getY());
    }

    @Test
    public void testDeplacementVersMonstre() throws IOException {
        laby = new Labyrinthe("2025_Zeldiablo_meziani_biellmann_valeur--maselli_coquin\\zeldiablo\\labySimple\\labyTest.txt");
        // Le monstre est en (4,1)
        // Déplacement 3 fois à droite (case 4,1 occupée par monstre)
        laby.deplacerPerso("droite"); // x=2, y=1
        laby.deplacerPerso("droite"); // x=3, y=1
        laby.deplacerPerso("droite"); // tentative x=4, y=1 (monstre)
        // La position doit rester à (3,1)
        assertEquals(3, laby.getPerso().getX());
        assertEquals(1, laby.getPerso().getY());
    }
}

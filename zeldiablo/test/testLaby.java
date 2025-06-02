import static org.junit.jupiter.api.Assertions.*;
import gameLaby.laby.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;

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

    @Test
    public void testPositionInitialeMonstre() throws IOException {
        Labyrinthe laby = new Labyrinthe("zeldiablo\\labySimple\\labyTest.txt"); // fichier avec 'M' connu
        List<Monstre> monstres = laby.getMonstres();

        assertEquals(1, monstres.size());

        Monstre m = monstres.get(0);
        assertEquals(4, m.getX());
        assertEquals(3, m.getY());

        Perso p = laby.getPerso();
        assertFalse(m.getX() == p.getX() && m.getY() == p.getY());
    }

    @Test
    public void testAffichageMonstrePosition() throws IOException {
        Labyrinthe laby = new Labyrinthe("zeldiablo\\labySimple\\labyTest.txt");

        List<Monstre> monstres = laby.getMonstres();

        assertFalse(monstres.isEmpty(), "Il doit y avoir au moins un monstre dans le labyrinthe");

        Monstre m = monstres.get(0);

        // Monstre à la position attendue (x=4, y=3)
        assertEquals(4, m.getX(), "Position X du monstre incorrecte");
        assertEquals(3, m.getY(), "Position Y du monstre incorrecte");

        // La case du monstre n'est pas un mur
        assertFalse(laby.getMur(m.getX(), m.getY()), "Le monstre ne doit pas être sur un mur");

        // Le monstre n'est pas sur la même case que le personnage
        Perso p = laby.getPerso();
        assertFalse(m.getX() == p.getX() && m.getY() == p.getY(), "Le monstre ne doit pas être sur la même case que le personnage");
    }


}

    import static org.junit.jupiter.api.Assertions.*;
    import gameLaby.laby.*;
    import org.junit.jupiter.api.Test;

    class TestMonstre {

        @Test
        void testMonstrePasMort() {
            Monstre monstre = new Monstre(0, 0);
            assertFalse(monstre.estmort());
        }

        @Test
        void testDeplacementMonstreSimple() throws Exception {
            Labyrinthe laby = new Labyrinthe(3, 3);
            laby.setMur(1, 1, true);

            Perso perso = new Perso(2, 2);
            Monstre monstre = new Monstre(0, 0);

            monstre.deplacerMonstre(laby, perso, 0.5);

            assertFalse(monstre.estSurPosition(1, 1));

            assertFalse(monstre.estSurPosition(perso.getX(), perso.getY()));
        }

        @Test
        void testMonstreMortNeBougePas() throws Exception {
            Labyrinthe laby = new Labyrinthe(3, 3);
            Perso perso = new Perso(1, 1);
            Monstre monstre = new Monstre(0, 0);

            monstre.prendreDegat(100);

            monstre.deplacerMonstre(laby, perso, 1.0);

            assertEquals(0, monstre.getX());
            assertEquals(0, monstre.getY());
        }

    }

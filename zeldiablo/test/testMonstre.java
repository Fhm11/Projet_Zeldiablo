import static org.junit.jupiter.api.Assertions.*;
import gameLaby.laby.*;
import org.junit.jupiter.api.Test;

class testMonstre {

    @Test
    void testMonstrePasMort() {
        Monstre monstre = new Monstre(0, 0);
        assertFalse(monstre.estmort());
    }

    @Test
    void testDeplacementMonstreSimple() throws Exception {
        Labyrinthe laby = new Labyrinthe(3, 3);  // constructeur simple à ajouter (voir plus bas)
        laby.setMur(1, 1, true);  // on met un mur à (1,1)

        Perso perso = new Perso(2, 2);
        Monstre monstre = new Monstre(0, 0);

        monstre.deplacerMonstre(laby, perso);

        // Vérifie que le monstre n'est pas sur le mur
        assertFalse(monstre.estSurPosition(1, 1));

        // Vérifie que le monstre n'est pas sur la position du perso
        assertFalse(monstre.estSurPosition(perso.getX(), perso.getY()));
    }
}

import static org.junit.jupiter.api.Assertions.*;
import gameLaby.laby.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class TestAttaqueMonstre {

    @Test
    public void testMonstreAttaqueQuandAdjacent() throws IOException {
        Labyrinthe laby = new Labyrinthe("labySimple\\labyTestMonstre.txt");

        Perso perso = laby.getPerso();
        Monstre monstre = laby.getMonstres().get(0);

        // Force positions pour garantir proximité
        perso.setX(2);
        perso.setY(2);
        monstre.setX(3);
        monstre.setY(2);

        int vieAvant = perso.getV();

        monstre.agirAvecDelai(laby, perso, 0);

        assertEquals(vieAvant - 1, perso.getV(), "Le héros doit perdre 1 point de vie quand il est attaqué.");
    }

}

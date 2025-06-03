import gameLaby.laby.Amulette;
import gameLaby.laby.LabyJeu;
import gameLaby.laby.Labyrinthe;
import gameLaby.laby.Perso;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestAmulette {

    @Test
    public void testAmulettePasSurMur() {
        LabyJeu jeu = new LabyJeu();
        Labyrinthe laby = jeu.getLaby();
        Amulette a = laby.getAmulette();

        assertNotNull(a, "L'amulette doit être placée");
        assertFalse(laby.getMur(a.getX(), a.getY()), "L'amulette ne doit pas être sur un mur");
    }

    @Test
    public void testAmulettePasPlaceeSurMur() {
        LabyJeu jeu = new LabyJeu();
        Labyrinthe laby = jeu.getLaby();
        laby.setMur(2, 2, true);

        Amulette amuletteSurMur = new Amulette(2, 2);

        assertTrue(laby.getMur(amuletteSurMur.getX(), amuletteSurMur.getY()), "La case doit être un mur");
    }
}

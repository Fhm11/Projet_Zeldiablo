package gameLaby.laby;

public interface ComportementMonstre {
    /**
     * Fait agir le monstre sur le personnage s'il est adjacent.
     * @param monstre Le monstre concerné.
     * @param perso Le personnage (héros).
     * @return true si une attaque a été effectuée, false sinon.
     */
    boolean agir(Monstre monstre, Perso perso);
}
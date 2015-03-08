package servants;

import Dames.JoueurPOA;
import org.omg.PortableServer.POA;

/**
 * Created by bernardog on 05/03/15.
 */
public class JoueurImpl extends JoueurPOA {

    private String nomJoueur;

    public JoueurImpl(String nom){
        nomJoueur = nom;
    }

    @Override
    public String nomJoueur() {
        return nomJoueur;
    }

    @Override
    public void aToiDeJouer() {

    }

    @Override
    public void partieGagnee() {
        System.out.println("VOUS AVEZ GAGNE LE JEU!");
    }

    @Override
    public void partiePerdue() {
        System.out.println("VOUS AVEZ PERDU LE JEU ):");
    }
}

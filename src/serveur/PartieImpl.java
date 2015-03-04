package serveur;

import Dames.Joueur;
import Dames.PartiePOA;
import Dames.Pion;
import org.omg.PortableServer.POA;

/**
 * Created by bernardog on 04/03/15.
 */
public class PartieImpl extends PartiePOA {

    protected POA poa_;
    public String nom;
    public Joueur[] joueurs;

    public PartieImpl(POA poa, Joueur joueurBlanc, String nom) {
        poa_ = poa;
        joueurs = new Joueur[2];
        joueurs[0] = joueurBlanc;
        this.nom = nom;
    }

    @Override
    public Joueur blancs() {
        return null;
    }

    @Override
    public Joueur noirs() {
        return null;
    }

    @Override
    public void faireUnDeplacement(Pion pion) {

    }
}

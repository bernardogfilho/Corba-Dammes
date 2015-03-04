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

    public PartieImpl(POA poa) {
        poa_ = poa;
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

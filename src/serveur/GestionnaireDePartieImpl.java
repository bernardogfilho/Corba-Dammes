package serveur;

import Dames.*;
import org.omg.PortableServer.POA;

/**
 * Created by bernardog on 04/03/15.
 */
public class GestionnaireDePartieImpl extends GestionaireDePartiePOA {

    protected POA poa_;

    public GestionnaireDePartieImpl(POA poa) {
        poa_ = poa;
    }

    @Override
    public Partie creationDunePartie(Joueur pionsBlancs, String nomDeLaPartie) {
        try {
            PartieImpl partieImpl = new PartieImpl(_poa(), pionsBlancs, nomDeLaPartie);
            org.omg.CORBA.Object partieObj = poa_.servant_to_reference(partieImpl);
            return PartieHelper.narrow(partieObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Partie ajouterJoueurPionsNoirs(Joueur pionsNoirs, String nomDeLaPartie) {
        return null;
    }

}

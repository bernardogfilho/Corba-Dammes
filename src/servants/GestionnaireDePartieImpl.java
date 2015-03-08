package servants;

import Dames.*;
import Dames.Joueur;
import Dames.GestionaireDePartiePOA;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
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
            PartieImpl partieImpl = new PartieImpl(pionsBlancs);
            org.omg.CORBA.Object partieRef = poa_.servant_to_reference(partieImpl);
            System.out.println("Parti cree...");
            return PartieHelper.narrow(partieRef);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Partie ajouterJoueurPionsNoirs(Joueur pionsNoirs, String nomDeLaPartie) {
        try {
            System.out.println("== GETTING THE ROUND");
            org.omg.CORBA.Object nsRef = _orb().resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(nsRef);
            Partie partie = PartieHelper.narrow(ncRef.resolve_str(nomDeLaPartie));
            partie.ajouterJoueurNoirs(pionsNoirs);
            NameComponent name[] = ncRef.to_name("Partie");
            ncRef.rebind(name, partie);
            System.out.println("Partie republie...");
            return partie;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}

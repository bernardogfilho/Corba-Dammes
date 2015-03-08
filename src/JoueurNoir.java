import Dames.GestionaireDePartie;
import Dames.GestionaireDePartieHelper;
import Dames.Joueur;
import Dames.JoueurHelper;
import com.sun.corba.se.internal.iiop.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import servants.JoueurImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by bernardog on 08/03/15.
 */
public class JoueurNoir {

    public static void main(String[] args) {
        try {
            org.omg.CORBA.ORB orb = ORB.init(args, null);
            POA poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            poa.the_POAManager().activate();
            org.omg.CORBA.Object objRef= orb.resolve_initial_references("NameService");

            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            GestionaireDePartie gestionnaire = GestionaireDePartieHelper.narrow(ncRef.resolve_str("GestionnaireDePartie"));

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Inserez votre nom:");
            String joueurNom = br.readLine();

//            White player creation
            JoueurImpl joueurImpl = new JoueurImpl(joueurNom);
            org.omg.CORBA.Object joueurRef = poa.servant_to_reference(joueurImpl);
            Joueur joueurHRef = JoueurHelper.narrow(joueurRef);
            org.omg.CORBA.Object joueurObjRef = orb.resolve_initial_references("NameService");
            NamingContextExt gpNcRef = NamingContextExtHelper.narrow(joueurObjRef);
//            Binding the name with the reference
            String jNom = "JoueurNoir";
            NameComponent joueurPath[] = gpNcRef.to_name(jNom);
//            Black player server registration
            gpNcRef.rebind(joueurPath, joueurHRef);

            Joueur joueur = JoueurHelper.narrow(ncRef.resolve_str(jNom));

            gestionnaire.ajouterJoueurPionsNoirs(joueur, "Partie");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

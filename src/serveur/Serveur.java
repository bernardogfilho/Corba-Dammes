package serveur;

import Dames.GestionaireDePartie;
import Dames.GestionaireDePartieHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

/**
 * Created by bernardog on 04/03/15.
 */
public class Serveur {
    public static void main(String[] args) {
        try {
//            Initialize the ORB
            ORB orb = ORB.init(args, null);
//            Initialize the POA
            POA poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            poa.the_POAManager().activate();

//            Create the game manager
            GestionnaireDePartieImpl gpi = new GestionnaireDePartieImpl(poa);

//            Get the reference
            org.omg.CORBA.Object ref = poa.servant_to_reference(gpi);
            GestionaireDePartie h_ref = GestionaireDePartieHelper.narrow(ref);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            System.out.println("TESTE 2");
//            Binding the name with the reference
            String nom = "GestionnaireDePartie";
            NameComponent path[] = ncRef.to_name(nom);
            ncRef.rebind(path, h_ref);

//            Run the server
            Orb_Run serveur = new Orb_Run(orb);
            serveur.start();
            System.out.printf("Le serveur pret et en attente pour les joueurs...");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

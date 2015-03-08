import Dames.GestionaireDePartie;
import Dames.GestionaireDePartieHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import servants.GestionnaireDePartieImpl;

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
            org.omg.CORBA.Object gpRef = poa.servant_to_reference(gpi);
            GestionaireDePartie gpHRef = GestionaireDePartieHelper.narrow(gpRef);
            org.omg.CORBA.Object gpObjRef = orb.resolve_initial_references("NameService");
            NamingContextExt gpNcRef = NamingContextExtHelper.narrow(gpObjRef);
//            Binding the name with the reference
            String gpNom = "GestionnaireDePartie";
            NameComponent gpPath[] = gpNcRef.to_name(gpNom);
            gpNcRef.rebind(gpPath, gpHRef);

//            Create the round
//            servants.PartieImpl pi = new servants.PartieImpl(poa);
////            Get the reference
//            org.omg.CORBA.Object pRef = poa.servant_to_reference(pi);
//            Partie pHRef = PartieHelper.narrow(pRef);
//            org.omg.CORBA.Object pObjRef = orb.resolve_initial_references("NameService");
//            NamingContextExt pNcRef = NamingContextExtHelper.narrow(pObjRef);
////            Binding the name with the reference
//            String pNom = "Partie";
//            NameComponent pPath[] = pNcRef.to_name(pNom);
//            pNcRef.rebind(pPath, pHRef);

//            Run the server
            Orb_Run serveur = new Orb_Run(orb);
            serveur.start();
            System.out.println("Le serveur pret et en attente pour les joueurs...");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

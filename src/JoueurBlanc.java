import Dames.*;
import com.sun.corba.se.internal.iiop.ORB;
import gui.CheckersGUI;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import servants.JoueurImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * Created by bernardog on 05/03/15.
 */
public class JoueurBlanc {

    public static void main(String[] args) {
        try {
            org.omg.CORBA.ORB orb = ORB.init(args, null);
            POA poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            poa.the_POAManager().activate();
            org.omg.CORBA.Object objRef= orb.resolve_initial_references("NameService");

            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            String gestNom = "GestionnaireDePartie";
            GestionaireDePartie gestionnaire = GestionaireDePartieHelper.narrow(ncRef.resolve_str(gestNom));

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Inserez votre nom:");
            String joueurNom = br.readLine();

//            White player creation
            JoueurImpl joueurImpl = new JoueurImpl(joueurNom);
            org.omg.CORBA.Object joueurRef = poa.servant_to_reference(joueurImpl);
            Joueur joueurHRef = JoueurHelper.narrow(joueurRef);
            org.omg.CORBA.Object joueurObjRef = orb.resolve_initial_references("NameService");
            NamingContextExt joueurNcRef = NamingContextExtHelper.narrow(joueurObjRef);
//            Binding the name with the reference
            String jNom = "JoueurBlanc";
            NameComponent joueurPath[] = joueurNcRef.to_name(jNom);
//            White player server registration
            joueurNcRef.rebind(joueurPath, joueurHRef);

            Joueur joueur = JoueurHelper.narrow(ncRef.resolve_str(jNom));

//            Round Creation
            Partie partie = gestionnaire.creationDunePartie(joueur,"partie");

//            Round publication at the name server
            org.omg.CORBA.Object partieObjRef = orb.resolve_initial_references("NameService");
            NamingContextExt partieNcRef = NamingContextExtHelper.narrow(partieObjRef);
            NameComponent partiePath[] = partieNcRef.to_name("Partie");
            partieNcRef.rebind(partiePath, partie);
            System.out.println("Partie publie...");


//            CheckersGUI gui = new CheckersGUI();


        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}

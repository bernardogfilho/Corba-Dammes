package serveur;

import org.omg.CORBA.ORB;

/**
 * Created by bernardog on 04/03/15.
 */

public class Orb_Run extends Thread{
    public ORB orb_;

    public Orb_Run(ORB o) {
        orb_=o;
    }

    public void run() {
        System.out.println("Le serveur est pret");
        orb_.run();
    }
}

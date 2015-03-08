package servants;

import Dames.Joueur;
import Dames.PartiePOA;
import Dames.Pion;
import org.omg.PortableServer.POA;

/**
 * Created by bernardog on 04/03/15.
 */
public class PartieImpl extends PartiePOA {

    protected POA poa_;
    private Joueur blancs;
    private Joueur noirs;

    public PartieImpl(POA poa) {
        poa_ = poa;
    }

    public PartieImpl() {
        
    }

    public PartieImpl(Joueur pionsBlancs) {
        super();
    }

    public void setJoueurNoir(Joueur noirs){
        this.noirs = noirs;
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

    @Override
    public void ajouterJoueurNoirs(Joueur joueurNoirs) {
        noirs = joueurNoirs;
    }
}

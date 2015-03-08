package Dames;


/**
* Dames/_GestionaireDePartieStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Dames.idl
* Domingo, 8 de Março de 2015 03h02min39s CET
*/

public class _GestionaireDePartieStub extends org.omg.CORBA.portable.ObjectImpl implements Dames.GestionaireDePartie
{

  public Dames.Partie creationDunePartie (Dames.Joueur pionsBlancs, String nomDeLaPartie)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("creationDunePartie", true);
                Dames.JoueurHelper.write ($out, pionsBlancs);
                $out.write_string (nomDeLaPartie);
                $in = _invoke ($out);
                Dames.Partie $result = Dames.PartieHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return creationDunePartie (pionsBlancs, nomDeLaPartie        );
            } finally {
                _releaseReply ($in);
            }
  } // creationDunePartie

  public Dames.Partie ajouterJoueurPionsNoirs (Dames.Joueur pionsNoirs, String nomDeLaPartie)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("ajouterJoueurPionsNoirs", true);
                Dames.JoueurHelper.write ($out, pionsNoirs);
                $out.write_string (nomDeLaPartie);
                $in = _invoke ($out);
                Dames.Partie $result = Dames.PartieHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return ajouterJoueurPionsNoirs (pionsNoirs, nomDeLaPartie        );
            } finally {
                _releaseReply ($in);
            }
  } // ajouterJoueurPionsNoirs

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Dames/GestionaireDePartie:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _GestionaireDePartieStub

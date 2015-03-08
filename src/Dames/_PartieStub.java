package Dames;


/**
* Dames/_PartieStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Dames.idl
* Domingo, 8 de Março de 2015 03h02min39s CET
*/


//
public class _PartieStub extends org.omg.CORBA.portable.ObjectImpl implements Dames.Partie
{

  public Dames.Joueur blancs ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_get_blancs", true);
                $in = _invoke ($out);
                Dames.Joueur $result = Dames.JoueurHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return blancs (        );
            } finally {
                _releaseReply ($in);
            }
  } // blancs

  public Dames.Joueur noirs ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("_get_noirs", true);
                $in = _invoke ($out);
                Dames.Joueur $result = Dames.JoueurHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return noirs (        );
            } finally {
                _releaseReply ($in);
            }
  } // noirs


  // nécessaires au fonctionnement du jeu
  public void faireUnDeplacement (Dames.Pion pion)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("faireUnDeplacement", true);
                Dames.PionHelper.write ($out, pion);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                faireUnDeplacement (pion        );
            } finally {
                _releaseReply ($in);
            }
  } // faireUnDeplacement

  public void ajouterJoueurNoirs (Dames.Joueur joueurNoirs)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("ajouterJoueurNoirs", true);
                Dames.JoueurHelper.write ($out, joueurNoirs);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                ajouterJoueurNoirs (joueurNoirs        );
            } finally {
                _releaseReply ($in);
            }
  } // ajouterJoueurNoirs

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Dames/Partie:1.0"};

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
} // class _PartieStub

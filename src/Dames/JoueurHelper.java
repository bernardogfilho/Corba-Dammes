package Dames;


/**
* Dames/JoueurHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Dames.idl
* Domingo, 8 de Março de 2015 03h02min39s CET
*/


//
abstract public class JoueurHelper
{
  private static String  _id = "IDL:Dames/Joueur:1.0";

  public static void insert (org.omg.CORBA.Any a, Dames.Joueur that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static Dames.Joueur extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (Dames.JoueurHelper.id (), "Joueur");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static Dames.Joueur read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_JoueurStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, Dames.Joueur value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static Dames.Joueur narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Dames.Joueur)
      return (Dames.Joueur)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      Dames._JoueurStub stub = new Dames._JoueurStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static Dames.Joueur unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Dames.Joueur)
      return (Dames.Joueur)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      Dames._JoueurStub stub = new Dames._JoueurStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}

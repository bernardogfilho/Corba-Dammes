package Dames;


/**
* Dames/pionsBlancsHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Dames.idl
* Domingo, 8 de Março de 2015 03h02min39s CET
*/

public final class pionsBlancsHolder implements org.omg.CORBA.portable.Streamable
{
  public Dames.Pion value[] = null;

  public pionsBlancsHolder ()
  {
  }

  public pionsBlancsHolder (Dames.Pion[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Dames.pionsBlancsHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Dames.pionsBlancsHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Dames.pionsBlancsHelper.type ();
  }

}

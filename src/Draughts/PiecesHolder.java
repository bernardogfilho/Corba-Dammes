package Draughts;


/**
* Draughts/PiecesHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Draughts.idl
* Quarta-feira, 4 de Março de 2015 18h36min14s CET
*/

public final class PiecesHolder implements org.omg.CORBA.portable.Streamable
{
  public Draughts.Piece value[] = null;

  public PiecesHolder ()
  {
  }

  public PiecesHolder (Draughts.Piece[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Draughts.PiecesHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Draughts.PiecesHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Draughts.PiecesHelper.type ();
  }

}

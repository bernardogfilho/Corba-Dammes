package Dames;


/**
* Dames/Pion.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Dames.idl
* Domingo, 8 de Março de 2015 03h02min39s CET
*/

public final class Pion implements org.omg.CORBA.portable.IDLEntity
{
  public int x = (int)0;
  public int y = (int)0;
  public boolean cestRoi = false;

  public Pion ()
  {
  } // ctor

  public Pion (int _x, int _y, boolean _cestRoi)
  {
    x = _x;
    y = _y;
    cestRoi = _cestRoi;
  } // ctor

} // class Pion

package Draughts;


/**
* Draughts/PositionHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Draughts.idl
* Quarta-feira, 4 de Março de 2015 18h36min14s CET
*/

abstract public class PositionHelper
{
  private static String  _id = "IDL:Draughts/Position:1.0";

  public static void insert (org.omg.CORBA.Any a, Draughts.Position that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static Draughts.Position extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [2];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[0] = new org.omg.CORBA.StructMember (
            "x",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[1] = new org.omg.CORBA.StructMember (
            "y",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (Draughts.PositionHelper.id (), "Position", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static Draughts.Position read (org.omg.CORBA.portable.InputStream istream)
  {
    Draughts.Position value = new Draughts.Position ();
    value.x = istream.read_long ();
    value.y = istream.read_long ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, Draughts.Position value)
  {
    ostream.write_long (value.x);
    ostream.write_long (value.y);
  }

}

package Draughts;


/**
* Draughts/PlayerPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Draughts.idl
* Quarta-feira, 4 de Março de 2015 18h36min15s CET
*/

public abstract class PlayerPOA extends org.omg.PortableServer.Servant
 implements Draughts.PlayerOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("_get_pieces", new java.lang.Integer (0));
    _methods.put ("_set_pieces", new java.lang.Integer (1));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // Draughts/Player/_get_pieces
       {
         Draughts.Piece $result[] = null;
         $result = this.pieces ();
         out = $rh.createReply();
         Draughts.PiecesHelper.write (out, $result);
         break;
       }

       case 1:  // Draughts/Player/_set_pieces
       {
         Draughts.Piece newPieces[] = Draughts.PiecesHelper.read (in);
         this.pieces (newPieces);
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Draughts/Player:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Player _this() 
  {
    return PlayerHelper.narrow(
    super._this_object());
  }

  public Player _this(org.omg.CORBA.ORB orb) 
  {
    return PlayerHelper.narrow(
    super._this_object(orb));
  }


} // class PlayerPOA

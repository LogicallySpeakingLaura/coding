package object_construction.interfaces;

/**
 * Interface implementation and explanation. Blueprint for a class, there are no constructors. Treat everything as abstract.
 *
 * @author LogicallySpeakingLaura
 * @version 2020.12.03
 * @see iPhone for implementation
 */
interface iOS
{
    //Methods
    String getOSName(); //all methods are left unimplemented and the the signature finishes w/ a ;

    long getOSVersion();

    String[] getAppStorePurchases();

}
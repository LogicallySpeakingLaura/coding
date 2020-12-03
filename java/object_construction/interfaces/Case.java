package object_construction.interfaces;

/**
 * Interface implementation and explanation. Blueprint for a class, there are no constructors. Treat everything as abstract.
 *
 * @author LogicallySpeakingLaura
 * @version 2020.12.03
 * @see Android for implementation
 */
interface Case
{

    //Attributes
    boolean HAS_WARRANTY = true; //treated as a final static constant, do not change in implementing Class

    //Methods
    String getColour(); //all methods are left unimplemented and the the signature finishes w/ a ;

    String getBrand();

}

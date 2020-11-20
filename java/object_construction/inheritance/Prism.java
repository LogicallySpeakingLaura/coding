package object_construction.inheritance;

/**
 * Class that demonstrates an abstract subclass for inheritance. Prism IS-A Shape for its entire lifecycle.
 *
 * @author LogicallySpeakingLaura
 * @version 2020.10.17
 * @see Shape for an abstract superclass
 * @see PrismSquare for a subclass
 */
abstract class Prism extends Shape //cannot be instantiated but still can inherit from its superclass
{                                   //and then pass down to its own subclasses

    //Attributes
    private int length; //can be passed down to subclass


    //Constructors
    protected Prism() {}

    protected Prism( int height, int length ) //height inherited from Shape
    {
        super(height); //super accesses the superclass attribute
        this.length = length;
    }


    //Getters & Setters
    protected int getLength()
    {
        return length;
    } //no g&s for height as that comes from superclass

    protected void setLength( int length )
    {
        this.length = length;
    }


    //Methods
    @Override
    protected abstract int getBaseArea(); //as superclass abstract must have these methods
                                            //but can make abstract as this is abstract
    @Override
    protected abstract int getVolume();

    public String toString()
    {
        return super.toString() + //super gets toString() of superclass
                "/nLength: " + length;
    }

}
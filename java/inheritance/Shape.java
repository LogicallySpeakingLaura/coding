package inheritance;

/**
 * Class that demonstrates the superclass for inheritance.
 *
 * @author LogicallySpeakingLaura
 * @version 2020.10.17
 * @see Prism for an abstract subclass
 * @see Cylinder for a subclass
 */
abstract class Shape //abstract - class cannot be instantiated
{

    //Attributes
    private int height; //will be inherited by all subclasses


    //Constructors
    protected Shape() {}

    protected Shape( int height )
    {
        this.height = height;
    }


    //Setters & Getters
    protected int getHeight()
    {
        return height;
    }

    protected void setHeight( int height )
    {
        this.height = height;
    }


    //Methods
    protected abstract int getBaseArea(); //abstract methods must be used by subclasses

    protected abstract int getVolume();

    public String toString()
    {
        return "Height: " + height;
    }

}
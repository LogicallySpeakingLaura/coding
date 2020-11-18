package inheritance;

/**
 * Class that demonstrates a subclass for inheritance.
 *
 * @author LogicallySpeakingLaura
 * @version 2020.10.17
 * @see Shape for superclass of superclass/grandparent
 * @see Prism for superclass/parent
 */
class PrismSquare extends Prism //not abstract, class can be instantiated
{

    //Constructors
    protected PrismSquare() {}

    protected PrismSquare( int height, int length ) //no need for attributes if only ones needed come from superclass(es)
    {
        super(height, length);
    }


    //Methods
    @Override
    protected int getBaseArea() //must inherit abstract methods and give functionality
    {
        return (int) Math.pow(getLength(), 2);
    }

    @Override
    protected int getVolume()
    {
        return getBaseArea() * getHeight();
    }

    public String toString()
    {
        return super.toString() +
                "/nBase area: " + getBaseArea() +
                "/nVolume: " + getVolume();
    }

}
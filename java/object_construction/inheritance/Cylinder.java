package object_construction.inheritance;

/**
 * Class that demonstrates a subclass for inheritance.
 *
 * @author LogicallySpeakingLaura
 * @version 2020.10.17
 * @see Shape for superclass
 */
class Cylinder extends Shape
{

    //Attributes
    private int radius;


    //Constructors
    protected Cylinder() {}

    protected Cylinder( int height, int radius ) //height inherited from superclass
    {
        super(height);
        this.radius = radius;
    }


    //Getters & Setters
    protected int getRadius() //g&s for height comes from superclass
    {
        return radius;
    }

    protected void setRadius( int radius )
    {
        this.radius = radius;
    }


    //Methods
    @Override
    protected int getBaseArea() //as class not abstract, must give functionality for inherited methods
    {
        return (int) ( Math.PI * Math.pow( getRadius(), 2 ) );
    }

    @Override
    protected int getVolume()
    {
        return getBaseArea() * getHeight();
    }

    @Override
    public String toString()
    {
        return super.toString() +
                "/nRadius: " + getRadius() +
                "/nBase area: " + getBaseArea() +
                "/nVolume: " + getVolume();
    }

}
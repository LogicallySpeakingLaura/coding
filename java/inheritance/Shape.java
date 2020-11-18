package inheritance;

abstract class Shape
{

    //Attributes
    private int height;


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
    protected abstract int getBaseArea();

    protected abstract int getVolume();

    public String toString()
    {
        return "Height: " + height;
    }

}
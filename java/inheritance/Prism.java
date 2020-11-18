package inheritance;

abstract class Prism extends Shape
{

    //Attributes
    private int length;


    //Constructors
    public Prism() {}

    public Prism( int height, int length )
    {
        super(height);
        this.length = length;
    }


    //Getters & Setters
    public double getLength()
    {
        return length;
    }

    public void setLength( int length )
    {
        this.length = length;
    }


    //Methods
    @Override
    public abstract int getBaseArea();

    @Override
    public abstract int getVolume();

    public String toString()
    {
        return super.toString() +
                "/nLength: " + length;
    }

}

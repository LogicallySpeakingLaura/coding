package model.shapes;

/**
 * This subclass defines the parameters needed for a Pyramid, inheriting common parameters from Shape.
 * @author 776298
 */
public class Pyramid extends Shape
{
	//Attributes
	private double length;
	
	//Constructors
	/**
	 * Default constructor
	 */
	public Pyramid() {}
		
	/**
	 * Constructor.
	 * @param height  - the height of a pyramid as a double.
	 * @param length - the side length of a pyramid as a double.
	 */
	public Pyramid(double height, double length)
	{
		super(height);
		this.length = length;
	}
	
	//Getters & Setters
	/**
	 * @return - the side length of a pyramid as a double.
	 */
	public double getLength() 
	{
		return length;
	}

	/**
	 * Sets the side length of a pyramid.
	 * @param length - the side length of a pyramid as a double.
	 */
	public void setLength(double length) 
	{
		this.length = length;
	}

	//Methods
	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getBaseArea() 
	{
		return Math.pow( getLength(), 2 );
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getVolume() 
	{
		return ( Math.pow( getLength(), 2 ) * getHeight() ) / 3;
	}

	/**
	 * Returns a String containing the data of an instance of a Pyramid object.
	 */
	@Override
	public String toString() 
	{
		return "Pyramid [height=" + getHeight() + ", length=" + length + ", base area=" + getBaseArea() + ", volume=" + getVolume() + "]";
	}
	
	
}

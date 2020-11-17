package model.shapes;

/**
 * This subclass defines the common parameters needed for different types of prisms, inheriting common parameters from Shape.
 * @author 776298
 */
public abstract class Prism extends Shape
{
	//Attributes
	private double length;
	
	//Constructors
	/**
	 * Default constructor
	 */
	public Prism() {}
			
	/**
	 * Constructor.
	 * @param height  - the height of a prism as a double.
	 * @param length - the side length of a prism as a double.
	 */
	public Prism(double height, double length)
	{
		super(height);
		this.length = length;
	}
		
	//Getters & Setters
	/**
	 * @return - the side length of a prism as a double.
	 */
	public double getLength() 
	{
		return length;
	}

	/**
	 * Sets the side length of a prism.
	 * @param length - the side length of a prism as a double.
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
	public abstract double getBaseArea();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract double getVolume();
	
	/**
	 * Returns a String containing the data of an instance of a Prism object.
	 */
	public String toString()
	{
		return "Prism [height=" + getHeight() + ", length=" + length + "]";
	}
}

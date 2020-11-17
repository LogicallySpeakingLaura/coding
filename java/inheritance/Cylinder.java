package model.shapes;

/**
 * This subclass defines the parameters needed for a Cylinder, inheriting common parameters from Shape.
 * @author 776298
 */
public class Cylinder extends Shape
{
	//Attributes
	private double radius;
	
	//Constructors
	/**
	 * Default constructor
	 */
	public Cylinder() {}
	
	/**
	 * Constructor.
	 * @param height  - the height of a cylinder as a double.
	 * @param radius - the radius of a cylinder as a double.
	 */
	public Cylinder(double height, double radius)
	{
		super(height);
		this.radius = radius;
	}
	
	//Getters & Setters
	/**
	 * @return - the radius of a cylinder as a double.
	 */
	public double getRadius() 
	{
		return radius;
	}

	/**
	 * Sets the radius of a cylinder.
	 * @param radius - the radius of a cylinder as a double.
	 */
	public void setRadius(double radius) 
	{
		this.radius = radius;
	}
	
	//Methods
	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getBaseArea() 
	{
		return Math.PI * Math.pow( getRadius(), 2 );
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getVolume() 
	{
		return getBaseArea() * getHeight();
	}
	
	/**
	 * Returns a String containing the data of an instance of a Cylinder object.
	 */
	@Override
	public String toString() 
	{
		return "Cylinder [height=" + getHeight() + ", radius=" + radius + ", base area=" + getBaseArea() + ", volume=" + getVolume() + "]";
	}
}

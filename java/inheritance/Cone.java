package model.shapes;

/**
 * This subclass defines the parameters needed for a Cone, inheriting common parameters from Shape.
 * @author 776298
 */
public class Cone extends Shape
{
	//Attributes
	private double radius;
	
	//Constructors
	/**
	 * Default constructor
	 */
	public Cone() {}
	
	/**
	 * Constructor.
	 * @param height  - the height of a cone as a double.
	 * @param radius - the radius of a cone as a double.
	 */
	public Cone(double height, double radius)
	{
		super(height);
		this.radius = radius;
	}
	
	//Getters & Setters
	/**
	 * @return - the radius of a cone as a double.
	 */
	public double getRadius() 
	{
		return radius;
	}

	/**
	 * Sets the radius of a cone.
	 * @param radius - the radius of a cone as a double.
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
		return ( getBaseArea() * getHeight() ) / 3;
	}
	
	/**
	 * Returns a String containing the data of an instance of a Cone object.
	 */
	@Override
	public String toString() 
	{
		return "Cone [height=" + getHeight() + ", radius=" + radius + ", base area=" + getBaseArea() + ", volume=" + getVolume() + "]";
	}
}
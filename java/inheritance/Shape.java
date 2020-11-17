package model.shapes;

/**
 * This superclass defines the common parameters for all shapes that will be used in the program.
 * @author 776298
 */
public abstract class Shape implements Comparable<Shape>
{
	//Attributes
	private double height;
	
	//Constructors
	/**
	 * Default constructor.
	 */
	public Shape() {}
	
	/**
	 * Constructor.
	 * @param height - the height of a shape as a double.
	 */
	public Shape(double height)
	{
		this.height = height;
	}

	//Setters & Getters
	/**
	 * @return - the height of a shape as a double.
	 */
	public double getHeight() 
	{
		return height;
	}

	/**
	 * Sets the height of a shape.
	 * @param height - the height of a shape as a double.
	 */
	public void setHeight(double height) 
	{
		this.height = height;
	}
	
	//Methods
	/**
	 * @return - the base area of a shape as a double.
	 */
	public abstract double getBaseArea();
	
	/**
	 * @return - the volume of a shape as a double.
	 */
	public abstract double getVolume();
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(Shape other)
	{
		int difference = 0;
		
		if ( this.getVolume() > other.getVolume() )
			difference = 1;
		else if ( this.getVolume() < other.getVolume() )
			difference = -1;
		
		return difference;
	}
	
	/**
	 * Returns a String containing the data of an instance of a Shape object.
	 */
	public String toString() 
	{
		return "Shape [height=" + height + "]";
	}
}

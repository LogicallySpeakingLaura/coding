package model.shapes.prismBases;

import model.shapes.Prism;

/**
 * This subclass defines the parameters needed for a square prism, inheriting common parameters from Prism.
 * @author 776298
 */
public class SquarePrism extends Prism
{
	//Constructors
	/**
	 * Default constructor
	 */
	public SquarePrism() {}
	
	/**
	 * Constructor.
	 * @param height  - the height of a prism as a double.
	 * @param length - the side length of a prism as a double.
	 */
	public SquarePrism(double height, double length) 
	{
		super( height, length );
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
		return getBaseArea() * getHeight();
	}
	
	/**
	 * Returns a String containing the data of an instance of a SquarePrism object.
	 */
	public String toString()
	{
		return "Square Prism [height=" + getHeight() + ", length=" + getHeight() + ", base area=" + getBaseArea() + ", volume=" + getVolume() + "]";
	}
}
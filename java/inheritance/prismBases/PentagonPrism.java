package model.shapes.prismBases;

import model.shapes.Prism;

/**
 * This subclass defines the parameters needed for a pentagon prism, inheriting common parameters from Prism.
 * @author 776298
 */
public class PentagonPrism extends Prism
{
	//Constructors
	/**
	 * Default constructor
	 */
	public PentagonPrism(){}
	
	/**
	 * Constructor.
	 * @param height  - the height of a prism as a double.
	 * @param length - the side length of a prism as a double.
	 */
	public PentagonPrism(double height, double length)
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
		return ( 5 * Math.pow( getLength(), 2) * Math.tan(54) ) / 4;
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
	 * Returns a String containing the data of an instance of a PentagonPrism object.
	 */
	public String toString()
	{
		return "Pentagon Prism [height=" + getHeight() + ", length=" + getHeight() + ", base area=" + getBaseArea() + ", volume=" + getVolume() + "]";
	}
}

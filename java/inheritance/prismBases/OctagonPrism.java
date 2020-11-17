package model.shapes.prismBases;

import model.shapes.Prism;

public class OctagonPrism extends Prism
{
	//Constructors
	/**
	 * Default constructor
	 */
	public OctagonPrism() {}
	
	/**
	 * Constructor.
	 * @param height  - the height of a prism as a double.
	 * @param length - the side length of a prism as a double.
	 */
	public OctagonPrism(double height, double length)
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
		return 2 * ( 1 + Math.sqrt(2) ) * Math.pow( getLength(), 2 );
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
	 * Returns a String containing the data of an instance of a OctagonPrism object.
	 */
	public String toString()
	{
		return "Octagon Prism [height=" + getHeight() + ", length=" + getHeight() + ", base area=" + getBaseArea() + ", volume=" + getVolume() + "]";
	}
}



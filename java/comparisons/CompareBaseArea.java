package model.comparators;

import java.util.Comparator;

import model.shapes.Shape;

/**
 * This class allows shapes to be compared by their base area.
 * @author 776298
 */
public class CompareBaseArea implements Comparator <Shape>
{
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compare ( Shape s1, Shape s2 ) 
	{
		int difference = 0;
		
		if ( s1.getBaseArea() > s2.getBaseArea() )
			difference = 1;
		else if ( s1.getBaseArea() < s2.getBaseArea() )
			difference = -1;
	
		return difference;
	}
}

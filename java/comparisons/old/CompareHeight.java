package comparisons.old;

import java.util.Comparator;

/**
 * This class allows shapes to be compared by their height. 
 * @author 776298
 */
public class CompareHeight implements Comparator <Shape>
{
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compare ( Shape s1, Shape s2 ) 
	{
		int difference = 0;
		
		if ( s1.getHeight() > s2.getHeight() )
			difference = 1;
		else if ( s1.getHeight() < s2.getHeight() )
			difference = -1;
		
		return difference;
	}
}

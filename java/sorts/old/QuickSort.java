package sorts.old;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * This class contains methods to complete a quick sort using either a Comparator, or a Comparable object.
 * Algorithm implemented has theory derived from https://www.geeksforgeeks.org/quick-sort/
 * @author 776298
 */
public class QuickSort 
{
	/**
	 * This method implements a quick sort using the compareTo() method of the Comparable interface.
	 * @param list - ArrayList of type T, so any data type or object can be used.
	 * @return - ArrayList of type T with sorted values.
	 */
	public static <T extends Comparable<? super T>> ArrayList<T> quickCompareTo( ArrayList<T> list )
	{
		if ( list.isEmpty() ) //recursion stopping case
	        return list;
		
		ArrayList<T> smaller = new ArrayList<T>(); //ArrayList for smaller sorted items
		ArrayList<T> bigger = new ArrayList<T>(); //ArrayList for bigger sorted items
		
		T sortedPivot = list.get(0); //item used to check other item values against
		
		for( int i = 1 ; i < list.size() ; i++ ) //starts at 1 as pivot is 0, can't check pivot against itself
		{
			T checkValue = list.get(i); //variable for items in ArrayList
			
			if( checkValue.compareTo(sortedPivot) < 0 ) //if item value is less than pivot value
				smaller.add(checkValue);				//smaller item added to smaller ArrayList
			else							//if item value is bigger than pivot value
				bigger.add(checkValue);		//bigger item added to bigger ArrayList
		}
		
		smaller = quickCompareTo(smaller); //recursively sort smaller values
		bigger = quickCompareTo(bigger);   //recursively sort bigger values
		
		smaller.add(sortedPivot);	//pivot is now biggest value for smaller ArrayList, add it to the end
		
		list.clear();
		list.addAll(smaller);	//add all sorted values back into the ArrayList
		list.addAll(bigger);
		
		return list;
	}
	

	/**
	 * This method implements a quick sort using the compare() method of the Comparator interface.
	 * @param list - ArrayList of type T, so any data type or object can be used.
	 * @param comp - a Comparator of type T, so any Comparator can be used upon implementation.
	 * @return - ArrayList of type T with sorted values.
	 */
	public static <T>ArrayList<T> quickComparator( ArrayList<T> list, Comparator<? super T> comp )
	{
		if ( list.isEmpty() ) 
	        return list;
		
		ArrayList<T> smaller = new ArrayList<T>();
		ArrayList<T> bigger = new ArrayList<T>();
		
		T sortedPivot = list.get(0);
		
		for( int i = 1 ; i < list.size() ; i++ )
		{
			T checkValue = list.get(i);
			
			if( comp.compare( checkValue, sortedPivot ) < 0 )
				smaller.add(checkValue);
			else
				bigger.add(checkValue);
		}
		
		smaller = quickComparator( smaller, comp );
		bigger = quickComparator( bigger, comp );
		
		smaller.add(sortedPivot);
		
		list.clear();
		list.addAll(smaller);
		list.addAll(bigger);
		
		return list;
	}
}

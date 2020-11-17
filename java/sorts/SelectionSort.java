package utilities.sorts;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * This class contains methods to complete a selection sort using either a Comparator, or a Comparable object.
 * Algorithm implemented has theory derived from https://www.geeksforgeeks.org/selection-sort/
 * @author 776298
 */
public class SelectionSort 
{
	/**
	 * This method implements a selection sort using the compareTo() method of the Comparable interface.
	 * @param list - ArrayList of type T, so any data type or object can be used.
	 */
	public static <T extends Comparable<? super T>> void selectionCompareTo( ArrayList<T> list )
	{
		for( int i = 0 ; i < list.size() ; i++ )
		{
			int smallestIndex = i; //position of smallest number in the ArrayList
			
			for( int j = i ; j < list.size() ; j++ )
			{
				if ( list.get(j).compareTo( list.get(smallestIndex) ) < 0 ) //if value at index j is smaller than the current value at smallest index...
					smallestIndex = j; //smallest index now equals index of j, next smallest value in ArayList
			}
			
			T smallest = list.get(smallestIndex); //variable for smallest value equals value at next smallest element index of ArrayList
			list.set( smallestIndex, list.get(i) ); //index for smallest value equals value for index i
			list.set( i, smallest ); //i now equals the smallest value or ArrayList, bigger value now swapped with next smallest value
		}
	}
	
	/**
	 * This method implements a quick sort using the compare() method of the Comparator interface.
	 * @param list - ArrayList of type T, so any data type or object can be used.
	 * @param comp - a Comparator of type T, so any Comparator can be used upon implementation.
	 */
	public static <T> void selectionComparator( ArrayList<T> list, Comparator<? super T> comp )
	{
		for( int i = 0 ; i < list.size() ; i++ )
		{
			int smallestIndex = i;
			
			for( int j = i ; j < list.size() ; j++ )
			{
				if ( comp.compare( list.get(j), list.get(smallestIndex) ) < 0 )
					smallestIndex = j;
			}
			
			T smallest = list.get(smallestIndex);
			list.set( smallestIndex, list.get(i) );
			list.set( i, smallest );
		}
	}
}

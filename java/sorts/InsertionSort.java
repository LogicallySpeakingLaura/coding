package utilities.sorts;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * This class contains methods to complete an insertion sort using either a Comparator, or a Comparable object.
 * Algorithm implemented has theory derived from https://www.geeksforgeeks.org/insertion-sort/
 * @author 776298
 */
public class InsertionSort 
{
	/**
	 * This method implements an insertion sort using the compareTo() method of the Comparable interface.
	 * @param list - ArrayList of type T, so any data type or object can be used.
	 */
	public static <T extends Comparable<? super T>> void insertionCompareTo( ArrayList<T> list )
	{
		for( int i = 1 ; i < list.size() ; i++ ) //i does not equal 0 as previous items in ArrayList are compared to it
		{
			T sortedItem = list.get(i);
			
			for( int j = i - 1 ; j >= 0 ; j-- ) //all items before i are compared till beginning of ArrayList is reached
			{
				if( list.get(j).compareTo(sortedItem) > 0 ) //if item in list before i is bigger than item at i...
				{
					list.set( j + 1, list.get(j) ); //the next item in the list takes the bigger value
					if( j == 0 )
                        list.set( 0, sortedItem); //if it is the beginning of the list, the first index takes the smallest value
				}
				else //if item in list before i is smaller than item at i...
				{
					list.set( j + 1, sortedItem ); //the next item in the list takes the smaller value
					break; //when that condition is no longer true, exit the if/else statement and start for loop from current j value
				}
			}
		}
	}
	
	/**
	 * This method implements an insertion sort using the compare() method of the Comparator interface.
	 * @param list - ArrayList of type T, so any data type or object can be used.
	 * @param comp - a Comparator of type T, so any Comparator can be used upon implementation.
	 */
	public static <T> void insertionComparator( ArrayList<T> list, Comparator<? super T> comp )
	{
		for( int i = 1 ; i < list.size() ; i++ )
		{
			T sortedItem = list.get(i);
			
			for( int j = i - 1 ; j >= 0 ; j-- )
			{
				if( comp.compare( list.get(j), sortedItem ) > 0 )
				{
					list.set( j + 1, list.get(j) );
					if( j == 0 )
                        list.set( 0, sortedItem );
				}
				else
				{
					list.set( j + 1, sortedItem );
					break;
				}
			}
		}
	}
}

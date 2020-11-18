package sorts.old;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * This class contains methods to complete a bubble sort using either a Comparator, or a Comparable object.
 * Algorithm implemented has theory derived from https://www.geeksforgeeks.org/bubble-sort/
 * @author 776298
 */
public class BubbleSort 
{
	/**
	 * This method implements a bubble sort using the compareTo() method of the Comparable interface.
	 * @param list - ArrayList of type T, so any data type or object can be used.
	 */
	public static <T extends Comparable<? super T>> void bubbleCompareTo( ArrayList<T> list )
	{
		for( int i = 0 ; i < ( list.size() - 1 ) ; i++ ) //index goes to end of list minus one as i  
		{												 //needs to be compared a second value which is next item in ArrayList
			for( int j = i + 1 ; j <list.size() ; j++ )  //j is one more than i to represent next item in ArrayList
			{
				if( list.get(i).compareTo( list.get(j) ) > 0 ) //if i is bigger than j...
				{
					T bigger = list.get(i);  //bigger is set to the value of item at index i
					T smaller = list.get(j); //smaller is set to the value of item at index j
					list.set( i, smaller ); //i is set to the smaller value, as it is the smaller index
					list.set( j, bigger ); //j is set to the bigger value, as it is the bigger index
				}
			}
		}
	}
	
	/**
	 * This method implements a bubble sort using the compare() method of the Comparator interface.
	 * @param list - ArrayList of type T, so any data type or object can be used.
	 * @param comp - a Comparator of type T, so any Comparator can be used upon implementation.
	 */
	public static <T> void bubbleComparator( ArrayList<T> list, Comparator<? super T> comp )
	{
		for( int i = 0 ; i < ( list.size() - 1 ) ; i++ )
		{
			for( int j = i + 1 ; j <list.size() ; j++ )
			{
				if( comp.compare( list.get(i), list.get(j) ) > 0 )
				{
					T bigger = list.get(i);
					T smaller = list.get(j);
					list.set( i, smaller );
					list.set( j, bigger );
				}
			}
		}
	}
}

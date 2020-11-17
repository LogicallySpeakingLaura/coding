package utilities.sorts;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * This class contains methods to complete a gnome sort using either a Comparator, or a Comparable object.
 * Algorithm implemented has theory derived from https://www.geeksforgeeks.org/gnome-sort-a-stupid-one/
 * See mySort.txt for more information abut this sorting algorithm.
 * @author 776298
 */
public class GnomeSort 
{
	/**
	 * This method implements a gnome sort using the compareTo() method of the Comparable interface.
	 * @param list - ArrayList of type T, so any data type or object can be used.
	 */
	public static <T extends Comparable<? super T>> void gnomeCompareTo( ArrayList<T> list )
	{
		int i = 1; //current index
		int j = i + 1; //index position right of current
		
		while( i < list.size() ) //loop till end of ArrayList
		{
			if( list.get( i - 1 ).compareTo( list.get(i) ) <= 0 ) //if item at left of index less than or equal to item at current
			{
				i = j; //indexes move along ArrayList
				j++;
			}
			else //if item at previous index bigger than item at current
			{
				T bigger = list.get( i - 1 ); //bigger equals value of item left of current
				T smaller = list.get(i);	  //smaller equals value of item at current
				list.set( i - 1, smaller );   //set left of current to equal the smaller value
				list.set( i--, bigger );	  //set previous of current to equal the bigger value before moving along ArrayList
				i = ( i == 0 ) ? j++ : i;	  //if left neighbor is not at index 0, set current to left of current
			}								  //otherwise set current to right of current, and right of current to one more than that
		}						//THIS ALLOWS MOVE(S) BACKWARDS TO CHECK NEW CURRENT POSITION IS STILL SORTED
	}
	
	/**
	 * This method implements a gnome sort using the compare() method of the Comparator interface.
	 * @param list - ArrayList of type T, so any data type or object can be used.
	 * @param comp - a Comparator of type T, so any Comparator can be used upon implementation.
	 */
	public static <T> void gnomeComparator( ArrayList<T> list, Comparator<? super T> comp )
	{
		int i = 1; 
		int j = i + 1; 
		
		while( i < list.size() ) 
		{
			if( comp.compare( list.get( i - 1 ), list.get(i) ) <= 0 ) 
			{
				i = j; 
				j++;
			}
			else 
			{
				T bigger = list.get( i - 1 ); 
				T smaller = list.get(i);	  
				list.set( i - 1, smaller );   
				list.set( i--, bigger );	  
				i = ( i == 0 ) ? j++ : i;	  
			}								 
		}		
	}
}

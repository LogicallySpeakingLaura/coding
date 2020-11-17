package utilities.sorts;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * This class contains methods to complete a merge sort using either a Comparator, or a Comparable object.
 * Algorithm implemented has theory derived from 
 * https://www.geeksforgeeks.org/merge-sort/ 
 * https://www.geeksforgeeks.org/java-program-for-merge-sort/
 * and numerous StackOverflow questions.
 * @author 776298
 */
public class MergeSort 
{
	/**
	 * This method implements a merge sort using the compareTo() method of the Comparable interface.
	 * @param list - ArrayList of type T, so any data type or object can be used.
	 */
	public static <T extends Comparable<? super T>> void mergeCompareTo( ArrayList<T> list )
	{
		if( list.size() == 1 ) //recursion stopping point
			return;
		
		ArrayList<T> left = new ArrayList<T>();  //temporary lists, will hold divided master list till
	    ArrayList<T> right = new ArrayList<T>(); //each array only has one item
		
		for( int i = 0 ; i < ( list.size() / 2 ) ; i++ ) //taking first half of array and assigning to its own list
			left.add( list.remove(i) ); //each item is removed from the master list as it is copied to sublist
		
		//removing the items at the indexes at the same they are being added to other lists prevents
		//the issue of the list pointing at an index whose value has changed as the loop iterates
		
		 while (list.size()!=0)  //removing remaining values in other half from master list
			 right.add(list.remove(0)); //and into the other sublist
		
		mergeCompareTo(left);	//recursive call to split arrays till each array has only one item in it
		mergeCompareTo(right);  
		
		while( left.size() != 0 && right.size() != 0) //run through loop till either list has gone through all its items
		{
			if( left.get(0).compareTo( right.get(0) ) < 0) //if the item in the left is smaller than the right item
				list.add( left.remove(0) ); //add it to the master list and remove it from the left list
			else
				list.add( right.remove(0) ); //otherwise do the above but remove from the right list
		}
		
		while(left.size() != 0) //for the list that still holds values, whether it is left or right
			list.add( left.remove(0) ); //remove those values from the list while adding them to the master list
		
		while(right.size() != 0)
			list.add( right.remove(0) );
	}
	
	/**
	 * /**
	 * This method implements an insertion sort using the compare() method of the Comparator interface.
	 * @param list - ArrayList of type T, so any data type or object can be used.
	 * @param comp - a Comparator of type T, so any Comparator can be used upon implementation.
	 */
	public static <T> void mergeComparator( ArrayList<T> list, Comparator<? super T> comp )
	{
		if( list.size() == 1 ) 
			return;
		
		ArrayList<T> left = new ArrayList<T>();
	    ArrayList<T> right = new ArrayList<T>();
		
		for( int i = 0 ; i < ( list.size() / 2 ) ; i++ ) 
			left.add( list.remove(i) );
		
		 while (list.size()!=0) right.add(list.remove(0));
		
		mergeComparator( left, comp );	
		mergeComparator( right, comp );  
		
		while( left.size() != 0 && right.size() != 0)
		{
			if( comp.compare( list.get(0), right.get(0) ) < 0)
				list.add( left.remove(0) );
			else
				list.add( right.remove(0) );
		}
		
		while(left.size() != 0)
			list.add( left.remove(0) );
		
		while(right.size() != 0)
			list.add( right.remove(0) );
	}
}

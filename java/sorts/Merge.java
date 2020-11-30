package sorts;

import java.util.*;

/**
 * Class that demonstrates various ways of implementing a merge sort for objects and primitive data types,
 * using lists or arrays.
 *
 * There are six methods. The first three show a merge sort for arrays of any primitive data type, objects using compareTo, then
 * objects using Comparator. The last three shows implementation for the same but for lists.
 **
 * @author LogicallySpeakingLaura
 * @version 2020.11.25
 */
class Merge
{

    /*
     * This sort is a type of divide and conquer sort. Sub-arrays of equal length are created then recursively sorted before being recombined.
     * As elements are grouped in smaller numbers, it takes less time to sort them. It is one of the fastest algorithms.
     *
     * Time complexity: O( n log n )
     */


    //Arrays
    /**
     * This method implements a merge sort of a primitive array.
     * Functional for all primitive data types, however for demonstrative purposes have used int.
     */
    protected void sortPrimitiveArray( int arr[] )
    {
        if ( arr.length == 1 ) //recursion base
            return;

        //sub-arrays to divide master array, length is half of master array
        int[] left = new int[ arr.length / 2 ];
        int[] right = new int[ arr.length - ( arr.length / 2 ) ];

        //fill left subarray
        for ( int i = 0  ;  i < left.length  ;  i++ )
            left[i] = arr[i];

        //fill right, i indexes main array and j right, need different var as reversing through array
        for ( int i = arr.length - 1, j = 0  ;  j < right.length  ;  i--, j++ )
            right[j] = arr[i];

        //recursive call to split each array till they hold only one element
        sortPrimitiveArray( left );
        sortPrimitiveArray( right );

        int l = 0, r = 0, a = 0; //array indexes

        //iterate till one array has gone through all elements, the remaining won't be empty
        while ( l != left.length  &&  r != right.length )
        {
            if ( left[l] < right[r] ) //if the element in the left is smaller than the right
                arr[ a++ ] = left[ l++ ]; //add it to the master array
            else
                arr[ a++ ] = right[ r++ ]; //otherwise do the opposite for the right
        }

        //for the array that still holds values, whether it is left or right, add them to the master array
        while ( l != left.length )
            arr[ a++ ] = left[ l++ ];

        while ( r != right.length )
            arr[ a++ ] = right[ r++ ];
    }

    /**
     * This method implements a merge sort of an object array using the compareTo() method of the Comparable interface.
     * Functional for any object with compareTo defined.
     * T is abstract so can't be instantiated for recursive purposes, so have used String for this implementation.
     */
    protected void sortObjectArray( String arr[] )
    {
        if ( arr.length == 1 ) //recursion base
            return;

        //T is abstract so can't be instantiated into an array of T to divide master list, so have used String for this implementation
        String[] left = new String[ arr.length / 2 ];
        String[] right = new String[ arr.length - ( arr.length / 2 ) ];

        //fill left subarray
        for ( int i = 0  ;  i < left.length  ;  i++ )
            left[i] = arr[i];

        //fill right, i indexes main array and j right, need different var as reversing through array
        for ( int i = arr.length - 1, j = 0  ;  j < right.length  ;  i--, j++ )
            right[j] = arr[i];

        //recursive call to split each array till they hold only one element
        sortObjectArray( left );
        sortObjectArray( right );

        int l = 0, r = 0, a = 0; //array indexes

        //iterate till one array has gone through all elements, the remaining won't be empty
        while ( l != left.length  &&  r != right.length )
        {
            if ( left[l].compareTo( right[r] ) < 0 ) //if the element in the left is smaller than the right
                arr[ a++ ] = left[ l++ ]; //add it to the master array
            else
                arr[ a++ ] = right[ r++ ]; //otherwise do the opposite for the right
        }

        //for the array that still holds values, whether it is left or right, add them to the master array
        while ( l != left.length )
            arr[ a++ ] = left[ l++ ];

        while ( r != right.length )
            arr[ a++ ] = right[ r++ ];
    }

    /**
     * This method implements a merge sort of an array using the compare() method of the Comparator interface.
     * Functional for any object with a related class for comparison.
     * The param comp is for the Class implementing Comparator.
     * T is abstract so can't be instantiated for recursive purposes, so have used Object for this implementation.
     */
    protected void sortComparatorArray( Object arr[], Comparator< ? super Object > comp )
    {
        if ( arr.length == 1 ) //recursion base
            return;

        //T is abstract so can't be instantiated into an array of T to divide master list, so have used String for this implementation
        Object[] left = new String[ arr.length / 2 ];
        Object[] right = new String[ arr.length - ( arr.length / 2 ) ];

        //fill left subarray
        for ( int i = 0  ;  i < left.length  ;  i++ )
            left[i] = arr[i];

        //fill right, i indexes main array and j right, need different var as reversing through array
        for ( int i = arr.length - 1, j = 0  ;  j < right.length  ;  i--, j++ )
            right[j] = arr[i];

        //recursive call to split each array till they hold only one element
        sortComparatorArray( left, comp );
        sortComparatorArray( right, comp );

        int l = 0, r = 0, a = 0; //array indexes

        //iterate till one array has gone through all elements, the remaining won't be empty
        while ( l != left.length  &&  r != right.length )
        {
            if ( comp.compare( left, right ) < 0 ) //if the element in the left is smaller than the right
                arr[ a++ ] = left[ l++ ]; //add it to the master array
            else
                arr[ a++ ] = right[ r++ ]; //otherwise do the opposite for the right
        }

        //for the array that still holds values, whether it is left or right, add them to the master array
        while ( l != left.length )
            arr[ a++ ] = left[ l++ ];

        while ( r != right.length )
            arr[ a++ ] = right[ r++ ];
    }


    //Lists
    /**
     * This method implements a merge sort of a primitive list.
     * Functional for all primitive data types, however for demonstrative purposes have used int.
     */
    protected void sortPrimitiveList( List<Integer> list )
    {
        if ( list.size() == 1 ) //recursion base
            return;

        //sub-lists for master list
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        //as each item is removed from the left half of the master list it is put in the sublist
        for ( int i = 0  ;  i < ( list.size() / 2 )  ;  i++ )
            left.add( list.remove(i) );

        //NOTE - removing the items at their indexes at the same they are being added to other lists prevents
        //       the issue of the list pointing at an index whose value has changed as the loop iterates

        //remove remaining values in right half from master list and add to other sublist
        while ( list.size() != 0 )
            right.add( list.remove(0) );

        //recursive call to split each sublist till they hold only one element
        sortPrimitiveList( left );
        sortPrimitiveList( right );

        //iterate till one list has gone through all elements, the remaining won't be empty
        while ( left.size() != 0  &&  right.size() != 0 )
        {
            if ( left.get(0) < right.get(0) ) //if the element in the left is smaller than the right
                list.add( left.remove(0) ); //add it to the master list and remove it from the left list
            else
                list.add( right.remove(0) ); //otherwise do the opposite for the right
        }

        //for the list that still holds values, whether it is left or right, remove those values from the list while adding them to the master list
        while ( left.size() != 0 )
            list.add( left.remove(0) );

        while ( right.size() != 0 )
            list.add( right.remove(0) );
    }

    /**
     * This method implements a merge sort of a list using the compareTo() method of the Comparable interface.
     * Functional for any data type and any object with compareTo defined.
     * T is abstract so can't be instantiated for recursive purposes, so have used ArrayList for this implementation.
     */
    protected < T extends Comparable< ? super T > > void sortObjectList( List<T> list )
    {
        if ( list.size() == 1 ) //recursion base
            return;

        //sub-lists for master list
        ArrayList<T> left = new ArrayList<>();
        ArrayList<T> right = new ArrayList<>();

        //as each item is removed from the left half of the master list it is put in the sublist
        for ( int i = 0  ;  i < ( list.size() / 2 )  ;  i++ )
            left.add( list.remove(i) );

        //NOTE - removing the items at their indexes at the same they are being added to other lists prevents
        //       the issue of the list pointing at an index whose value has changed as the loop iterates

        //remove remaining values in right half from master list and add to other sublist
        while ( list.size() != 0 )
            right.add( list.remove(0) );

        //recursive call to split each sublist till they hold only one element
        sortObjectList(left);
        sortObjectList(right);

        //iterate till one list has gone through all elements, the remaining won't be empty
        while ( left.size() != 0  &&  right.size() != 0 )
        {
            if(  left.get(0).compareTo( right.get(0) ) < 0 ) //if the element in the left is smaller than the right
                list.add( left.remove(0) ); //add it to the master list and remove it from the left list
            else
                list.add( right.remove(0) ); //otherwise do the opposite for the right
        }

        //for the list that still holds values, whether it is left or right, remove those values from the list while adding them to the master list
        while ( left.size() != 0 )
            list.add( left.remove(0) );

        while ( right.size() != 0 )
            list.add( right.remove(0) );
    }

    /**
     * This method implements a merge sort of a list using the compare() method of the Comparator interface.
     * Functional for any object with a related class for comparison.
     * The param comp is for the Class implementing Comparator.
     * T is abstract so can't be instantiated for recursive purposes, so have used ArrayList for this implementation.
     */
    protected <T> void sortComparatorList( List<T> list, Comparator< ? super T > comp )
    {
        if ( list.size() == 1 ) //recursion base
            return;

        //sub-lists for master list
        ArrayList<T> left = new ArrayList<>();
        ArrayList<T> right = new ArrayList<>();

        //as each item is removed from the left half of the master list it is put in the sublist
        for ( int i = 0  ;  i < ( list.size() / 2 )  ;  i++ )
            left.add( list.remove(i) );

        //NOTE - removing the items at their indexes at the same they are being added to other lists prevents
        //       the issue of the list pointing at an index whose value has changed as the loop iterates

        //remove remaining values in right half from master list and add to other sublist
        while ( list.size() != 0 )
            right.add( list.remove(0) );

        //recursive call to split each sublist till they hold only one element
        sortComparatorList( left, comp );
        sortComparatorList( right, comp );

        //iterate till one list has gone through all elements, the remaining won't be empty
        while ( left.size() != 0  &&  right.size() != 0 )
        {
            if ( comp.compare( left.get(0), right.get(0) ) < 0 ) //if the element in the left is smaller than the right
                list.add( left.remove(0) ); //add it to the master list and remove it from the left list
            else
                list.add( right.remove(0) ); //otherwise do the opposite for the right
        }

        //for the list that still holds values, whether it is left or right, remove those values from the list while adding them to the master list
        while ( left.size() != 0 )
            list.add( left.remove(0) );

        while ( right.size() != 0 )
            list.add( right.remove(0) );
    }

}
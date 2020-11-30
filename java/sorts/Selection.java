package sorts;

import java.util.Comparator;
import java.util.List;

/**
 * Class that demonstrates various ways of implementing a selection sort for objects and primitive data types,
 * using lists or arrays.
 *
 * There are six methods. The first three show a selection sort for arrays of any primitive data type, objects using compareTo, then
 * objects using Comparator. The last three shows implementation for the same but for lists.
 *
 * @author LogicallySpeakingLaura
 * @version 2020.11.26
 */
class Selection
{

    /*
     * This is a type of selection sort (hence the name). It finds the smallest value in the unsorted portion,
     * moves it to left, then forgets about it. This is good for instances where there is limited memory. However, as it is
     * not very efficient, so best for smaller number of elements.
     *
     * Time complexity: O( n ^ 2 )
     */


    //Arrays
    /**
     * This method implements a selection sort of a primitive array.
     * Functional for all primitive data types, however for demonstrative purposes have used int.
     */
    protected void sortPrimitiveArray( int arr[] )
    {
        //set bounds of loops to check adjacent pairs
        for ( int i = 0  ;  i < arr.length - 1  ;  i++ )
        {
            //position of smallest element in the ArrayList
            int smallestIndex = i;

            for ( int j = i + 1 ;  j < arr.length  ;  j++ )
                //value at j is smaller than the current value at smallest index
                if ( arr[j] < arr[smallestIndex] )
                    //smallest index value now equals value at index of j
                    smallestIndex = j;

            int smallestElement = arr[smallestIndex]; //var for smallest value = value at next smallest element index of list
            arr[smallestIndex] = arr[i]; //index for smallest value equals value for index i
            arr[i] = smallestElement; //i now equals the smallest value or list, bigger value now swapped with next smallest value
        }
    }

    /**
     * This method implements a selection sort of an object array using the compareTo() method of the Comparable interface.
     * Functional for any object with compareTo defined. Can be used to sort Strings.
     */
    protected < T extends Comparable< ? super T > > void sortObjectArray( T arr[] )
    {
        //set bounds of loops to check adjacent pairs
        for ( int i = 0  ;  i < arr.length - 1  ;  i++ )
        {
            //position of smallest element in the ArrayList
            int smallestIndex = i;

            for ( int j = i + 1  ;  j < arr.length  ;  j++ )
                //value at j is smaller than the current value at smallest index
                if ( arr[j].compareTo( arr[smallestIndex] ) < 0 )
                    //smallest index value now equals value at index of j
                    smallestIndex = j;

            T smallestElement = arr[smallestIndex]; //var for smallest value = value at next smallest element index of list
            arr[smallestIndex] = arr[i]; //index for smallest value equals value for index i
            arr[i] = smallestElement; //i now equals the smallest value or list, bigger value now swapped with next smallest value
        }
    }

    /**
     * This method implements a selection sort of an array using the compare() method of the Comparator interface.
     * Functional for any object with a related class for comparison.
     * The param comp is for the Class implementing Comparator.
     */
    protected <T> void sortComparatorArray( T arr[], Comparator< ? super T > comp )
    {
        //set bounds of loops to check adjacent pairs
        for ( int i = 0  ;  i < arr.length - 1  ;  i++ )
        {
            //position of smallest element in the ArrayList
            int smallestIndex = i;

            for ( int j = i + 1  ;  j < arr.length  ;  j++ )
                //value at j is smaller than the current value at smallest index
                if ( comp.compare( arr[j], arr[smallestIndex] ) < 0 )
                    //smallest index value now equals value at index of j
                    smallestIndex = j;

            T smallestElement = arr[smallestIndex]; //var for smallest value = value at next smallest element index of list
            arr[smallestIndex] = arr[i]; //index for smallest value equals value for index i
            arr[i] = smallestElement; //i now equals the smallest value or list, bigger value now swapped with next smallest value
        }
    }


    //Lists
    /**
     * This method implements a selection sort of a primitive list.
     * Functional for all primitive data types, however for demonstrative purposes have used int.
     */
    protected void sortPrimitiveList( List<Integer> list )
    {
        //set bounds of loops to check adjacent pairs
        for ( int i = 0  ;  i < list.size() - 1  ;  i++ )
        {
            //position of smallest element in the ArrayList
            int smallestIndex = i;

            for ( int j = i + 1  ;  j < list.size()  ;  j++ )
                //value at j is smaller than the current value at smallest index
                if ( list.get(j) < list.get(smallestIndex) )
                    //smallest index value now equals value at index of j
                    smallestIndex = j;

            int smallestElement = list.get(smallestIndex); //var for smallest value = value at next smallest element index of list
            list.set( smallestIndex, list.get(i) ); //index for smallest value equals value for index i
            list.set( i, smallestElement ); //i now equals the smallest value or list, bigger value now swapped with next smallest value
        }
    }

    /**
     * This method implements a selection sort of a list using the compareTo() method of the Comparable interface.
     * Functional for any data type and any object with compareTo defined.
     */
    protected < T extends Comparable< ? super T > > void sortObjectList( List<T> list )
    {
        //set bounds of loops to check adjacent pairs
        for ( int i = 0  ;  i < list.size() - 1  ;  i++ )
        {
            //position of smallest element in the ArrayList
            int smallestIndex = i;

            for ( int j = i + 1  ;  j < list.size()  ;  j++ )
                //value at j is smaller than the current value at smallest index
                if ( list.get(j).compareTo( list.get(smallestIndex) ) < 0 )
                    //smallest index value now equals value at index of j
                    smallestIndex = j;

            T smallestElement = list.get(smallestIndex); //var for smallest value = value at next smallest element index of list
            list.set( smallestIndex, list.get(i) ); //index for smallest value equals value for index i
            list.set( i, smallestElement ); //i now equals the smallest value or list, bigger value now swapped with next smallest value
        }
    }

    /**
     * This method implements a selection sort of a list using the compare() method of the Comparator interface.
     * Functional for any object with a related class for comparison.
     * The param comp is for the Class implementing Comparator.
     */
    protected <T> void sortComparatorList( List<T> list, Comparator< ? super T > comp )
    {
        //set bounds of loops to check adjacent pairs
        for ( int i = 0  ;  i < list.size() - 1  ;  i++ )
        {
            //position of smallest element in the ArrayList
            int smallestIndex = i;

            for ( int j = i + 1  ;  j < list.size()  ;  j++ )
                //value at j is smaller than the current value at smallest index
                if (comp.compare( list.get(j), list.get(smallestIndex) ) < 0 )
                    //smallest index value now equals value at index of j
                    smallestIndex = j;

            T smallestElement = list.get(smallestIndex); //var for smallest value = value at next smallest element index of list
            list.set( smallestIndex, list.get(i) ); //index for smallest value equals value for index i
            list.set( i, smallestElement ); //i now equals the smallest value or list, bigger value now swapped with next smallest value
        }
    }

}
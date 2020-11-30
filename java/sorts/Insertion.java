package sorts;

import java.util.Comparator;
import java.util.List;

/**
 * Class that demonstrates various ways of implementing an insertion sort for objects and primitive data types,
 * using lists or arrays.
 *
 * There are six methods. The first three show an insertion sort for arrays of any primitive data type, objects using compareTo, then
 * objects using Comparator. The last three shows implementation for the same but for lists.
 *
 * @author LogicallySpeakingLaura
 * @version 2020.11.25
 */
class Insertion
{

    /*
     * This sort is a type of insertion sort (hence the name...). Split elements into sorted and unsorted sections. Pick element
     * from unsorted portion and insert it into correct place in sorted portion.
     *
     * Time complexity: O( n ^ 2 )
     */


    //Arrays
    /**
     * This method implements an insertion sort of a primitive array.
     * Functional for all primitive data types, however for demonstrative purposes have used int.
     */
    protected void sortPrimitiveArray( int arr[] )
    {
        for ( int i = 1  ;  i < arr.length  ;  i++ ) //start at index 1 in order to compare with 0/sorted portion
        {
            int key = arr[i]; //assign current element of outer loop to var

            for (  int j = i - 1  ;  j >= 0  ;  j-- ) //reverse through sorted portion of list, indexes bigger than j are in unsorted portion
            {
                if ( key < arr[j] ) //key is smaller than current sorted element, needs to be inserted
                {
                    arr[ j + 1 ] = arr[j]; //index right of j takes the bigger value/value of j

                    if ( j == 0 ) //if it is the beginning of the list, the first index takes the smallest value/key
                        arr[0] = key;
                }
                else //sorted element is smaller
                {
                    arr[ j + 1 ] = key; //index right of j takes the smaller value/key
                    break; //once key has been inserted or there are no more elements, exit inner loop to move along unsorted portion
                }
            }
        }
    }

    /**
     * This method implements an insertion sort of an object array using the compareTo() method of the Comparable interface.
     * Functional for any object with compareTo defined. Can be used to sort Strings.
     */
    protected < T extends Comparable< ? super T > > void sortObjectArray( T arr[] )
    {
        for ( int i = 1  ;  i < arr.length  ;  i++ ) //start at index 1 in order to compare with 0/sorted portion
        {
            T key = arr[i]; //assign current element of outer loop to var

            for (  int j = i - 1  ;  j >= 0  ;  j-- ) //reverse through sorted portion of list, indexes bigger than j are in unsorted portion
            {
                if ( arr[j].compareTo(key) > 0 ) //key is smaller than current sorted element, needs to be inserted
                {
                    arr[ j + 1 ] = arr[j]; //index right of j takes the bigger value/value of j

                    if ( j == 0 ) //if it is the beginning of the list, the first index takes the smallest value/key
                        arr[0] = key;
                }
                else //sorted element is smaller
                {
                    arr[ j + 1 ] = key; //index right of j takes the smaller value/key
                    break; //once key has been inserted or there are no more elements, exit inner loop to move along unsorted portion
                }
            }
        }
    }

    /**
     * This method implements an insertion sort of an array using the compare() method of the Comparator interface.
     * Functional for any object with a related class for comparison.
     * The param comp is for the Class implementing Comparator.
     */
    protected <T> void sortComparatorArray( T arr[], Comparator< ? super T > comp )
    {
        for ( int i = 1  ;  i < arr.length  ;  i++ ) //start at index 1 in order to compare with 0/sorted portion
        {
            T key = arr[i]; //assign current element of outer loop to var

            for (  int j = i - 1  ;  j >= 0  ;  j-- ) //reverse through sorted portion of list, indexes bigger than j are in unsorted portion
            {
                if ( comp.compare( arr[j], key ) > 0 ) //key is smaller than current sorted element, needs to be inserted
                {
                    arr[ j + 1 ] = arr[j]; //index right of j takes the bigger value/value of j

                    if ( j == 0 ) //if it is the beginning of the list, the first index takes the smallest value/key
                        arr[0] = key;
                }
                else //sorted element is smaller
                {
                    arr[ j + 1 ] = key; //index right of j takes the smaller value/key
                    break; //once key has been inserted or there are no more elements, exit inner loop to move along unsorted portion
                }
            }
        }
    }


    //Lists
    /**
     * This method implements an insertion sort of a primitive list.
     * Functional for all primitive data types, however for demonstrative purposes have used int.
     */
    protected void sortPrimitiveList( List<Integer> list )
    {
        for ( int i = 1  ;  i < list.size()  ;  i++ ) //start at index 1 in order to compare with 0/sorted portion
        {
            int key = list.get(i); //assign current element of outer loop to var

            for ( int j = i - 1  ;  j >= 0  ;  j-- ) //reverse through sorted portion of list, indexes bigger than j are in unsorted portion
            {
                if ( key < list.get(j) ) //key is smaller than current sorted element, needs to be inserted
                {
                    list.set( j + 1, list.get(j) ); //index right of j takes the bigger value/value of j

                    if ( j == 0 ) //if it is the beginning of the list, the first index takes the smallest value/key
                        list.set( 0, key);
                }
                else //sorted element is smaller
                {
                    list.set( j + 1, key ); //index right of j takes the smaller value/key
                    break; //once key has been inserted or there are no more elements, exit inner loop to move along unsorted portion
                }
            }
        }
    }

    /**
     * This method implements an insertion sort of a list using the compareTo() method of the Comparable interface.
     * Functional for any data type and any object with compareTo defined.
     */
    protected < T extends Comparable< ? super T > > void sortObjectList( List<T> list )
    {
        for ( int i = 1  ;  i < list.size()  ;  i++ ) //start at index 1 in order to compare with 0/sorted portion
        {
            T key = list.get(i); //assign current element of outer loop to var

            for ( int j = i - 1  ;  j >= 0  ;  j-- ) //reverse through sorted portion of list, indexes bigger than j are in unsorted portion
            {
                if ( list.get(j).compareTo(key) > 0 ) //key is smaller than current sorted element, needs to be inserted
                {
                    list.set( j + 1, list.get(j) ); //index right of j takes the bigger value/value of j

                    if ( j == 0 ) //if it is the beginning of the list, the first index takes the smallest value/key
                        list.set( 0, key);
                }
                else //sorted element is smaller
                {
                    list.set( j + 1, key ); //index right of j takes the smaller value/key
                    break; //once key has been inserted or there are no more elements, exit inner loop to move along unsorted portion
                }
            }
        }
    }

    /**
     * This method implements an insertion sort of a list using the compare() method of the Comparator interface.
     * Functional for any object with a related class for comparison.
     * The param comp is for the Class implementing Comparator.
     */
    protected <T> void sortComparatorList( List<T> list, Comparator< ? super T > comp )
    {
        for ( int i = 1  ;  i < list.size()  ;  i++ ) //start at index 1 in order to compare with 0/sorted portion
        {
            T key = list.get(i); //assign current element of outer loop to var

            for ( int j = i - 1  ;  j >= 0  ;  j-- ) //reverse through sorted portion of list, indexes bigger than j are in unsorted portion
            {
                if ( comp.compare( list.get(j), key ) > 0 ) //key is smaller than current sorted element, needs to be inserted
                {
                    list.set( j + 1, list.get(j) ); //index right of j takes the bigger value/value of j

                    if ( j == 0 ) //if it is the beginning of the list, the first index takes the smallest value/key
                        list.set( 0, key );
                }
                else //sorted element is smaller
                {
                    list.set( j + 1, key ); //index right of j takes the smaller value/key
                    break; //once key has been inserted or there are no more elements, exit inner loop to move along unsorted portion
                }
            }
        }
    }

}
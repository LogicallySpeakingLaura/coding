package sorts;

import java.util.Comparator;
import java.util.List;

/**
 * Class that demonstrates various ways of implementing a bubble sort for both objects and primitive data types,
 * using lists or arrays.
 *
 * There are six methods. The first show a bubble sort for arrays of any primitive data type, objects using compareTo, then
 * objects using Comparator. The last three shows implementation for the same but for lists.
 *
 * @author LogicallySpeakingLaura
 * @version 2020.11.23
 */
class Bubble
{

    /*
     * This sort is the simplest sorting algorithm and a type of exchange sort. Each pass checks adjacent elements,
     * if they are out of order, they are swapped. Algorithm is finished when a pass through elements is completed without
     * swapping. Best used for small errors.
     *
     * Average complexity: O( n ^ 2 )
     * Best complexity: O(n)
     */


    /**
     * This method implements a bubble sort of a primitive array.
     * Functional for all primitive data types, however for demonstrative purposes have used int.
     */
    protected void sortPrimitiveArray( int arr[] )
    {
        for ( int i = 0  ;  i < arr.length - 1  ;  i++ ) //set bounds so two elements can be compared
        {
            for ( int j = i + 1  ;  j < arr.length  ;  j++ )
            {
                if ( arr[i] > arr[j] ) //left element is bigger than right
                {
                    int temp = arr[i]; //assign left to a var so value not lost when swapping
                    arr[i] = arr[j]; //put right value in left index, left value gone from array but saved in temp
                    arr[j] = temp; //put temp/left value in right index
                }
            }
        }
    }


    /**
     * This method implements a bubble sort of an object array using the compareTo() method of the Comparable interface.
     * Functional for any object with compareTo defined. Can be used to sort Strings.
     */
    protected < T extends Comparable< ? super T > > void sortObjectArray( T arr[] )
    {
        for ( int i = 0  ;  i < arr.length - 1  ;  i++ ) //set bounds so two elements can be compared
        {
            for ( int j = i + 1  ;  j < arr.length  ;  j++ )
            {
                if ( arr[i].compareTo( arr[j] ) > 0 ) //left element is bigger than right
                {
                    T temp = arr[i]; //assign left to a var so value not lost when swapping
                    arr[i] = arr[j]; //put right value in left index, left value gone from array but saved in temp
                    arr[j] = temp; //put temp/left value in right index
                }
            }
        }
    }


    /**
     * This method implements a bubble sort of an array using the compare() method of the Comparator interface.
     * Functional for any object with a related class for comparison.
     * The param comp is for the Class implementing Comparator.
     */
    protected <T> void sortComparatorArray( T arr[], Comparator< ? super T > comp )
    {
        //TODO code...
    }


    /**
     * This method implements a bubble sort of a primitive list.
     * Functional for all primitive data types, however for demonstrative purposes have used int.
     */
    protected void sortPrimitiveList( List<Integer> list )
    {
        //TODO code...
    }


    /**
     * This method implements a bubble sort of a list using the compareTo() method of the Comparable interface.
     * Functional for any data type and any object with compareTo defined.
     */
    protected < T extends Comparable< ? super T > > void sortObjectList( List<T> list )
    {
        for ( int i = 0  ;  i < ( list.size() - 1 )  ;  i++ ) //set bounds so two elements can be compared
        {
            for( int j = i + 1  ;  j < list.size()  ;  j++ )
            {
                if ( list.get(i).compareTo( list.get(j) ) > 0 ) //left element is bigger than right
                {
                    T bigger = list.get(i);  //assign elements to variables
                    T smaller = list.get(j);

                    list.set( i, smaller ); //insert elements back into list in new index positions
                    list.set( j, bigger );
                }
            }
        }
    }


    /**
     * This method implements a bubble sort of a list using the compare() method of the Comparator interface.
     * Functional for any object with a related class for comparison.
     * The param comp is for the Class implementing Comparator.
     */
    protected <T> void sortComparatorList( List<T> list, Comparator< ? super T > comp )
    {
        for( int i = 0  ;  i < ( list.size() - 1 )  ;  i++ ) //set bounds so two elements can be compared
        {
            for( int j = i + 1  ;  j < list.size()  ;  j++ )
            {
                if( comp.compare( list.get(i), list.get(j) ) > 0 ) //left element is bigger than right
                {
                    T bigger = list.get(i); //assign elements to variables
                    T smaller = list.get(j);

                    list.set( i, smaller ); //insert elements back into list in new index positions
                    list.set( j, bigger );
                }
            }
        }
    }

//    public static void main( String[] args ) {
//        Bubble b = new Bubble();
//        String arr[] = { "Ajeet", "Steve", "Rick", "Becky", "Mohan"};
//        b.sortStrings(arr);
//        System.out.println("Sorted array");
//        printArray(arr);
//    }
//
//    private static void printArray( String arr[] )
//    {
//        int n = arr.length;
//        for (int i=0; i<n; ++i)
//            System.out.print(arr[i] + " ");
//        System.out.println();
//    }

}
package sorts;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Class that demonstrates various ways of implementing a quick sort for objects and primitive data types,
 * using lists or arrays.
 *
 * There are three inner classes with two methods each for arrays of any primitive data type, objects using compareTo, then objects using Comparator.
 * The last three methods independent of those inner classes shows implementation for the same but for lists.
 *
 * @author LogicallySpeakingLaura
 * @version 2020.11.29
 */
class Quick
{

    /*
     * This sort is a type of divide and conquer sort. Elements are grouped into 3: one is the chosen pivot, one is all elements
     * less than that pivot, one is all elements greater than the pivot. The groups that aren't the pivot are sorted independently.
     * Although it is one of the faster sorts, it is not necessarily stable.
     *
     * Best case time complexity: O( n log n )
     * Worst case time complexity: O( n ^ 2 )
     */


    //Arrays
    /**
     * This inner class implements the methods for a quick sort of a primitive array with the first element as a pivot.
     * Functional for all primitive data types, however for demonstrative purposes have used int.
     */
    protected static class SortPrimitiveArray
    {

        /**
         * This methods performs recursive sorting of the array. For the initial sort low is 0 for index 0, and high is arr.length - 1 for last index.
         * Two recursive sorts are done, one for smaller elements and another for larger.
         * The sort for the smaller takes index 0 to left of pivot to, larger is right of pivot to last index.
         */
        protected void sort( int arr[], int low, int high )
        {
            if ( low < high ) //if low >= high all sorting done
            {
                int pivot = partition( arr, low, high ); //assign returned value to pivot

                sort( arr, low, pivot - 1 ); //recursively sort smaller
                sort( arr, pivot + 1, high ); //recursively sort larger
            }
        }

        /**
         * This method separates array into elements smaller than or larger than the pivot. It returns the index of the new pivot
         * once swapping of elements is done.
         */
        protected int partition( int arr[], int left, int right )
        {
            //pos is index of pivot and tracks the repositioning
            int pos = left;

            //i is right of pivot, check up to and including end of unsorted portion, array bound accounted for in sort() with high
            for ( int i = left + 1  ;  i <= right  ;  i++ )
            {
                //pivot is bigger so swap elements, increment pos to keep track of pivot location
                if ( arr[i] < arr[left] )
                {
                    pos++;
                    int temp = arr[pos];
                    arr[pos] = arr[i];
                    arr[i] = temp;
                }
            }

            //perform another swap to place pivot at end of sorted portion
            int temp = arr[pos];
            arr[pos] = arr[left];
            arr[left] = temp;

            return pos;
        }

    }


    /**
     * This inner class implements a quick sort of an object array using the compareTo() method of the Comparable interface and with the first element as a pivot.
     * Functional for any object with compareTo defined.
     * T is abstract so can't be instantiated for recursive purposes, so have used String for this implementation.
     */
    protected static class SortObjectArray
    {

        /**
         * This methods performs recursive sorting of the array. For the initial sort low is 0 for index 0, and high is arr.length - 1 for last index.
         * Two recursive sorts are done, one for smaller elements and another for larger.
         * The sort for the smaller takes index 0 to left of pivot to, larger is right of pivot to last index.
         */
        protected void sort( String arr[], int low, int high )
        {
            if ( low < high ) //if low >= high all sorting done
            {
                int pivot = partition( arr, low, high ); //assign returned value to pivot

                sort( arr, low, pivot - 1 ); //recursively sort smaller
                sort( arr, pivot + 1, high ); //recursively sort larger
            }
        }

        /**
         * This method separates array into elements smaller than or larger than the pivot. It returns the index of the new pivot
         * once swapping of elements is done.
         */
        protected int partition( String arr[], int left, int right )
        {
            //pos is index of pivot and tracks the repositioning
            int pos = left;

            //i is right of pivot, check up to and including end of unsorted portion, array bound accounted for in sort() with high
            for ( int i = left + 1  ;  i <= right  ;  i++ )
            {
                //pivot is bigger so swap elements, increment pos to keep track of pivot location
                if ( arr[i].compareTo( arr[left] ) < 0 )
                {
                    pos++;
                    String temp = arr[pos];
                    arr[pos] = arr[i];
                    arr[i] = temp;
                }
            }

            //perform another swap to place pivot at end of sorted portion
            String temp = arr[pos];
            arr[pos] = arr[left];
            arr[left] = temp;

            return pos;
        }

    }

    /**
     * This method implements a merge sort of an array using the compare() method of the Comparator interface and with the first element as a pivot.
     * Functional for any object with a related class for comparison.
     * The param comp is for the Class implementing Comparator.
     * T is abstract so can't be instantiated for recursive purposes, so have used Object for this implementation.
     */
    protected static class SortComparatorArray
    {

        /**
         * This methods performs recursive sorting of the array. For the initial sort low is 0 for index 0, and high is arr.length - 1 for last index.
         * Two recursive sorts are done, one for smaller elements and another for larger.
         * The sort for the smaller takes index 0 to left of pivot to, larger is right of pivot to last index.
         */
        protected void sort( Object arr[], int low, int high, Comparator< ? super Object > comp )
        {
            if ( low < high ) //if low >= high all sorting done
            {
                int pivot = partition( arr, low, high, comp ); //assign returned value to pivot

                sort( arr, low, pivot - 1, comp ); //recursively sort smaller
                sort( arr, pivot + 1, high, comp ); //recursively sort larger
            }
        }

        /**
         * This method separates array into elements smaller than or larger than the pivot. It returns the index of the new pivot
         * once swapping of elements is done.
         */
        protected int partition( Object arr[], int left, int right, Comparator< ? super Object > comp )
        {
            //pos is index of pivot and tracks the repositioning
            int pos = left;

            //i is right of pivot, check up to and including end of unsorted portion, array bound accounted for in sort() with high
            for ( int i = left + 1  ;  i <= right  ;  i++ )
            {
                //pivot is bigger so swap elements, increment pos to keep track of pivot location
                if ( comp.compare( arr[i], arr[left] ) < 0 )
                {
                    pos++;
                    Object temp = arr[pos];
                    arr[pos] = arr[i];
                    arr[i] = temp;
                }
            }

            //perform another swap to place pivot at end of sorted portion
            Object temp = arr[pos];
            arr[pos] = arr[left];
            arr[left] = temp;

            return pos;
        }

    }


    //Lists
    /**
     * This method implements a quick sort of a primitive list with the first element as a pivot.
     * Functional for all primitive data types, however for demonstrative purposes have used int.
     */
    protected List<Integer> sortPrimitiveList( List<Integer> list )
    {
        if ( list.isEmpty() ) //recursion stopping case
            return list;

        //sub-lists for values smaller and larger than pivot
        ArrayList<Integer> smaller = new ArrayList<>();
        ArrayList<Integer> bigger = new ArrayList<>();

        //starts at 1 as pivot is 0, no need to check it against itself
        for ( int i = 1  ;  i < list.size()  ;  i++ )
        {
            //put elements smaller than pivot into smaller sublist, opposite for larger
            if ( list.get(i).compareTo( list.get(0) ) < 0 )
                smaller.add( list.get(i) );
            else
                bigger.add( list.get(i) );
        }

        //recursively sort elements into appropriate sub-list
        smaller = (ArrayList<Integer>) sortPrimitiveList(smaller);
        bigger = (ArrayList<Integer>) sortPrimitiveList(bigger);

        //pivot is now biggest value for smaller ArrayList, add it to the end
        smaller.add( list.get(0) );

        //clear master list and add sorted elements back in order
        list.clear();
        list.addAll(smaller);
        list.addAll(bigger);

        return list;
    }

    /**
     * This method implements a quick sort of a list using the compareTo() method of the Comparable interface with the first element as a pivot.
     * Functional for any data type and any object with compareTo defined.
     * T is abstract so can't be instantiated for recursive purposes, so have used ArrayList for this implementation.
     */
    protected < T extends Comparable< ? super T > > List<T> sortObjectList( List<T> list )
    {
        if ( list.isEmpty() ) //recursion stopping case
            return list;

        //sub-lists for values smaller and larger than pivot
        ArrayList<T> smaller = new ArrayList<>();
        ArrayList<T> bigger = new ArrayList<>();

        //starts at 1 as pivot is 0, no need to check it against itself
        for ( int i = 1  ;  i < list.size()  ;  i++ )
        {
            //put elements smaller than pivot into smaller sublist, opposite for larger
            if ( list.get(i).compareTo( list.get(0) ) < 0 )
                smaller.add( list.get(i) );
            else
                bigger.add( list.get(i) );
        }

        //recursively sort elements into appropriate sub-list
        smaller = (ArrayList<T>) sortObjectList(smaller);
        bigger = (ArrayList<T>) sortObjectList(bigger);

        //pivot is now biggest value for smaller ArrayList, add it to the end
        smaller.add( list.get(0) );

        //clear master list and add sorted elements back in order
        list.clear();
        list.addAll(smaller);
        list.addAll(bigger);

        return list;
    }

    /**
     * This method implements a quick sort of a list using the compare() method of the Comparator interface with the first element as a pivot.
     * Functional for any object with a related class for comparison.
     * The param comp is for the Class implementing Comparator.
     * T is abstract so can't be instantiated for recursive purposes, so have used ArrayList for this implementation.
     */
    protected <T>List<T> sortComparatorList( List<T> list, Comparator< ? super T > comp )
    {
        if ( list.isEmpty() ) //recursion stopping case
            return list;

        //sub-lists for values smaller and larger than pivot
        ArrayList<T> smaller = new ArrayList<>();
        ArrayList<T> bigger = new ArrayList<>();

        //starts at 1 as pivot is 0, no need to check it against itself
        for ( int i = 1  ;  i < list.size()  ;  i++ )
        {
            //put elements smaller than pivot into smaller sublist, opposite for larger
            if ( comp.compare( list.get(i), list.get(0) ) < 0 )
                smaller.add( list.get(i) );
            else
                bigger.add( list.get(i) );
        }

        //recursively sort elements into appropriate sub-list
        smaller = (ArrayList<T>) sortComparatorList( smaller, comp );
        bigger = (ArrayList<T>) sortComparatorList( bigger, comp );

        //pivot is now biggest value for smaller ArrayList, add it to the end
        smaller.add( list.get(0) );

        //clear master list and add sorted elements back in order
        list.clear();
        list.addAll(smaller);
        list.addAll(bigger);

        return list;
    }

}
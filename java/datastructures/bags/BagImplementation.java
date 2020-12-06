package datastructures.bags;

import java.util.Arrays;

/**
 * Class for the implementation of an abstract Bag data type using an array.
 * Refer: F. M. Carrano and T. Henry, Data structures and abstractions with Java. Boston: Pearson Education, Inc., 2019.
 *
 * @param <T> Infer generics.
 *
 * @author LogicallySpeakingLaura
 * @version 2020.12.05
 * @see BagADT
 */
class BagImplementation<T> implements BagADT<T>
{

    /*
     * A bag can be considered as a collection/container of objects of the same data type. However, as 'collection' and
     * 'container' have their own meaning in Java, bag is used instead. Like an array there is a set size. Duplicates are
     * allowed. Items are stored in no particular order.
     */


    //Attributes
    private T[] bag;
    private int itemCount;
    private boolean hasIntegrity;
    private static final int DEFAULT_SIZE = 50;
    private static final int MAX_SIZE = 10000;


    //Constructors
    /**
     * Default constructor creates a new bag of the default size.
     */
    protected BagImplementation()
    {
        this( DEFAULT_SIZE );
    }

    /**
     * Constructor to create a new bag of the passed size if allowed.
     *
     * @param wantedSize Desired number of items the bag can hold as an int.
     */
    protected BagImplementation( int wantedSize )
    {
        hasIntegrity = false;

        //make sure desired size doesn't exceed max size allowed
        checkSize(wantedSize);

        //have to cast object array to T as cannot instantiate generics,
        //as a new array contains null indexes cast is safe
        @SuppressWarnings( "unchecked" )
        T[] temp = (T[]) new Object[wantedSize];
        bag = temp;
        itemCount = 0;
        hasIntegrity = true;
    }


    //Helper Methods
    /**
     * Method to determine if the bag is corrupted due to its size.
     */
    void checkCorrupted()
    {
        //integrity lost when bag exceeds max size
        if ( !hasIntegrity )
            throw new SecurityException( "Bag corrupted." );
    }

    /**
     * Method to determine if the bag has space available.
     *
     * @return True if array is not full otherwise false.
     */
    boolean hasRoom()
    {
        return itemCount < bag.length;
    }

    /**
     * Method to check that size of bag does not exceed maximum size allowed.
     *
     * @param size Int representing size of bag.
     */
    void checkSize( int size )
    {
        if ( size > MAX_SIZE )
            throw new IllegalStateException( "Cannot exceed maximum bag size" );
    }

    /**
     * Method to increase the size of the bag.
     */
   void resize()
   {
        int newSize = 2 * bag.length;

        //make sure resizing doesn't corrupt bag
        checkSize(newSize);

        //copy current bag items to new bigger bag
        bag = Arrays.copyOf( bag, newSize );
   }

    /**
     * Method to the item at the given position in the bag.
     *
     * @param index Location of item to be removed.
     * @return The removed item if it is removed successfully otherwise null.
     */
    T removeItem( int index )
    {
        T removedItem = null;

        //bag can't be empty and the index has to be valid
        if ( !isEmpty()  &&  index >= 0 )
        {
            removedItem = bag[index];
            bag[index] = bag[ itemCount - 1 ];
            bag[ itemCount-- ] = null; //decrement to track new item total
        }

        return removedItem;
    }

    /**
     * Method to find the index of a specific element in the bag.
     *
     * @param element The element for which an index is to be found.
     * @return The index of the passed element as an int if found otherwise -1.
     */
    int getIndexOf( T element )
    {
        //set as a flag, -1 out of bounds
        int pos = -1;

        //run against items in bag not size of bag so not checking nulls
        for ( int i = 0  ;  i < itemCount  ;  i++ )
            if ( element.equals( bag[i] ) )
            {
                pos = i;
                break;
            }

        return pos;
    }


    //Inherited Methods
    /**
     * {@inheritDoc}
     */
    @Override
    public int getSize()
    {
        return itemCount;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty()
    {
        return itemCount == 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add( T element )
    {
        checkCorrupted();

        //make sure new item doesn't go out of bounds
        if ( !hasRoom() )
            resize();

        //increment count to keep track of item count
        bag[ itemCount++ ] = element;

        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T remove()
    {
        checkCorrupted();

        //as remove simply removes last index item, can call removeItem()
        T removedItem = removeItem( itemCount - 1 );

        return removedItem;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove( T element )
    {
        checkCorrupted();

        //need index of element to know where to remove
        int pos = getIndexOf(element);
        T removedItem = removeItem(pos);

        //will only return true if element at pos matches one passed
        return element.equals(removedItem);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear()
    {
        //keep calling remove() till each index is null and numItems is 0
        while ( !isEmpty() )
            remove();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCount( T element )
    {
        checkCorrupted();

        int count = 0;

        //don't want to run against the bag length, just indexes with value, no need to check against null
        for ( int i = 0  ;  i < itemCount  ;  i++ )
            if ( element.equals( bag[i] ) )
                count++;

        return count;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains( T element )
    {
        checkCorrupted();

        //if element found at index 0 or above it exists in bag
        return getIndexOf(element) > -1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T[] toArray()
    {
        checkCorrupted();

        //have to cast object array to T as cannot instantiate generics,
        //as a new array contains null indexes cast is safe
        @SuppressWarnings( "unchecked" )
        T[] arr = (T[]) new Object[itemCount];

        //returned array is only as big as current number of elements, not the size of the bag
        for ( int i = 0  ;  i < arr.length  ;  i++ )
            arr[i] = bag[i];

        return arr;
    }

}
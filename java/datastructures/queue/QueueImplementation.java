package datastructures.queue;

import java.util.NoSuchElementException;

/**
 * Class for the implementation of an abstract Queue data type using a circular array.
 * Refer: F. M. Carrano and T. Henry, Data structures and abstractions with Java. Boston: Pearson Education, Inc., 2019.
 *
 * @param <T> Infer generics.
 *
 * @author LogicallySpeakingLaura
 * @version 2020.12.05
 * @see QueueADT
 */
public class QueueImplementation<T> implements QueueADT<T>
{

    /*
     * A queue is a 'First In First Out (FIFO)' data type. The oldest entry is the first to be removed or accessed.
     * Access to items is restricted. In order to see an entry not at the front of the queue, every entry before it
     * would have to be removed in chronological order. This data type is useful when resolving algebraic expressions,
     * particularly Infix to Postfix. It does not have a set size and grows as needed with its entries.
     */


    //Attributes
    private T[] queue;
    private int frontIndex;
    private int backIndex;
    private boolean hasIntegrity;
    private static final int DEFAULT_SIZE = 50;
    private static final int MAX_SIZE = 10000;


    //Constructors
    /**
     * Default constructor creates a new queue of the default size.
     */
    protected QueueImplementation()
    {
        this( DEFAULT_SIZE );
    }

    /**
     * Constructor to create a new queue of the passed size if allowed.
     *
     * @param wantedSize Desired number of items the queue can hold as an int.
     */
    protected QueueImplementation( int wantedSize )
    {
        hasIntegrity = false;

        //make sure desired size doesn't exceed max size allowed
        checkSize(wantedSize);

        //have to cast object array to T as cannot instantiate generics,
        //as a new array contains null indexes cast is safe
        @SuppressWarnings( "unchecked" )
        T[] temp = (T[]) new Object[ wantedSize + 1 ];
        queue = temp;
        frontIndex = 0;
        backIndex = wantedSize;
        hasIntegrity = true;
    }


    //Helper Methods
    /**
     * Method to determine if the queue is corrupted due to its size.
     */
    void checkCorrupted()
    {
        //integrity lost when queue exceeds max size
        if ( !hasIntegrity )
            throw new SecurityException( "Queue corrupted." );
    }

    /**
     * Method to check that size of queue does not exceed maximum size allowed.
     *
     * @param size Int representing size of queue.
     */
    void checkSize( int size )
    {
        if ( size > MAX_SIZE )
            throw new IllegalStateException( "Cannot exceed maximum queue size" );
    }

    /**
     * Method to determine if the queue has space available.
     *
     * @return True if array is not full otherwise false.
     */
    void makeRoom()
    {
        //resize array if necessary
        if ( frontIndex == ( backIndex + 2 ) % queue.length )
        {
            //put current items in temp queue
            T[] oldQueue = queue;
            int newSize = 2 * oldQueue.length;
            hasIntegrity = false;

            checkSize( newSize - 1 );

            //create new queue of increased size
            @SuppressWarnings( "unchecked" )
            T[] newQueue = (T[]) new Object[newSize];
            queue = newQueue;

            //fill resized queue with items
            for ( int i = 0  ;  i < oldQueue.length - 1  ;  i++ )
            {
                queue[i] = oldQueue[frontIndex];
                frontIndex = ( frontIndex + 1 ) % oldQueue.length;
            }

            //reset indexes
            frontIndex = 0;
            backIndex = oldQueue.length - 2;
            hasIntegrity = true;
        }
    }


    //Inherited Methods
    /**
     * {@inheritDoc}
     */
    @Override
    public void enqueue( T element )
    {
        checkCorrupted();
        makeRoom();

        backIndex = ( backIndex + 1 ) % queue.length;
        queue[backIndex] = element;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T dequeue()
    {
        checkCorrupted();

        if ( isEmpty() )
            throw new NoSuchElementException();

        T front = queue[frontIndex];
        queue[frontIndex] = null;
        frontIndex = ( frontIndex + 1 ) % queue.length;

        return front;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T getfront()
    {
        checkCorrupted();

        if ( isEmpty() )
            throw new NoSuchElementException();

        return queue[frontIndex];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty()
    {
        return frontIndex == ( backIndex + 1 ) % queue.length;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear()
    {
        while ( !isEmpty() )
            dequeue();
    }

}
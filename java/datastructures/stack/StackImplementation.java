package datastructures.stack;

import java.util.EmptyStackException;
import java.util.Vector;

/**
 * Class for the implementation of an abstract Stack data type using a vector.
 * Refer: F. M. Carrano and T. Henry, Data structures and abstractions with Java. Boston: Pearson Education, Inc., 2019.
 *
 * @param <T> Infer generics.
 *
 * @author LogicallySpeakingLaura
 * @version 2020.12.05
 * @see StackADT
 */
public class StackImplementation<T> implements StackADT<T>
{

    /*
     * A stack is a 'Last In First Out (LIFO)' data type. The most recent entry is the first to be removed or accessed.
     * Access to items is restricted. In order to see the oldest entry, every entry would have to be removed in
     * reverse chronological order. This data type is useful when resolving algebraic expressions, particularly
     * Infix to Postfix. It does not have a set size and grows as needed with its entries.
     */


    //Attributes
    private Vector<T> stack; //last item = stack top
    private boolean hasIntegrity;
    private static final int DEFAULT_SIZE = 50;
    private static final int MAX_SIZE = 10000;


    //Constructors
    protected StackImplementation()
    {
        this(DEFAULT_SIZE);
    }

    protected StackImplementation( int wantedSize )
    {
        hasIntegrity = false;

        //make sure desired size doesn't exceed max size allowed
        checkSize(wantedSize);

        //vector will resize as necessary
        stack = new Vector<>(wantedSize);
        hasIntegrity = true;
    }


    //Helper Methods
    /**
     * Method to determine if the bag is corrupted due to its size.
     */
    void checkCorrupted()
    {
        //integrity lost when stack exceeds max size
        if ( !hasIntegrity )
            throw new SecurityException( "Stack corrupted." );
    }

    /**
     * Method to check that size of bag does not exceed maximum size allowed.
     *
     * @param size Int representing size of bag.
     */
    void checkSize( int size )
    {
        if ( size > MAX_SIZE )
            throw new IllegalStateException( "Cannot exceed maximum stack size" );
    }


    //Inherited Methods
    /**
     * {@inheritDoc}
     */
    @Override
    public void push( T element )
    {
        checkCorrupted();

        //vector method facilitates action
        stack.add(element);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T pop()
    {
        checkCorrupted();

        //cannot remove item from an empty stack
        if ( isEmpty() )
            throw new EmptyStackException();

        //vector method facilitates action, -1 for indexing
        return stack.remove( stack.size() - 1 );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T peek()
    {
        checkCorrupted();

        //cannot remove item from an empty stack
        if ( isEmpty() )
            throw new EmptyStackException();

        //vector method facilitates action
        return stack.lastElement();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty()
    {
        checkCorrupted();

        //vector method facilitates action
        return stack.isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear()
    {
        checkCorrupted();
        //vector method facilitates action
        stack.clear();
    }

}
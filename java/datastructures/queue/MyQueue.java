package utilities;

import exceptions.EmptyQueueException;

/**
 * Class that implements a Queue interface using a DLL has the data structure.
 * Some theory on implementation taken from 'Data Structures and Abstractions with Java' by F.M. Carrano
 * and T. Henry.
 * @author 776298
 *
 * @param <E> - infer generics
 */
public class MyQueue<E> implements QueueADT<E>
{
	
 /*******************************************INIT*******************************************/
	
	//Attributes
	private MyDLL<E> list;
	private int capacity;
	
	//Constant
	private static final long serialVersionUID = 123456789L;
		
	//Constructor
	/**
	 * Default constructor
	 */
	public MyQueue() 
	{
		this.list = new MyDLL<E>();
	}
	
	/**
	 * Constructor that allows user to set a list capacity.
	 * @param capacity - int of number of elements queue can hold.
	 */
	public MyQueue(int capacity) 
	{
		this.list = new MyDLL<E>();
		this.capacity = capacity;
	}
	
 /*************************************IHERITED METHODS************************************/	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void enqueue(E toAdd) 
			throws NullPointerException 
	{
		list.add(toAdd); //append
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E dequeue() 
			throws EmptyQueueException 
	{
		if( list.size() == 0 )
			throw new EmptyQueueException( "EmptyQueueException" );
		
		E removedElement = list.get(0);
		list.remove(0); //remove first element
		
		return removedElement;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E peek() 
			throws EmptyQueueException 
	{
		if( list.size() == 0 )
			throw new EmptyQueueException( "EmptyQueueException" );
		
		return list.get(0); //look at first element
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dequeueAll() 
	{
		list.clear();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() 
	{
		return list.isEmpty();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterator<E> iterator() 
	{
		return list.iterator();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(QueueADT<E> that) 
	{
		boolean queuesMatch = false;
		
		if( list.size() == that.size() )
		{
			Object[] thisQueue = list.toArray();
			Object[] thatQueue = that.toArray();
			
			for( int i = 0 ; i < list.size() ; i++ )
			{
				if( !thisQueue[i].equals( thatQueue[i] ) ) //as soon as two don't match leave loop
				{
					queuesMatch = false;
					break;
				}
				else
					queuesMatch = true;
			}
		}
		
		return queuesMatch;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object[] toArray() 
	{
		return list.toArray();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E[] toArray(E[] holder) 
			throws NullPointerException 
	{
		return list.toArray(holder);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isFull() 
	{
		return ( list.size() == capacity );
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() 
	{
		return list.size();
	}
}

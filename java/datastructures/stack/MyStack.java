package utilities;

import java.lang.reflect.Array;
import java.util.EmptyStackException;

/**
 * Class that implements a Stack interface using an ArrayList has the data structure.
 * Some theory on implementation taken from 'Data Structures and Abstractions with Java' by F.M. Carrano
 * and T. Henry.
 * @author 776298
 *
 * @param <E> - infer generics
 */
public class MyStack<E> implements StackADT<E>
{
	
 /*******************************************INIT*******************************************/
	
	//Attributes
	MyArrayList<E> list;
	
	//Constant
	private static final long serialVersionUID = 123456789L;
	
	//Constructor
	/**
	 * Default constructor. Stack data to be held in an object of MyArrayList.
	 */
	public MyStack()
	{
		this.list = new MyArrayList<E>();
	}
	
 /*************************************IHERITED METHODS************************************/	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void push(E toAdd) 
			throws NullPointerException 
	{
		if( toAdd == null )
			throw new NullPointerException();
		
		list.add(toAdd); //append
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E pop() 
			throws EmptyStackException 
	{
		if( isEmpty() )
			throw new EmptyStackException();
		
		E topElement = list.get( list.size() - 1 );
		list.remove( list.size() - 1 ); //remove last element
		
		return topElement;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E peek() 
			throws EmptyStackException 
	{
		if( isEmpty() )
			throw new EmptyStackException();
		
		return list.get( list.size() - 1 ); //look at last element
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void clear() 
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
	public Object[] toArray() //top of stack is first item, top down, reverse order
	{
		Object[] toReturn = new Object[ list.size() ];
		int returnIndex = 0;
		
		for( int i = ( list.size() - 1 ) ; i >= 0 ; i-- )
			toReturn[ returnIndex++ ] = list.get(i);
		
		return toReturn;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(E[] holder) 
			throws NullPointerException 
	{	
		if( holder == null )
			throw new NullPointerException();
		
		if( holder.length < list.size() )
			holder = ( E[] ) Array.newInstance( holder.getClass().getComponentType(), list.size() );
		
		int returnIndex = 0;
		for( int i = ( list.size() - 1 ) ; i >= 0 ; i-- )
			holder[ returnIndex++ ] = list.get(i);
		
		return holder;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean contains(E toFind) 
			throws NullPointerException 
	{
		return list.contains(toFind);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int search(E toFind) 
	{
		int distanceFromTop = -1;
		
		if( list.contains(toFind) )
		{
			if( list.get( list.size() - 1 ).equals(toFind) ) //matches top
				distanceFromTop = 1;
			else if( list.get(0).equals(toFind) ) //matches bottom
				distanceFromTop = list.size();
			else
			{
				int j = 1;
				for( int i = list.size() - 2 ; i > 0 ; i++ )
				{
					if( list.get(i).equals(toFind) ) //find somewhere in middle
					{
						distanceFromTop = j;
						break;
					}
					
					j++;
				}
			}
		}
		
		return distanceFromTop;
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
	public boolean equals(StackADT<E> that) 
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
	public int size() 
	{
		return list.size();
	}
}

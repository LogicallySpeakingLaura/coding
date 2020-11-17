package utilities;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

/**
 * Class that implements a ListADT interface in order to create an ArrayList type
 * data structure.
 * Some theory on implementation taken from 'Data Structures and Abstractions with Java' by F.M. Carrano
 * and T. Henry.
 * @author 776298
 *
 * @param <E> - infer generics
 */
public class MyArrayList<E> implements ListADT<E>
{
	
 /*******************************************INIT*******************************************/	
	
	//Attributes
	private E[] array;
	private int size;
	
	//Constant
	private static final long serialVersionUID = 123456789L;
	private static final int DEFAULT_ARRAY_SIZE = 10;
	
	//Constructors
	/**
	 * Default constructor. Creates an array with a default capacity.
	 */
	@SuppressWarnings("unchecked")
	public MyArrayList() 
	{
		this.array = ( E[] ) new Object[ DEFAULT_ARRAY_SIZE ];
		this.size = 0;
	}
	
	/**
	 * Constructor. Creates an array with a user specified capacity.
	 * @param listSize
	 */
	@SuppressWarnings("unchecked")
	public MyArrayList( int listSize )
	{
		this.array = ( E[] ) new Object[ listSize ];
		this.size = 0;
	}
	
	//Private utility
	/**
	 * This method checks to make sure that each time an element is added to the array,
	 * there is enough capacity to add more elements. If there is not, all elements
	 * are copied to a new array with an incremented capacity.
	 */
	@SuppressWarnings("unchecked")
	private void makeRoom()
	{		
		if( size >= ( array.length - 1 ) )
		{
			E[] oldCapacity = array; //copy current array to a temporary one
			array = ( E[] ) new Object[ size + 1 ]; //override array with an incremented capacity
			array = oldCapacity; //put array values back in
		}
	}

 /*************************************IHERITED METHODS************************************/	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() 
	{
		return size;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void clear() 
	{
		size = 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean add(int index, E toAdd) 
			throws NullPointerException 
	{
		if( toAdd == null )
			throw new NullPointerException();
		
		boolean addSuccess = false;
		
		if( index == size ) //if index is the size then it is an append
			add(toAdd);
		else
		{
			for( int i = ( size - 1 ) ; i >= index ; i-- ) //shift right
				array[ i + 1 ] = array [i];
			
			array[index] = toAdd; //set value
		}
		
		addSuccess = true;
		size++;
		makeRoom();
		
		return addSuccess;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean add(E toAdd) 
			throws NullPointerException 
	{
		if( toAdd == null )
			throw new NullPointerException();
		
		boolean addSuccess = false;

		array[ size ] = toAdd; //size equals last element + 1, so is next to be filled
		addSuccess = true;
		size++;
		makeRoom();
		
		return addSuccess;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addAll(ListADT<? extends E> toAdd) 
			throws NullPointerException 
	{
		if( toAdd == null )
			throw new NullPointerException();
		
		boolean addSuccess = false;
		
		for( int i = 0 ; i < toAdd.size() ; i++ ) //append each array value in order
			add( toAdd.get(i) ); 
		addSuccess = true;
		
		return addSuccess;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public E get(int index) 
			throws IndexOutOfBoundsException 
	{
		if( index < 0 || index > ( size - 1 ) ) 
			throw new IndexOutOfBoundsException();
		
		E element = array[index];
		
		return element;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E remove(int index) 
			throws IndexOutOfBoundsException 
	{
		if( index < 0 || index > ( size - 1 ) ) 
			throw new IndexOutOfBoundsException();
		
		E element = array[index];
		
		for( int i = index ; i < size ; i++ ) //shift values left
			array[i] = array[ i + 1 ];
		size--;
		
		return element;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E remove(E toRemove) 
			throws NullPointerException 
	{
		if( toRemove == null || !contains(toRemove) )
			throw new NullPointerException();
		
		E element = toRemove;
		int removeIndex = -1;
		
		for( int i = 0 ; i < size ; i++ )
		{
			if( toRemove.equals( array[i] ) ) //leave loop once first instance found
			{
				removeIndex = i;
				break;
			}
		}
		
		remove(removeIndex); //remove from index containing parameter
		size--;
		
		return element;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E set(int index, E toChange) 
			throws NullPointerException, IndexOutOfBoundsException
	{
		if( index < 0 || index > ( size - 1) )
			throw new IndexOutOfBoundsException();
		
		if( toChange == null )
			throw new NullPointerException();
		
		E element = array[index];
		array[index] = toChange;
		
		return element;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() 
	{
		return ( size == 0 );
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean contains(E toFind) 
			throws NullPointerException 
	{
		if( toFind == null )
			throw new NullPointerException();
		
		boolean findSuccess = false;
		
		for( int i = 0 ; i < size ; i++ )
		{
			if( toFind.equals( array[i] ) ) //leave once first instance found
			{
				findSuccess = true;
				break;
			}
		}
		
		return findSuccess;
	}

	/**
	 * {@inheritDoc}
	 * Code citation - this code was taken, with permission from instructor (Moussavi), from Dwatson 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(E[] toHold) 
			throws NullPointerException 
	{
		if( toHold == null )
			throw new NullPointerException();
		
		if( toHold.length < this.size )
			toHold = ( E[] ) Array.newInstance( toHold.getClass().getComponentType(), size );
		
		for( int i = 0 ; i < this.size ; i++ )
			toHold[i] = (E) this.array[i];
		
		return toHold;
	}
	
	/**
	 * {@inheritDoc}
	 * Code citation - this code was taken, with author's permission from Moussavi.
	 */
	@Override
	public Object[] toArray() 
	{
		Object[] toReturn = new Object[size];
		
		for( int i = 0 ; i < size ; i++ )
			toReturn[i] = array[i];
		
		return toReturn;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterator<E> iterator() 
	{
		return new ArrayBasedIterator();
	}
	
 /***************************************INNER CLASS***************************************/
	
	/**
	 * This inner class utilizes an mono-directional iterator to move from the beginning
	 * to the end of an array. It steps through a copy of the array elements.
	 * @author Dwatson
	 */
	private class ArrayBasedIterator implements Iterator<E>
	{
		//Attributes
		private E[] copyOfElements;
		private int pos;
		
		//Constructor
		/**
		 * Default constructor.
		 * Creates a new array that contains a copy of all elements from the array that the iterator will
		 * be used for.
		 * Code citation - this code was taken, with permission from instructor (Moussavi), from Dwatson
		 */
		@SuppressWarnings("unchecked")
		public ArrayBasedIterator()
		{
			copyOfElements = ( E[] ) new Object[ size() ];
			System.arraycopy(array, 0, copyOfElements, 0, copyOfElements.length);
		}

		//Inherited methods
		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean hasNext() 
		{
			return pos < copyOfElements.length;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public E next() 
		{
			try
			{
				E toReturn = copyOfElements[pos];
				pos++;
				
				return toReturn;
			}
			catch(IndexOutOfBoundsException e)
			{
				throw new NoSuchElementException();
			}
		}
	}
}


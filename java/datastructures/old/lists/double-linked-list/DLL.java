package utilities;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

import datastructures.old.Iterator;

/**
 * Class that implements a List interface as a DLL.
 * Theory and code taken from 'Data Structures and Abstractions with Java' by F.M. Carrano
 * and T. Henry as well as in-class examples from Khosro Salmani during CPRG251.
 * @author 776298
 *
 * @param <E>
 */
public class DLL<E> implements ListADT<E>
{
	
/*******************************************INIT*******************************************/	

	//Attributes
	private DLLNode<E> head;
	private DLLNode<E> tail;
	private int size;
	
	//Constant
	private static final long serialVersionUID = 123456789L;

	//Constructor
	/**
	 * Default constructor.
	 */
	public DLL()
	{
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
/*************************************INHERITED METHODS*************************************/

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
		head = null;
		tail = null;
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
		
		if( !isEmpty() ) //if list is not empty
		{
			if( index == 0 ) //add to beginning
			{
				DLLNode<E> prev = head;
				DLLNode<E> nodeAdded = new DLLNode<E>(toAdd);
				
				nodeAdded.setNext(prev);
				prev.setPrev(nodeAdded);
				head = nodeAdded;
				
				addSuccess = true;
				size++;
			}
			else if( index == size ) //add to end
				addSuccess = add(toAdd);
			else //add to somewhere in middle
			{
				DLLNode<E> prev = head;
				DLLNode<E> next;
				
				for( int i = 0 ; i < ( size - 1 ) ; i++ ) //move through list till pointer reaches node before wanted position
					prev = prev.getNext();
				
				next = prev.getNext();
				DLLNode<E> nodeAdded = new DLLNode<E>(toAdd);
				
				nodeAdded.setNext(next);
				nodeAdded.setPrev(prev);
				
				prev.setNext(nodeAdded);
				next.setPrev(nodeAdded);
				
				addSuccess = true;
				size++;
			}
		}
		else //list is empty, element becomes head and tail
		{
			head = new DLLNode<E>(toAdd);
			tail = head;
			addSuccess = true;
			size++;
		}
		
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
		
		if( !isEmpty() ) //if list is not empty append to end
		{
			DLLNode<E> last = tail;
			DLLNode<E> nodeAdded = new DLLNode<E>(toAdd);
			
			nodeAdded.setPrev(last);
			last.setNext(nodeAdded);
			tail = nodeAdded;
			
			addSuccess = true;
			size++;
		}
		else //if list empty make element the head
		{
			head = new DLLNode<E>(toAdd);
			tail = head;
			addSuccess = true;
			size++;
		}
		
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
		
		for( int i = 0 ; i < toAdd.size() ; i++ )
			add( toAdd.get(i) ); //append each element of list in order
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
		
		E element = null;
		
		if( !isEmpty() )
		{
			DLLNode<E> getNode = head;
			
			for( int i = 0 ; i < index ; i++ )
				getNode = getNode.getNext();
			
			element = getNode.getElement();
		}
		
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
		
		E element = null;
		
		if( !isEmpty() )
		{			
			if( index == 0 ) //remove head
			{
				DLLNode<E> removeNode = head;
				DLLNode<E> newHead = removeNode.getNext();
				head = newHead;
				element = removeNode.getElement();
				
				removeNode.setNext(null);
				newHead.setPrev(null);
				removeNode.setElement(null);
				size--;
			}
			else if( index == ( size - 1 ) ) //remove tail
			{
				if( size == 1 ) //last element is only element, so removing the head and the tail
				{
					element = head.getElement();
					head = null;
					tail = null;
					size--;
				}
				else //list size is more than one, there will still be a head node
				{
					DLLNode<E> removeNode = tail;
					DLLNode<E> prev = removeNode.getPrev();
					
					element = removeNode.getElement();
					tail = prev;
					
					prev.setNext(null);
					removeNode.setPrev(null);
					removeNode.setElement(null);
					size--;
				}
			}
			else //remove from middle
			{
				DLLNode<E> removeNode = head.getNext();
				DLLNode<E> prev = head;
				DLLNode<E> next = removeNode.getNext();
				
				for( int i = 0 ; i < index ; i++ )
				{
					removeNode = removeNode.getNext();
					prev = prev.getNext();
					next = next.getNext();
				}
				
				element = removeNode.getElement();
				prev.setNext(next);
				next.setPrev(prev);
				
				removeNode.setPrev(null);
				removeNode.setNext(null);
				removeNode.setElement(null);
				size--;
			}
		}
		
		return element;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E remove(E toRemove) 
			throws NullPointerException 
	{
		if( toRemove == null )
			throw new NullPointerException();
		
		E removedElement = null;
		
		DLLNode<E> checkedNode = head;
	
			for( int i = 0 ; i < size ; i++ )
			{
				if( toRemove.equals( checkedNode.getElement() ) )
				{
					removedElement = checkedNode.getElement();
					
					if( i == 0 ) //remove head
						remove(0);
					else if( i == ( size - 1 ) ) //remove tail
						remove( ( size -1 ) );
					else
						remove(i); //remove from middle
					
					break; //leave loop after one remove performed
				}
				
				checkedNode = checkedNode.getNext();
			}
			
		return removedElement;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public E set(int index, E toChange) 
			throws NullPointerException, IndexOutOfBoundsException 
	{
		if( index < 0 || index > ( size - 1 ) )
			throw new IndexOutOfBoundsException();
		
		if( toChange == null )
			throw new NullPointerException();
		
		E oldElement = null;
		
		if( !isEmpty() )
		{
			if( index == 0 ) //set head
			{
				oldElement = head.getElement();
				head.setElement(toChange);
			}
			else if( index == size ) //set tail
			{
				oldElement = tail.getElement();
				tail.setElement(toChange);
			}
			else //set somewhere in middle
			{
				DLLNode<E> setNode = head;
				
				for( int i = 0 ; i < index ; i++ )
					setNode = setNode.getNext();
				
				oldElement = setNode.getElement();
				setNode.setElement(toChange);
			}
		}
		
		return oldElement;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() 
	{
		return ( head == null );
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
		
		boolean containStatus = false;
		
		DLLNode<E> checkedNode = head;
		
		while( checkedNode.getNext() != null )
		{
			if( toFind.equals( checkedNode.getElement() ) )
			{
				containStatus = true;
				break; //exit once first instance found
			}
			
			checkedNode = checkedNode.getNext();
		}
		
		return containStatus;
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
		
		DLLNode<E> currentNode = head;
		for( int i = 0 ; i < size && currentNode.getNext() != null ; i++ )
		{
			toHold[i] = (E) currentNode.getElement();
			currentNode = currentNode.getNext();
		}
		
		return toHold;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object[] toArray() 
	{
		Object[] toReturn = new Object[size];
		DLLNode<E> currentNode = head;
		
		for( int i = 0 ; i < size && currentNode.getNext() != null ; i++ )
		{
			toReturn[i] = currentNode.getElement();
			currentNode = currentNode.getNext();
		}
		
		return toReturn;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterator<E> iterator() 
	{
		return new LinkedListBasedIterator();
	}
	
/***************************************INNER CLASS***************************************/
	
	/**
	 * This inner class utilizes an mono-directional iterator to move from the beginning
	 * to the end of a linked list. It steps through a copy of the list elements.
	 * @author Dwatson
	 */
	private class LinkedListBasedIterator implements Iterator<E>
	{
		//Attributes
		private E[] copyOfElements;
		private int pos;
			
		//Constructor
		/**
		 * Default constructor.
		 * Creates a new array that contains a copy of all elements from the array that the iterator will
		 * be used for.
		 */
		@SuppressWarnings("unchecked")
		public LinkedListBasedIterator()
		{
			copyOfElements = ( E[] ) new Object[size()];
			toArray(copyOfElements);
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
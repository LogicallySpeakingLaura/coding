package utilities;

import java.util.NoSuchElementException;

import exceptions.TreeException;

/**
 * Class to implement a data structure for a Binary Search Tree.
 * Some theory on implementation taken from 'Data Structures and Abstractions with Java' by F.M. Carrano
 * and T. Henry.
 * @author 776298
 *
 * @param <E> - infer generics
 */
public class BST< E extends Comparable< ? super E > > implements BSTreeADT<E>
{
/*******************************************INIT*******************************************/
	//Constant
	private static final long serialVersionUID = 123456789L;
	
	//Attributes
	private BSTreeNode<E> root;
	private int height;
	private int size;
	
	/**
	 * Default constructor.
	 */
	public BST()
	{
		this.root = null;
		this.height = 0;
		this.size = 0;
	}

/*************************************INHERITED METHODS*************************************/
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public BSTreeNode<E> getRoot() 
			throws TreeException 
	{
		if( size == 0 )
			throw new TreeException( "An empty BST contains no root." );
		
		return root;
	}

	/**
	 * {@inheritDoc}
	 */
	public int getHeight()
	{
		return calcHeight(root);
	}

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
	public boolean isEmpty() 
	{
		return ( size == 0 );
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void clear() 
	{
		root = null;
		size = 0;
		height = 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean contains( E entry ) 
			throws TreeException 
	{
		if( size == 0 )
			throw new TreeException( "An empty BST contains no items." );
		
		return search(entry) != null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BSTreeNode<E> search( E entry ) 
			throws TreeException 
	{
		if( size == 0 )
			throw new TreeException( "Cannot search an empty BST." );
				
		return searchEntry( root, entry );
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean add( E newEntry) 
			throws NullPointerException 
	{
		if( newEntry == null )
			throw new NullPointerException( "Cannot add a null element to binary tree." );
		
		return addEntry( root, newEntry );
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterator<E> inorderIterator() 
	{
		return new InOrderIterator();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterator<E> preorderIterator() 
	{
		return new PreOrderIterator();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterator<E> postorderIterator() 
	{
		return new PostOrderIterator();
	}
	
/**************************************UTILITY METHODS**************************************/
	
	/**
	 * Method to recursively calculate the height of a BST.
	 * @param root - root node of BST.
	 * @return - an int of the height of a BST.
	 */
	private int calcHeight( BSTreeNode<E> root )
	{
		if( root != null )
			height = 1 + Math.max( calcHeight( root.getLeftChild() ), calcHeight( root.getRightChild() ) );
		else if( root == null )
			height = 0;
		
		return height;
	}
	
	/**
	 * Method to recursively search for an entry in a BST.
	 * @param root - root node of BST.
	 * @param entry - element to be searched for.
	 * @return - a BST node containing searched for element.
	 */
	private BSTreeNode<E> searchEntry( BSTreeNode<E> root, E entry )
	{
		BSTreeNode<E> searchedNode = null;
		E currentEntry = root.getElement();
		
		if( entry.equals(currentEntry) )
			searchedNode = root;
		else if( entry.compareTo(currentEntry) < 0 )
			searchedNode = searchEntry( root.getLeftChild(), entry );
		else if( entry.compareTo(currentEntry) > 0 )
			searchedNode = searchEntry( root.getRightChild(), entry );
		
		return searchedNode;
	}
	
	/**
	 * Method to recursively add an element to a BST.
	 * @param root - root node of BST.
	 * @param newEntry - element to be added.
	 * @return - true if element successfully added, otherwise false.
	 */
	private boolean addEntry( BSTreeNode<E> root, E newEntry )
	{
		boolean addSuccess = false;
		
		if( isEmpty() )
		{
			root.setElement(newEntry);
			addSuccess = true;
		}
		else if( newEntry.compareTo( root.getElement() ) == 0 )
		{
			addSuccess = true;
		}
		else if( newEntry.compareTo( root.getElement() ) < 0 )
		{
			if( root.hasLeftChild() )
				addSuccess = addEntry( root.getLeftChild(), newEntry );
			else
			{
				root.setLeftChild( new BSTreeNode<E>(newEntry) );
				addSuccess = true;
			}
		}
		else if( newEntry.compareTo( root.getElement() ) > 0 )
		{
			if( root.hasRightChild() )
				addSuccess = addEntry( root.getRightChild(), newEntry );
			else
			{
				root.setRightChild( new BSTreeNode<E>(newEntry) );
				addSuccess = true;
			}
		}
			
		return addSuccess;
	}
	
/**************************************INNER CLASSES**************************************/
	
	/**
	 * Private inner class to create an in-order iterator for a BST.
	 * Some theory on implementation taken from 'Data Structures and Abstractions with Java' by F.M. Carrano
     * and T. Henry.
	 * @author 776298
	 *
	 */
	private class InOrderIterator implements Iterator<E>
	{
		//Attributes
		private MyStack< BSTreeNode<E> > stack;
		private BSTreeNode<E> currentNode;
		
		/**
		 * Default constructor
		 */
		public InOrderIterator()
		{
			stack = new MyStack<>();
			currentNode = root;
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean hasNext() 
		{
			return ( !stack.isEmpty() || currentNode != null );
		}
	
		/**
		 * {@inheritDoc}
		 */
		@Override
		public E next() 
				throws NoSuchElementException 
		{
			BSTreeNode<E> nextNode = null;
			
			while( currentNode != null )
			{
				stack.push(currentNode);
				currentNode = currentNode.getLeftChild();
			}
			
			if( !stack.isEmpty() )
			{
				nextNode = stack.pop();
				currentNode.getRightChild();
			}
			else
				throw new NoSuchElementException( "No element to be found." );
			
			return nextNode.getElement();
		}
		
	}
	
	
	/**
	 * Private inner class to create a pre-order iterator for a BST.
	 * Reference - https://java2blog.com/binary-tree-preorder-traversal-in-java/
	 * @author 776298
	 *
	 */
	private class PreOrderIterator implements Iterator<E>
	{
		//Attribute
		private MyStack< BSTreeNode<E> > stack;
		
		//Default constructor
		/**
		 * 
		 */
		public PreOrderIterator()
		{
			stack = new MyStack<>();
			stack.push(root);
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean hasNext() 
		{
			return !stack.isEmpty();
		}
	
		/**
		 * {@inheritDoc}
		 */
		@Override
		public E next() 
				throws NoSuchElementException 
		{
			BSTreeNode<E> nextNode = stack.pop();
			
			while( !nextNode.hasLeftChild() && !nextNode.hasRightChild() )
			{				
				if( nextNode.hasRightChild() )
					stack.push( nextNode.getRightChild() );
				else if( nextNode.hasLeftChild() )
					stack.push( nextNode.getLeftChild() );
				else
					throw new NoSuchElementException( "No element to be found." );
			}
			
			return nextNode.getElement();
		}
	}
	
	/**
	 * Private inner class to create a post-order iterator for a BST.
	 * Reference - https://java2blog.com/binary-tree-preorder-traversal-in-java/
	 * @author 776298
	 *
	 */
	private class PostOrderIterator implements Iterator<E>
	{
		//Attributes
		private MyStack< BSTreeNode<E> > stack;
		private BSTreeNode<E> currentNode;
		
		/**
		 * Default constructor
		 */
		public PostOrderIterator()
		{
			stack = new MyStack<>();
			currentNode = root;
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean hasNext() 
		{
			return ( !stack.isEmpty() || currentNode != null );
		}
	
		/**
		 * {@inheritDoc}
		 */
		@Override
		public E next() 
				throws NoSuchElementException 
		{
			BSTreeNode<E> nextNode = stack.pop();
			
			while( !nextNode.hasLeftChild() && !nextNode.hasRightChild() )
			{
				if( nextNode.hasLeftChild() )
					stack.push( nextNode.getLeftChild() );
				else if( nextNode.hasRightChild() )
					stack.push( nextNode.getRightChild() );
				else
					throw new NoSuchElementException( "No element to be found." );
			}
			
			return nextNode.getElement();
		}
	}
}
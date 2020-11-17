package utilities;

/**
 * Class to detail the structure of what one node in a BST should contain.
 * Some theory on implementation taken from 'Data Structures and Abstractions with Java' by F.M. Carrano
 * and T. Henry.
 * @author 776298
 *
 * @param <E> - infer generics
 */
public class BSTreeNode<E> 
{
	//Attributes
	private E element;
	private BSTreeNode<E> leftChild;
	private BSTreeNode<E> rightChild;
	
	//Constructors
	/**
	 * Default constructor.
	 */
	public BSTreeNode()
	{
		this(null);
	}
	
	/**
	 * Constructor to create an object containing an element.
	 * @param element - data to be kept in node.
	 */
	public BSTreeNode( E element )
	{
		this( element, null, null );
	}
	
	/**
	 * Constructor to create an object containing element and positioning data.
	 * @param element - data to be kept in node.
	 * @param leftChild - the lesser value attached to node.
	 * @param rightChild - the greater value attached to node.
	 */
	public BSTreeNode( E element, BSTreeNode<E> leftChild, BSTreeNode<E> rightChild )
	{
		this.element = element;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	//Getters&Setters
	/**
	 * Return element stored in node.
	 * @return - element stored in node.
	 */
	public E getElement() 
	{
		return element;
	}

	/**
	 * Set element stored in node.
	 * @param element - element stored in node.
	 */
	public void setElement (E element ) 
	{
		this.element = element;
	}

	/**
	 * Return the node of lesser value attached to current node.
	 * @return - the node of lesser value attached to current node.
	 */
	public BSTreeNode<E> getLeftChild() 
	{
		return leftChild;
	}

	/**
	 * Set the node of lesser value attached to current node.
	 * @param leftChild - the node of lesser value attached to current node.
	 */
	public void setLeftChild( BSTreeNode<E> leftChild ) 
	{
		this.leftChild = leftChild;
	}

	/**
	 * Return the node of greater value attached to current node.
	 * @return - the node of greater value attached to current node.
	 */
	public BSTreeNode<E> getRightChild() 
	{
		return rightChild;
	}

	/**
	 * Set the node of greater value attached to current node.
	 * @param rightChild - the node of greater value attached to current node.
	 */
	public void setRightChild( BSTreeNode<E> rightChild)
	{
		this.rightChild = rightChild;
	}
	
	//Utility Methods
	/**
	 * Return whether or not node has a child node of lesser value.
	 * @return - true if there is a child node of lesser value, otherwise false.
	 */
	public boolean hasLeftChild()
	{
		return ( leftChild != null );
	}
	
	/**
	 * Return whether or not node has a child node of greater value.
	 * @return - true if there is a child node of greater value, otherwise false.
	 */
	public boolean hasRightChild()
	{
		return ( rightChild != null );
	}
	
	/**
	 * Return whether or not the node has any child nodes.
	 * @return - true if node has no children, otherwise false.
	 */
	public boolean isLeaf()
	{
		return ( leftChild == null ) && ( rightChild == null );
	}	
}

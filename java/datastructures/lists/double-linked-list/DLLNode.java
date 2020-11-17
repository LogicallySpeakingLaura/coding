package utilities;

/**
 * Class that is instantiated to create a node for a DLL.
 * @author 776298
 *
 * @param <E> - infer generics
 */
public class DLLNode<E>
{
	//Attributes
	private E element;
	private DLLNode<E> next;
	private DLLNode<E> prev;

	//Constructors
	/**
	 * Default constructor. Empty node with no links.
	 */
	public DLLNode()
	{
		this.element = null;
		this.next = null;
		this.prev = null;
	}
	
	/**
	 * Constructor that creates a node containing an element and its next and previous node.
	 * @param element - element of type E to be stored in node.
	 * @param next - the next node in the DLL.
	 * @param prev - the previous node in the DLL.
	 */
	public DLLNode( E element, DLLNode<E> next, DLLNode<E> prev) 
	{
		this.element = element;
		this.next = next;
		this.prev = prev;
	}
	
	/**
	 * Constructor creating a node containing an element but no logical references.
	 * @param element - element of type E to be stored in node.
	 */
	public DLLNode( E element )
	{
		this.element = element;
		this.next = null;
		this.prev = null;
	}

	//Getters and setters
	/**
	 * Returns the element contained in the node.
	 * @return - element of type E.
	 */
	public E getElement() 
	{
		return element;
	}

	/**
	 * Sets the element to be contained in the node.
	 * @param element - data of type E to be kept in node.
	 */
	public void setElement( E element ) 
	{
		this.element = element;
	}

	/**
	 * Returns the next node in the DLL.
	 * @return - the next node in the DLL as a generic MyDLLNode object.
	 */
	public DLLNode<E> getNext() 
	{
		return next;
	}

	/**
	 * Sets the next node in the DLL.
	 * @param next - the next node in the DLL as a generic MyDLLNode object.
	 */
	public void setNext( DLLNode<E> next ) 
	{
		this.next = next;
	}

	/**
	 * Returns the previous node in the DLL.
	 * @return - the previous node in the DLL as a generic MyDLLNode object.
	 */
	public DLLNode<E> getPrev() 
	{
		return prev;
	}

	/**
	 * Sets the previous node in the DLL.
	 * @param prev - the previous node in the DLL as a generic MyDLLNode object.
	 */
	public void setPrev( DLLNode<E> prev ) 
	{
		this.prev = prev;
	}	
}
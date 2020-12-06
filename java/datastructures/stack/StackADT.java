package datastructures.stack;

/**
 * Interface for the abstraction of a Stack data type.
 * Refer: F. M. Carrano and T. Henry, Data structures and abstractions with Java. Boston: Pearson Education, Inc., 2019.
 *
 * @param <T> Infer generics.
 *
 * @author LogicallySpeakingLaura
 * @version 2020.12.04
 * @see StackImplementation
 */
interface StackADT<T>
{

    /*
     * A stack is a 'Last In First Out (LIFO)' data type. The most recent entry is the first to be removed or accessed.
     * Access to items is restricted. In order to see the oldest entry, every entry would have to be removed in
     * reverse chronological order. This data type is useful when resolving algebraic expressions, particularly
     * Infix to Postfix. It does not have a set size and grows as needed with its entries.
     */


    /**
     * Method to add an item to the top of the stack.
     *
     * @param element Item to be added.
     */
    void push( T element );

    /**
     * Method to remove the item at the top of the stack.
     *
     * @return Item to be removed, same as item at top of stack.
     */
    T pop();

    /**
     * Method to show the item at top of the stack.
     *
     * @return The item at the top of the stack.
     */
    T peek();

    /**
     * Method to determine if stack contains any items.
     *
     * @return True if stack contains at least one item otherwsie false.
     */
    boolean isEmpty();

    /**
     * Method to remove all items from the stack.
     */
    void clear();

}
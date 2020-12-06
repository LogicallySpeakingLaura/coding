package datastructures.queue;

/**
 * Interface for the abstraction of a Queue data type.
 * Refer: F. M. Carrano and T. Henry, Data structures and abstractions with Java. Boston: Pearson Education, Inc., 2019.
 *
 * @param <T> Infer generics.
 *
 * @author LogicallySpeakingLaura
 * @version 2020.12.05
 * @see QueueImplementation
 */
interface QueueADT<T>
{

    /*
     * A queue is a 'First In First Out (FIFO)' data type. The oldest entry is the first to be removed or accessed.
     * Access to items is restricted. In order to see an entry not at the front of the queue, every entry before it
     * would have to be removed in chronological order. This data type is useful when resolving algebraic expressions,
     * particularly Infix to Postfix. It does not have a set size and grows as needed with its entries.
     */


    /**
     * Method to add a new item to the back of the queue.
     *
     * @param element Item to be added.
     */
    void enqueue( T element );

    /**
     * Method to remove an item from the front of the queue.
     *
     * @return Item removed from front of queue.
     */
    T dequeue();

    /**
     * Method to access the item at the front of the queue.
     *
     * @return Item at front of queue.
     */
    T getfront();

    /**
     * Method to determine if queue contains items.
     *
     * @return True if queue contains items otherwise false.
     */
    boolean isEmpty();

    /**
     * Method to remove all items from queue.
     */
    void clear();

}
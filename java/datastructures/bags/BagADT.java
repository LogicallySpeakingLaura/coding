package datastructures.bags;

/**
 * Interface for the abstraction of a Bag data type.
 * Refer: F. M. Carrano and T. Henry, Data structures and abstractions with Java. Boston: Pearson Education, Inc., 2019.
 *
 * @param <T> Infer generics.
 *
 * @author LogicallySpeakingLaura
 * @version 2020.12.04
 */
interface BagADT<T>
{

    /*
     * A bag can be considered as a collection/container of objects of the same data type. However, as 'collection' and
     * 'container' have their own meaning in Java, bag is used instead. Like an array there is a set size. Duplicates are
     * allowed. Items are stored in no particular order.
     */


    /**
     * Method to give the current number of items in the bag.
     *
     * @return Current number of items as an int.
     */
    int getSize();

    /**
     * Method to check whether the bag has any items.
     *
     * @return True if there is at least one item otherwise false.
     */
    boolean isEmpty();

    /**
     * Method to add another item to the bag.
     *
     * @param element Item to be added.
     * @return True if element successfully added otherwise false.
     */
    boolean add( T element );

    /**
     * Method to remove an item from the bag.
     *
     * @return The removed element if successful otherwise null.
     */
    T remove();

    /**
     * Method to remove a specific item from the bag.
     *
     * @param element Item to be removed.
     * @return True if element successfully removed otherwise false.
     */
    boolean remove( T element );

    /**
     * Method to remove all items from the bag.
     */
    void clear();

    /**
     * Method to see how many duplicates of an item are in the bag.
     *
     * @param element Item to be counted.
     * @return The number of times the item appears as an int.
     */
    int getCount( T element );

    /**
     * Method to check if an item exists in the bag.
     *
     * @param element Item being checked for.
     * @return True if element exists in the bag otherwise false.
     */
    boolean contains( T element );

    /**
     * Method to convert all items in the bag to an array.
     *
     * @return An array containing the items in the bag.
     */
    T[] toArray();

}
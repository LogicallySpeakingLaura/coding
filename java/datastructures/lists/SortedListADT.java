package datastructures.lists;

interface SortedListADT<T>
{

    void add( T element );

    T remove( T element );

    T remove( int pos );

    T getPos( T element );

    T getElement( int pos );

    boolean contains( T element );

    void clear();

    int getLength();

    boolean isEmpty();

    T[] toArray();

}
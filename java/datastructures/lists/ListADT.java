package datastructures.lists;

interface ListADT<T>
{

    void add( T element );

    void add( int pos, T element );

    T remove( int pos );

    void clear();

    T set( int pos, T element );

    T getElement( int pos );

    T[] toArray();

    boolean contains( T element );

    int getLength();

    boolean isEmpty();

}

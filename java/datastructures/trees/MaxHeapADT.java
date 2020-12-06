package datastructures.trees;

interface MaxHeapADT< T extends Comparable< ? super T > >
{

    void add( T element );

    T remove();

    T get();

    boolean isEmpty();

    int getSize();

    void clear();

}

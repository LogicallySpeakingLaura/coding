package datastructures.trees;

import java.util.Iterator;

public interface SearchTree_ADT< T extends Comparable< ? super T > > extends TreeADT<T>
{

    boolean contains( T element );

    T get( T element );

    T add( T element );

    T remove( T element );

    Iterator<T> getInorderIterator();

}

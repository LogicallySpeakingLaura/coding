package datastructures.dictionary;

import java.util.Iterator;

interface DictionaryADT< K, V >
{

    V add( K key, V value );

    V remove( K key );

    V get( K key );

    boolean contains( K key );

    Iterator<K> getKeyIterator();

    Iterator<V> getValueIterator();

    boolean isEmpty();

    int getSize();

    void clear();

}

package datastructures.queue;

interface DequeueADT<T>
{

    void addFront( T element );

    void addBack( T element );

    T removeFront();

    T removeBack();

    T getFront();

    T getBack();

    boolean isEmpty();

    void clear();

}

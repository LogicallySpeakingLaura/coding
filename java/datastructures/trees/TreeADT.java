package datastructures.trees;

public interface TreeADT<T>
{

    T getRoot();

    int getHeight();

    int getNodeCount();

    boolean isEmpty();

    void clear();

}

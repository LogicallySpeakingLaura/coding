package datastructures.trees;

interface BinaryTreeADT<T> extends TreeADT<T>, TreeIteratorInterface<T>
{

    void setRoot( T rootData );

    void setTree( T rootData, BinaryTreeADT<T> left, BinaryTreeADT<T> right );

}

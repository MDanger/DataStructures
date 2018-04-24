package tree;

import node.BinaryTreeNode;

public class LinkedBinaryTree<T> implements BinaryTreeADT<T>, Iterable<T> {
    protected BinaryTreeNode<T> root;
    protected int modCount;

    public LinkedBinaryTree(){
        root = null;
    }

    public LinkedBinaryTree(T element){
        root = new BinaryTreeNode<T>(element);
    }

    public LinkedBinaryTree(T element, LinkedBinaryTree<T> left, LinkedBinaryTree<T> right){
        root = new BinaryTreeNode<T>(element;
        root.setLeft(left.root);
        root.setRight(right.root);
    }
}

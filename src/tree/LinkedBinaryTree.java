package tree;

import java.util.*;
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
        root = new BinaryTreeNode<T>(element);
        root.setLeft(left.root);
        root.setRight(right.root);
    }

    /**
     * Returns a reference to the root element
     *
     * @return a reference to the root
     */
    @Override
    public T getRootElement() {
        return root.getElement();
    }

    public BinaryTreeNode<T> getRootNode(){
        return root;
    }

    /**
     * Returns true if this binary tree is empty and false otherwise
     *
     * @return true if this binary tree is empty and false otherwise
     */
    @Override
    public boolean isEmpty() {
        boolean empty = false;
        if (root == null ) {
            empty = true;
        }
        return empty;
    }

    /**
     * Returns number of elements in this binary tree.
     *
     * @return int number of elements in this binary tree.
     */
    @Override
    public int size() {
        int result = 0;
        if (root.getLeft() != null){ result = 1 + getRootNode().numChildren();}
        if (root.getRight() != null) { result = 1 + getRootNode().numChildren()}
        
        return result;
    }

    /**
     * Returns true if the binary tree contains an element that matches the specifiesd element and false otherwise.
     *
     * @param targetElement the element being sought
     * @return true if tree contains the target element
     */
    @Override
    public boolean contains(T targetElement) {
        return false;
    }

    /**
     * Returns a reference to targetElement. Throws an exception if the element not found.
     *
     * @param targetElement
     * @return reference to targetElement
     */
    @Override
    public T find(T targetElement) {
        return null;
    }

    /**
     * Returns an iterator over elements of tree
     *
     * @return iterator over elements of tree
     */
    @Override
    public Iterator<T> iterator() {
        return null;
    }

    /**
     * Returns an inorder traversal iterator on tree
     *
     * @return iterator over elements of this tree
     */
    @Override
    public Iterator<T> iteratorInOrder() {
        return null;
    }

    /**
     * Returns a preorder traversal iterator on tree
     *
     * @return iterator over elements of this tree
     */
    @Override
    public Iterator<T> iteratorPreOrder() {
        return null;
    }

    /**
     * Returns postorder traversal of tree
     *
     * @return iterator over elements of this tree
     */
    @Override
    public Iterator<T> iteratorPostOrder() {
        return null;
    }

    /**
     * Returns a levelorder traversal of tree
     *
     * @return iterator over elements of this tree
     */
    @Override
    public Iterator<T> iteratorLevelOrder() {
        return null;
    }
}

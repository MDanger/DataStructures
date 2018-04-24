package node;

import tree.LinkedBinaryTree;

public class BinaryTreeNode<T> {
    protected T element;
    protected BinaryTreeNode<T> left, right;

    /**
     * Default constructor. Create BinaryTreeNode with the given element
     * @param obj the element to be added to node
     */
    public BinaryTreeNode(T obj){
        element = obj;
        left = null;
        right = null;

    }

    public BinaryTreeNode(T obj, LinkedBinaryTree<T> left, LinkedBinaryTree<T> right) {
        element = obj;
        if (left == null) {
            this.left = null;
        } else {
            this.left = left.getRootNode();
        }

        if (right == null){
            this.right = null;
        } else {
            this.right = right.getRootNode();
        }
    }

    public int numChildren(){
        int children = 0;

        if (left != null){
            children = 1 + left.numChildren();
        }
        if (right != null){
            children = children + 1 + right.numChildren();
        }
        return children;
    }

    public T getElement(){
        return element;
    }

    public void setElement(T obj){ element = obj; }

    public BinaryTreeNode<T> getRight(){
        return right;
    }

    public void setRight(BinaryTreeNode<T> node){
        right = node;
    }

    public BinaryTreeNode<T> getLeft(){
        return left;
    }

    public void setLeft(BinaryTreeNode<T> node){
        left = node;
    }
}

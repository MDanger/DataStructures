package tree;

/**
 * BinaryTreeADT defines the interface to the binary tree data structure.
 *
 * @author Lewis and Chase, Blackmore
 * @version 1.0
 */
public interface BinaryTreeADT<T> {

    /**
     * Returns a referenc to the root element
     *
     * @return a reference to the root
     */
    public T getRootElement();
    /**
     * Returns true if this binary tree is empty and false otherwise
     *
     * @return true if this binary tree is empty and false otherwise
     */
    public boolean isEmpty();

    /**
     * Returns number of elements in this binary tree.
     * @return  int number of elements in this binary tree.
     */
    public int size();

    /**
     * Returns true if the binary tree contains an element that matches the specifiesd element and false otherwise.
     *
     * @param targetElement  the element being sought
     * @return true if tree contains the target element
     */
    public boolean contains (T targetElement);

    /**
     * Returns a reference to targetElement. Throws an exception if the element not found.
     * @param targetElement
     * @return
     */
    public T find(T targetElement);

    /**
     * Returns a csv string of elements in this tree.
     * @return
     */
    public String toString();

    /**
     * Returns an iterator over elements of tree
     * @return iterator over elements of tree
     */
    public Iterator<T> iterator();

    /**
     * Returns an inorder traversal on tree
     * @return return iterator over elements of this tree
     */
    public Iterator<T> iteratorInOrder();

    /**
     * Returns a preorder traversal on tree
     * @return iterator over elements of this tree
     */
    public Iterator<T> iteratorPreOrder();

    /**
     * Returns postorder traversal of tree
     * @return iterator over elements of this tree
     */
    public Iterator<T> iteratorPostOrder();

    /**
     * Returns a levelorder traversal of tree
     * @return iterator over elements of this tree
     */
    public Iterator<T> iteratorLevelOrder();
}

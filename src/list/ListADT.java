package list;

import java.util.Iterator;

public interface ListADT<T> extends Iterable<T>{
    /**
     * Removes and returns first element
     * @return first element from list
     */
    public T removeFirst();

    /**
     * Removes and returns last element
     * @return last element from list
     */
    public T removeLast();

    /**
     * Removes and returns the given element
     * @param element to remove from list
     *
     */
    public void remove(T element);

    /**
     * Return first element without removing it
     * @return T first element
     */
    public T first();

    /**
     * Return last element without removing it
     * @return last element
     */
    public T last();

    /**
     * Check if any elements are in list
     * @return boolean  true if no elements
     */
    public boolean isEmpty();

    /**
     * Number of elements in list
     * @return integer number of elements
     */
    public int size();

    /**
     * Returns an iterator for the elements of this list
     * @return Iterator for list
     */
    public Iterator Iterator();

    /**
     * Return string representation of comma separated elements in list
     * @return comma-separated string of list elements
     */
    public String toString();
}
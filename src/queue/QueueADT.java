package queue;

public interface QueueADT<T> {

    /**
     * Adds element to rear of queue
     * @param element the element to be added to rear
     */
    public void enqueue(T element);

    /**
     * returns element from front of queue and removes it
     * @return the element at front of queue
     */
    public T dequeue();

    /**
     * returns element from front of queue without removing it
     * @return the element at front of queue
     */

    public T peek();

    /**
     * returns True if empty
     * @return true if empty
     */
    public boolean isEmpty();

    /**
     * returns integer number of items in queue
     * @return integer number of items in queue
     */
    public int size();

    /**
     * returns string of comma separated list of all elements in queue
     * @return string representation of queue
     */
    public String toString();
}

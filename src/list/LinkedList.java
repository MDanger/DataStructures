package list;

import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;
import exceptions.NonComparableElementException;
import node.LinearNode;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class LinkedList<T> implements ListADT<T> {
    LinearNode head, tail;
    int count, modCount;


    public LinkedList(){
        head = tail = null;
        count = 0;
    }

    public LinkedList(T element){
        head.setElement(element);
        tail.setElement(element);
        count++;
        modCount++;
    }

    /**
     * OrderedList add according to natural ordering using comparable
     *
     * @param element to be added
     * @throws exceptions.NonComparableElementException
     */
    public void add(T element){
        if (!(element instanceof Comparable)) throw new NonComparableElementException("ordered linkedlist");
        Comparable<T> comparableElement = (Comparable<T>) element;
        LinearNode<T> newNode = new LinearNode<T>(element);

        if (isEmpty()){
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        count++;
        modCount++;
    }

    public void addToFront(T element){
        LinearNode<T> newHead = new LinearNode<T>(element);
        newHead.setNext(head);
        head = newHead;
        count++;
        modCount++;

    }

    public void addToTail(T element){
        LinearNode<T> newTail = new LinearNode<T>(element);
        newTail.setNext(null);
        tail.setNext(newTail);
        tail = newTail;
        count++;
        modCount++;
    }

    public void addAfter(T element, T target ) throws ElementNotFoundException {
        LinearNode runner = head;
        LinearNode newNode = new LinearNode(element);
        while (runner.getNext() != null && !runner.getElement().equals(target)){
                runner = runner.getNext();

        }
        if (runner.getNext() == null) throw new ElementNotFoundException("linkedlist");

        newNode.setNext(runner.getNext());
        runner.setNext(newNode);
        modCount++;
        count++;
    }



    /**
     * Remove the first instance of the given element from list
     * @param element to remove from list
     * @throws EmptyCollectionException
     * @throws ElementNotFoundException
     */
    @Override
    public void remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        if (isEmpty()) throw new EmptyCollectionException("linkedlist");
        boolean found = false;
        LinearNode<T> runner = head;
        while (runner.getNext() != null && !found) {
            if (runner.getElement().equals(element)){
                found = true;
                runner.setElement((T) runner.getNext().getElement());
                runner.setNext(runner.getNext().getNext());
            }
            else
                runner = runner.getNext();
            }
        if (!found) throw new ElementNotFoundException("linkedlist");
        if (size() == 0) head = tail = null;
        count--;
        modCount++;
    }

    /**
     * Remove and return the first element in list
     * @return first element from list
     * @throws EmptyCollectionException
     */
    public T removeFirst()throws  EmptyCollectionException {
        if (isEmpty()) throw new EmptyCollectionException("linkedlist");
        T result = (T) head.getElement();
        head = head.getNext();
        count--;
        modCount++;
        return result;
    }

    /**
     * Remove and return last element from list. Is an O(n) operation in a singly linked list like this. Since it has to
     * iterate through to reset tail pointer.
     * @return last element in this list
     */
    public T removeLast() throws EmptyCollectionException {
        if (isEmpty()) throw new EmptyCollectionException("linkedlist");
        T result = (T) tail.getElement();
        LinearNode<T> runner = head;
        while (runner.getNext().getNext() != null){
            runner=runner.getNext();
        }
        runner.setNext(null);
        tail = runner;
        count--;
        modCount++;
        return result;
    }

    /**
     * Return without removing first element in list
     * @return first element in list
     * @throws EmptyCollectionException
     */
    @Override
    public T first()throws EmptyCollectionException {
        if (isEmpty()) throw new EmptyCollectionException("linkedlist");
        return (T) head.getElement();
    }

    /**
     * Return without removing last element in list
     * @return last element in list
     * @throws EmptyCollectionException
     */
    @Override
    public T last() throws EmptyCollectionException {
        if (isEmpty()) throw new EmptyCollectionException("linkedlist");
        return (T) tail.getElement();
    }

    /**
     * Return integer number of elements
     * @return int number of elements
     */
    @Override
    public int size(){
        return count;
    }

    /**
     * Return true is list has no elements.
     * @return
     */
    public boolean isEmpty(){
        return (count == 0);
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        LinearNode runner = head;
        while (runner.getNext() != null){
            result.append(runner.getElement());
            result.append(", ");
            runner = runner.getNext();
        }
        result.append(runner.getElement());
        return result.toString();
    }

    @Override
    public Iterator Iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T>{
        private int iteratorCount;
        private LinearNode<T> current;

        public LinkedListIterator(){
            iteratorCount  = modCount;
            current = head;
        }
        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() throws ConcurrentModificationException {
            if (iteratorCount != modCount) throw new ConcurrentModificationException();
            return (current != null);
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public T next() throws ConcurrentModificationException {
            if (!hasNext()) throw new NoSuchElementException();
            T result = current.getElement();
            current = current.getNext();
            return result;
        }

        /**
         * Removes from the underlying collection the last element returned
         * by this iterator (optional operation).  This method can be called
         * only once per call to {@link #next}.  The behavior of an iterator
         * is unspecified if the underlying collection is modified while the
         * iteration is in progress in any way other than by calling this
         * method.
         *
         * @throws UnsupportedOperationException if the {@code remove}
         *                                       operation is not supported by this iterator
         * @throws IllegalStateException         if the {@code next} method has not
         *                                       yet been called, or the {@code remove} method has already
         *                                       been called after the last call to the {@code next}
         *                                       method
         * @implSpec The default implementation throws an instance of
         * {@link UnsupportedOperationException} and performs no other action.
         */
        @Override
        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();

        }
    }
}

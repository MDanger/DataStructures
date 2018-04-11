package list;

import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;
import exceptions.NonComparableElementException;
import node.LinearNode;

public abstract class LinkedList<T> implements ListADT<T> {
    LinearNode head, tail;
    int count;

    public LinkedList(){
        head = tail = null;
        count = 0;
    }

    public LinkedList(T element){
        head.setElement(element);
        tail.setElement(element);
        count++;
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
        LinearNode<T> runner = head;
        while (runner.getNext() != null && comparableElement.compareTo(runner.getElement())>0){
            runner.setNext(runner.getNext());
        }
        LinearNode<T> insert = new LinearNode<T>(element);
        insert.setNext(runner.getNext());
        runner.setNext(insert);
        count++;

    }

    public void addToFront(T element){
        LinearNode<T> newHead = new LinearNode<T>(element);
        newHead.setNext(head);
        head = newHead;
        count++;

    }


    public void addToTail(T element){
        LinearNode<T> newTail = new LinearNode<T>(element);
        newTail.setNext(null);
        tail.setNext(newTail);
        tail = newTail;
        count++;
    }
    public void addAfter(T element, T target ){

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
        LinearNode<T> previous = null;
        LinearNode<T> current = head;
        while (current != null && !found) {
            if (element.equals(current.getElement())) found = true;
            else
                previous = current;
            current = current.getNext();

        }
        if (!found) throw new ElementNotFoundException("linkedlist");
        if (size() == 1) head = tail = null;
        else if (current.equals(head)) head = current.getNext();
        else if (current.equals(tail)){
            tail = previous;
            tail.setNext(null);
        } else {
            previous.setNext(current.getNext());
        }
        count--;
        //return current.getElement();
    }

    /**
     * Remove and return the first element in list
     * @return first element from list
     * @throws EmptyCollectionException
     */
    public T removeFirst()throws  EmptyCollectionException {
        if (isEmpty()) throw new EmptyCollectionException("linkedlist");
        T result = (T) head.getElement();
        head.setNext(head.getNext());
        count--;
        return result;
    }

    /**
     * Remove and return last element from list. Is an O(n) operation in a singly linked list like this. Since it has to
     * iterate through to reset tail pointer.
     * @return last element in this list
     */
    public T removeLast(){
        T result = (T) tail.getElement();
        tail = null;
        LinearNode<T> runner = head;
        count--;

        while (runner.getNext() != null){
            runner=runner.getNext();
        }
        tail = runner;
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

}

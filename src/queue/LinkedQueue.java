package queue;

import exceptions.EmptyCollectionException;
import stack.LinearNode;

public class LinkedQueue<T> implements QueueADT<T> {

    private int count;
    private LinearNode<T> head, tail;

    /**
     * Creates an empty queue
     */
    public LinkedQueue(){
        count = 0;
        head = tail = null;
    }

    /**
     * @param element the element to be added to rear
     */
    @Override
    public void enqueue(T element) {
        if (count==0){
            head.setElement(element);
        }
        tail.setNext(new LinearNode<T>(element));
        tail = tail.getNext();
        count++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()){
            throw new EmptyCollectionException("queue");
        }
        T result = head.getElement();
        head = head.getNext();
        count--;
        if (isEmpty()){
            tail = null;
        }
        return result;
    }

    @Override
    public T peek() {
        if (isEmpty()){
            throw new EmptyCollectionException("queue");
        }
        T result = head.getElement();

        return result;
    }

    @Override
    public boolean isEmpty() {
        if (count == 0){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public String toString(){
     StringBuilder result = new StringBuilder();
     int n = count;
     while (n>=0){
         result.append(head.getElement());
         result.append(", ");
         n--;
         head=head.getNext();
     }

     return result.toString();
    }
}

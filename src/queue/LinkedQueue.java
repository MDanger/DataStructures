package queue;

import exceptions.EmptyCollectionException;
import node.LinearNode;

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
        LinearNode<T> newNode = new LinearNode<T>(element);
        if (isEmpty()){
            head = newNode;

        }else {
            tail.setNext(newNode);
        }
        tail = newNode;
        count++;
//        System.out.println("enqueue: head.get" +head.getElement());
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
     LinearNode<T> runner = head;
     while (n > 1 ){
         result.append(runner.getElement());
         result.append(", ");
         n--;
         runner = runner.getNext();
     }
     result.append(runner.getElement());

     return result.toString();
    }
}

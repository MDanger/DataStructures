package queue;

import exceptions.EmptyCollectionException;

public class CircularArrayQueue<T> implements QueueADT<T> {

    private  final static int DEFAULT_CAPACITY = 100;
    private int myFront, myRear, myCount;
    private T[] myQueue;

    /**
     * default constuctor makes empty array of DEFAULT_CAPACITY
     */
    public CircularArrayQueue(){
        this(DEFAULT_CAPACITY);
    }

    /**
     * constructor with provided capacity
     * @param initialCapacity
     */
    public CircularArrayQueue(int initialCapacity){
        myQueue = (T[]) (new Object[initialCapacity]);
        myFront = myRear = myCount = 0;
    }

    @Override
    public void enqueue(T element) {
        if (isEmpty()){
            myQueue[myFront] = element;
        }
        if (size() == myQueue.length){
            expandCapacity();
        }
        myQueue[myRear] = element;
        myRear = myRear++ % myQueue.length;
        myCount++;

    }

    /**
     * Creates a new array backing for this queue with double size
     *
     */
    private void expandCapacity(){
        T[] larger = (T[]) (new Object[myQueue.length *2]);
        for (int i = 0; i < myCount; i++){
            larger[i] = myQueue[myFront];
            myFront =  myFront++ % myQueue.length;
        }
        myFront =0;
        myRear = myCount;
        myQueue = larger;
    }
    @Override
    public T dequeue() {
        if (isEmpty()){
            throw new EmptyCollectionException("queue");
        }
        T result = myQueue[myFront];
        myQueue[myFront] = null;
        myFront = myFront++ % myQueue.length;
        myCount--;

        return result;
    }

    @Override
    public T peek() {
        if (isEmpty()){
            throw new EmptyCollectionException("queue");
        }
        T result = myQueue[myFront];
        return result;
    }

    @Override
    public boolean isEmpty() {
        if (myCount==0){
            return true;
        } else {
            return false;
        }

    }

    @Override
    public int size() {
        return myCount;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        int n = myCount;
        int i = myFront;
        while (n >= 0){
            result.append(myQueue[i]);
            result.append(", ");
            i++;
            n--;
        }
        return result.toString();
    }
}

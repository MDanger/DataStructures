package list;

import exceptions.ElementNotFoundException;
import exceptions.NonComparableElementException;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class ArrayList<T> implements ListADT<T>, Iterable<T> {
    private final  static int DEFAULT_CAPACITY = 100;
    private final static int NOT_FOUND = -1;
    protected int rear;
    protected T[] list;
    protected int modCount;

    public ArrayList(){
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int initialCapacity){
        rear = 0;
        list = (T[]) (new Object[initialCapacity]);
        modCount = 0;
        rear = 0;
    }

    /**
     * Ordered list operation add element to list
     * @param element to add to list
     */
    public void add(T element){
        if (!(element instanceof Comparable)) throw new NonComparableElementException("ordered list");
        Comparable<T> comparableElement = (Comparable<T>) element;
        if (size() == list.length) expandCapacity();
        //find location to insert
        int i = 0;
        while (i < rear && comparableElement.compareTo(list[i]) > 0) {
            i++;
        }
        //shift existing elements
        for (int shift = rear; shift>i; shift--){
            list[shift]= list[shift-1];
        }
        //insert element
        list[i] = element;
        rear++;
        modCount++;

    }

    public void addToFront(T element){
        if (size() == list.length) expandCapacity();
        int i = rear-1;
        while (i >= 0){
            list[i+1] = list[i];
            i--;
        }
        list[0] = element;
        rear++;
        modCount++;
    }

    public void addToTail(T element){
        if (size() == list.length) expandCapacity();
        list[rear] = element;
        modCount++;
        rear++;
    }

    public void addAfter(T element, T target){
        if (size() == list.length) expandCapacity();

        int i = 0;
        //find target
        while (i < rear && !target.equals(list[i])){
            i++;
        }
        if(i==rear) throw new ElementNotFoundException("unordered list");
        i++;
        //shift elements
        for (int shift = rear; shift>i; shift--){
            list[shift] = list[shift-1];
        }
        //insert element
        list[i] =  element;
        modCount++;
        rear++;
    }

    @Override
    public void remove(T element) {
        T result;
        int index = find(element);
        if (index ==NOT_FOUND) throw new ElementNotFoundException("arraylist");
        result = list[index];
        //shift list after item removed
        for (int i = index; i<rear; i++){
            list[i] = list[i+1];
        }
        list[rear] = null;
        modCount++;
        rear--;
//        return result;


    }

    @Override
    public T removeFirst() {
        int i = 0;
        T result = list[i];
        while (i < rear){
            list[i] = list[i+1];
            i++;
        }
        modCount++;
        rear--;
        return result;
    }

    @Override
    public T removeLast() {
        T result = list[rear-1];
        list[rear] = null;
        rear--;
        return result;
    }

    @Override
    public T first() {

        return list[0];
    }

    @Override
    public T last() {
        return list[rear-1];
    }

    public boolean contains(T element){
        return (find(element) != NOT_FOUND);
    }

    @Override
    public boolean isEmpty() {
        if (rear ==0) return true;
        else return false;
    }

    @Override
    public int size() {

        return rear;
    }

    @Override
    public Iterator<T> Iterator() {
        return new ArrayListIterator();
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < rear-1){
            result.append(list[i]);
            result.append(", ");
            i++;
        }
        result.append(list[i]);
        return result.toString();
    }

    private int find(T element){
        int i = 0;
        int result = NOT_FOUND;
        if (!isEmpty()){
            while (result == NOT_FOUND && i < rear){
                if (element.equals(list[i])){
                    result = i;
                } else {
                    i++;
                }
            }
        }
        return result;
    }

    private void expandCapacity(){
        T[] larger = (T[]) (new Object[list.length*2]);
        for (int i = 0; i < rear; i++){
            larger[i] = list[i];
        }
        list = larger;
    }

    /**
     * iterator over elements of the ArrayList
     */
    private class ArrayListIterator implements Iterator{
        private int iteratorModCount;
        private int current;

        public ArrayListIterator(){
            iteratorModCount = modCount;
            current = 0;
        }

        /**
         * Returns true if iterator has a next element
         * @return true if there is a next element in list.
         * @throws java.util.ConcurrentModificationException
         */
        @Override
        public boolean hasNext() throws ConcurrentModificationException {
            if (iteratorModCount != modCount) throw new ConcurrentModificationException();

            return (current < rear);
        }

        /**
         * Returns next element in list
         * @return nest element in list
         * @throws ConcurrentModificationException
         */
        @Override
        public T next() throws ConcurrentModificationException {
            if (!hasNext()) throw new NoSuchElementException();
            current++;
            return list[current-1];
        }

        /**
         * Removes this elment in list
         * @throws UnsupportedOperationException
         */
        @Override
        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();

        }
    }


}

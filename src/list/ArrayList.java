package list;

import exceptions.ElementNotFoundException;
import exceptions.NonComparableElementException;

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
    }

    @Override
    public void remove(T element) {
        T result;
        int index = find(element);
        if (index ==NOT_FOUND) throw new ElementNotFoundException("arraylist");
        result = list[index];
        rear--;
        //shift list after item removed
        for (int i = index; i<rear; i++){
            list[i] = list[i+1];
        }
        list[rear] = null;
        modCount++;

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

    public boolean contains(T element){
        return (find(element) != NOT_FOUND);
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

    private void expandCapacity(){
        T[] larger = (T[]) (new Object[list.length*2]);
        for (int i = 0; i < modCount; i++){
            larger[i] = list[i];
        }
        list = larger;
    }
    public void addToFront(T element){
        if (size() == list.length) expandCapacity();
        int i = modCount;
        while (i >= 0){
            list[i+1] = list[i];
        }
        list[0] = element;
    }

    public void addTorear(T element){
        if (size() == list.length) expandCapacity();
        list[modCount] = element;
        modCount++;
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
        rear++;
        modCount++;
    }

    @Override
    public T removeFirst() {
        int i = 0;
        T result = list[i];
        i++;
        while (i < modCount){
            list[i] = list[i+1];
            i++;
        }

        return result;
    }

    @Override
    public boolean isEmpty() {
        if (modCount==0) return true;
        else return false;
    }

    @Override
    public int size() {

        return modCount;
    }

    @Override
    public T first() {

        return list[0];
    }

    @Override
    public T last() {
        return list[modCount];
    }

    @Override
    public T removeLast() {
        T result = list[modCount];
        list[modCount] = null;
        return result;
    }


}

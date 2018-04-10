package list;

public interface OrderedListADT<T> extends ListADT<T> {
    /**
     * Adds given element at the proper location
     * @param element the element to be added to list
     */
    public void add(T element);
}

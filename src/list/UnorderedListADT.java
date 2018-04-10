package list;

public interface UnorderedListADT<T> extends ListADT<T> {
    /**
     * Adds given element to front of list
     * @param element to be added
     */
    public void addToFront(T element);

    /**
     * Add given element to rear of list
     * @param element to be added
     */
    public void addToRear(T element);

    /**
     * Add the given element after the given target element in the list
     * @param element to be added
     * @param target element in list to add the given element after
     */
    public void addAfter(T element, T target);

}

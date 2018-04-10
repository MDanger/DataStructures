package exceptions;

public class NonComparableElementException extends RuntimeException {
    /**
     * Sets up this exception with the appropriate message.
     * @param theCollection name of the collection
     */
    public NonComparableElementException(String theCollection) {
        super("The element is not comparable to elements in this " + theCollection);
    }
}

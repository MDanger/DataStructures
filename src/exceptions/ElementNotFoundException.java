package exceptions;

public class ElementNotFoundException extends RuntimeException{
    /**
     * Sets up this exception with the appropriate message.
     * @param theCollection name of the collection
     */
    public ElementNotFoundException(String theCollection){
        super("The " +theCollection+ " does not contain this element.");
    }

}

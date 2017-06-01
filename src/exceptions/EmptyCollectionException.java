package exceptions;

/**
 * Represents a situation in which the collection is empty.
 * 
 * @author Morgan Blackmore
 * @version 6/1/17
 *
 */
public class EmptyCollectionException extends RuntimeException{

	/**
	 * Sets up this exception with the appropriate message.
	 * @param theCollection name of the collection
	 */
	public EmptyCollectionException(String theCollection){
		super("The " +theCollection+ " is empty.");
	}
}

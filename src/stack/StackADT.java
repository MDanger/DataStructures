package stack;
/**
 * 
 */

/**
 * Defines interface to a stack collection
 * 
 * @author Morgan Blackmore
 * 
 * @version 6/1/17
 *
 */
public interface StackADT<T> {

	/**
	 * Adds theElement to the top of this stack.
	 * 
	 * @param theElement
	 */
	public void push(T theElement);
	
	/**
	 * Removes and returns the first element from the top of this stack.
	 * 
	 * @return the element removed from the stack
	 */
	public T pop();
	
	/**
	 * Returns without removing the top element of this stack.
	 * 
	 * @return the element on top of the stack
	 */
	public T peek();
	
	/**
	 * Returns true is this stack contains no elements.
	 * 
	 * @return true is stack is empty
	 */
	public boolean isEmpty();
	
	/**
	 * Returns the number of elements in this stack.
	 * 
	 * @return the number of elements in the stack
	 */
	public int size();
	
	/**
	 * Returns a string representation of this stack.
	 * 
	 * @return a string representation of this stack
	 */
	public String toString();
}

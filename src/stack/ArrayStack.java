/**
 * 
 */
package stack;

import java.util.Arrays;

import exceptions.EmptyCollectionException;

/**
 * An array-based implementation of a stack.
 * 
 * @author Morgan Blackmore
 * @version 6/1/17
 *
 */
public class ArrayStack<T> implements StackADT<T> {
	
	private final static int DEFAULT_CAPACITY = 100;

	private int myTop;

	private T[] myStack;
	
	/**
	 * Creates an empty stack using the default capacity.
	 */
	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * Creates an empty stack using the provided capacity.
	 * @param theInitialCapacity the starting size of the array
	 */
	public ArrayStack(int theInitialCapacity) {
		myTop = 0;
		myStack = (T[]) (new Object[theInitialCapacity]);
	}

	/**
	 * Add theElement to top of this stack, expanding capacity of array if necessary.
	 */
	@Override
	public void push(T theElement) {
		if (size() == myStack.length) {
			expandCapacity();
		}
		
		myStack[myTop] = theElement;
		myTop++;
	}
	
	/**
	 * Helper method to double size of array.
	 */
	private void expandCapacity(){
		myStack = Arrays.copyOf(myStack, myStack.length*2);
		
	}

	/**
	 * Removes the element at the top of this stack and returns it
	 * 
	 * @return the element removed from the top of the stack
	 * @throws EmptyCollectionException
	 */
	@Override
	public T pop() throws EmptyCollectionException {
		if (isEmpty()){
			throw new EmptyCollectionException("stack");
		}
		
		myTop--;
		T theElement = myStack[myTop];
		myStack[myTop]= null;
		return theElement;
	}

	/**
	 * Returns the top element without removing it.
	 * 
	 * @return the element removed from the top of the stack
	 * @throws EmptyCollectionException
	 */
	@Override
	public T peek() {
		if (isEmpty()){
			throw new EmptyCollectionException("stack");
		}
		
		T theElement = myStack[myTop-1];
		return theElement;
	}

	/**
	 * Returns whether the stack has any elements.
	 * 
	 * @return boolean whether stack has elements
	 */
	@Override
	public boolean isEmpty() {
		boolean result = false;
		if (myTop == 0) {
			result = true;
		}
		return result;
	}

	/**
	 * Returns the number of elements in the stack.
	 * 
	 * @return int of size of stack
 	 * @throws EmptyCollectionException
	 */
	@Override
	public int size() {

		return myTop;
	}

	/**
	 * Returns string of elements in stack separated by comma, top element to left.
	 *
	 * @return string
	 * @throws EmptyCollectionException("stack")
	 */
	@Override
	public String toString(){
		if (isEmpty()){
			throw new EmptyCollectionException("stack");
		}
		StringBuilder result = new StringBuilder();
		int n = myTop-1;
			while (n > 0){
				result.append(myStack[n]);
				result.append(", ");
				n--;
			}
		result.append(myStack[n]);
		return result.toString();
	}

}

package stack;

import exceptions.EmptyCollectionException;
import node.LinearNode;

public class LinkedStack<T> implements StackADT<T> {
	
	private int myCount;
	private LinearNode<T> myTop;
	
	/**
	 * Creates an empty stack.
	 */
	public LinkedStack(){
		myCount = 0;
		myTop = null;
	}

	/**
	 * Adds the given element to the top of the stack.
	 * @param theElement of type T 
	 */
	@Override
	public void push(T theElement) {
		LinearNode<T> temp = new LinearNode(theElement);
		
		temp.setNext(myTop);
		myTop = temp;
		myCount++;
		
	}

	/**
	 * Returns the element at the top and removes it.
	 * @return element in top node
	 * @throws EmptyCollectionException
	 */
	@Override
	public T pop() throws EmptyCollectionException {
		if (isEmpty()) {
			throw new EmptyCollectionException("stack");
		}
		
		T result = myTop.getElement();
		myTop = myTop.getNext();
		myCount--;
		return result;
	}

	/**
	 * returns the element at the top without removing it.
	 * @return the element at the top
	 * @throws EmptyCollectionException
	 */
	@Override
	public T peek() throws EmptyCollectionException {
		if (isEmpty()){
			throw new EmptyCollectionException("stack");
		}
		return myTop.getElement();
		
	}

	/**
	 * Returns boolean if there is myCount is 0.
	 * @return boolean if is empty
	 */
	@Override
	public boolean isEmpty() {
		boolean isEmpty = true;
		if (myCount > 0){
			isEmpty = false;
		}
		return isEmpty;
	}

	/**
	 * Return count of items in stack
	 * @return int
	 * @throws EmptyCollectionException
	 */
	@Override
	public int size(){
		return myCount;
	}

	@Override
	public String toString(){
		if (isEmpty()) {
			throw new EmptyCollectionException("stack");
		}
		StringBuilder result = new StringBuilder();
		LinearNode<T> runner = myTop;
		int n = myCount;
		while (n > 1){
			result.append(runner.getElement());
			result.append(", ");
			n--;
			runner = runner.getNext();
		}

		result.append(runner.getElement());
		return result.toString();

	}

}

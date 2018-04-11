package node;

public class LinearNode<T> {

	private LinearNode<T> myNext;
	private T myElement;
	
	/**
	 * Creates empty node.
	 */
	public LinearNode() {
		myNext = null;
		myElement = null;
	}
	
	/**
	 * Creates a node, storing the given parameter.
	 */
	public LinearNode(T theElement) {
		myNext = null;
		myElement = theElement;
	}
	
	/**
	 * Returns the node that follows this one.
	 */
	public LinearNode getNext() {
		return myNext;
	}
	
	/**
	 * Sets value of next.
	 */
	public void setNext(LinearNode<T> theNext) {
		myNext = theNext;
	}
	
	/**
	 * Returns element from this node.
	 */
	public T getElement() {
		return myElement;
	}
	
	/**
	 * Sets the element stored in this node.
	 */
	public void setElement(T theElement) {
		myElement = theElement;
	}
}

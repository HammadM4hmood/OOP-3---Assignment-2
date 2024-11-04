package utilities;

public interface StackADT<E> {
	
	/*
	 * Adds an element to top of the stack
	 * 
	 * @param element to be added
	 * */
	void push(E element);
	
	/*
	 * removes the top element from the stack
	 * 
	 * @return the removed element
	 * */
	E pop();
	
	/*
	 * return the top element from the stack
	 * 
	 * @return Element at the top of the stack
	 * */
	E peek();
	
	/*
	 * compares this stack to another stack to check if they are equal
	 * 
	 * @param the stack to compare to
	 * @return A true if the stacks are equal, otherwise a false
	 * */
	boolean isEqual(StackADT<E> that);
	
	/*
	 * Iterators through the stack
	 * 
	 * @return an iterator through the stack
	 * */
	Iterator<E> iterator();
	
	
	/*
	 * returns an array which contains the elements from the stack
	 * 
	 * @return Array of the stack
	 * */
	Object[] toArray();
	
	/*
	 * Searches for a an element
	 * 
	 * @param the element to be searched for
	 * 
	 * @return returns the element closest to the top
	 * */
	int search(E obj);
	
	/*
	 * Checks if the stack contains the element
	 * 
	 * @param the element to search for
	 * 
	 * @return true if the element exist, else false
	 * */
	boolean contains(E obj);
	
	/*
	 * returns the size of the stack
	 * 
	 * @return size of the stack
	 * */
	int size();
	
	/*
	 * Checks if the stack is empty
	 * 
	 * @return True if the stack is empty else False
	 * */
	boolean isEmpty();
	
	/*
	 * removes all elements from the stack
	 * */
	void clear();
}

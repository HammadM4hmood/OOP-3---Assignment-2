package utilities;

public interface StackADT<T> {
	
	void push(T element);
	
	T pop();
	
	T peek();
	
	boolean isEqual(T element);
	
	Iterator<T> iterator();
	
	T[] toArray(T[] copy);
	
	int search(T obj);
	
	boolean contains(T obj);
	
	int size();
	
	boolean isEmpty();
	
	void clear();
}

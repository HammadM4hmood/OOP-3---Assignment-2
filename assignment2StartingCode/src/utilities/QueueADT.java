package utilities;

public interface QueueADT<T> {
    /**
     * Adds an element to the back of the queue.
     *
     * @param element the element to add
     */
    void enqueue(T element);

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return the element at the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    T dequeue();

    /**
     * Returns the element at the front of the queue without removing it.
     *
     * @return the element at the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    T peek();

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in the queue.
     *
     * @return the size of the queue
     */
    int size();

    /**
     * Clears all elements from the queue.
     */
    void clear();
}

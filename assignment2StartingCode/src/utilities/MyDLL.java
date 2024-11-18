package utilities;

import java.io.Serializable;
import java.util.NoSuchElementException;

public class MyDLL<E> implements ListADT<E>, Serializable {
    private static final long serialVersionUID = 1L;

    private MyDLLNode<E> head;
    private MyDLLNode<E> tail;
    private int size;

    public MyDLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean add(E toAdd) throws NullPointerException {
        if (toAdd == null) throw new NullPointerException("Cannot add null element.");
        MyDLLNode<E> newNode = new MyDLLNode<>(toAdd);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (toAdd == null) throw new NullPointerException("Cannot add null element.");
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Invalid index");

        MyDLLNode<E> newNode = new MyDLLNode<>(toAdd);
        if (index == 0) {
            if (head == null) {
                head = tail = newNode;
            } else {
                newNode.setNext(head);
                head.setPrev(newNode);
                head = newNode;
            }
        } else if (index == size) {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        } else {
            MyDLLNode<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            newNode.setNext(current);
            newNode.setPrev(current.getPrev());
            current.getPrev().setNext(newNode);
            current.setPrev(newNode);
        }
        size++;
        return true;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid index");
        MyDLLNode<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid index");
        MyDLLNode<E> toRemove = head;
        if (index == 0) {
            head = head.getNext();
            if (head != null) head.setPrev(null);
            else tail = null;
        } else {
            for (int i = 0; i < index; i++) {
                toRemove = toRemove.getNext();
            }
            if (toRemove.getNext() != null) {
                toRemove.getNext().setPrev(toRemove.getPrev());
            } else {
                tail = toRemove.getPrev();
            }
            if (toRemove.getPrev() != null) {
                toRemove.getPrev().setNext(toRemove.getNext());
            }
        }
        size--;
        return toRemove.getData();
    }

    @Override
    public E remove(E toRemove) throws NullPointerException {
        if (toRemove == null) throw new NullPointerException("Cannot remove null element.");
        MyDLLNode<E> current = head;
        while (current != null) {
            if (current.getData().equals(toRemove)) {
                if (current == head) {
                    head = head.getNext();
                    if (head != null) head.setPrev(null);
                    else tail = null;
                } else if (current == tail) {
                    tail = tail.getPrev();
                    if (tail != null) tail.setNext(null);
                } else {
                    current.getPrev().setNext(current.getNext());
                    current.getNext().setPrev(current.getPrev());
                }
                size--;
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (toChange == null) throw new NullPointerException("Cannot set null element.");
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid index");

        MyDLLNode<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        E oldData = current.getData();
        current.setData(toChange);
        return oldData;
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if (toFind == null) throw new NullPointerException("Cannot search for null element.");
        MyDLLNode<E> current = head;
        while (current != null) {
            if (current.getData().equals(toFind)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        if (toHold == null) throw new NullPointerException("Provided array cannot be null.");
        if (toHold.length < size) {
            toHold = (E[]) java.lang.reflect.Array.newInstance(toHold.getClass().getComponentType(), size);
        }
        MyDLLNode<E> current = head;
        int i = 0;
        while (current != null) {
            toHold[i++] = current.getData();
            current = current.getNext();
        }
        if (toHold.length > size) {
            toHold[size] = null;
        }
        return toHold;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        MyDLLNode<E> current = head;
        int i = 0;
        while (current != null) {
            array[i++] = current.getData();
            current = current.getNext();
        }
        return array;
    }

    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        if (toAdd == null) throw new NullPointerException("Cannot add from a null list.");
        boolean modified = false;
        Iterator<? extends E> it = toAdd.iterator();
        while (it.hasNext()) {
            this.add(it.next());
            modified = true;
        }
        return modified;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyDLLIterator();
    }

    private class MyDLLIterator implements Iterator<E> {
        private MyDLLNode<E> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() throws NoSuchElementException {
            if (!hasNext()) throw new NoSuchElementException("No more elements.");
            E data = current.getData();
            current = current.getNext();
            return data;
        }
    }
}

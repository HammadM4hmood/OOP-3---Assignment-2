package utilities;

import java.lang.reflect.Array;

public class MyArrayList<E> implements ListADT<E> {

		private static final long serialVersionUID = 1L;
		
		private int DEFAULT_LENGHT = 10;
		private E[] array;
		private int size;
		
		@SuppressWarnings("unchecked")
		public MyArrayList() {
			this.array = (E[]) new Object[DEFAULT_LENGHT];
			this.size = 0;
		}
			
		
		@Override
		public int size() {
			// TODO Auto-generated method stub
			return size;
		}
  
		@Override
		public void clear() {
			// TODO Auto-generated method stub
			for (int i = 0; i < size; i++) {
				array[i] = null;
			}
			size = 0;
		}
		
		@Override
		public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
			// TODO Auto-generated method stub
			if (toAdd == null) {
				throw new NullPointerException("Null elements cannot be added");
			}
			if (index < 0 || index > size) {
				throw new IndexOutOfBoundsException("Index out of bounds");
			}
			
			if (size == array.length) {
		        @SuppressWarnings("unchecked")
		        E[] newArray = (E[]) new Object[array.length * 2];
		        for (int i = 0; i < size; i++) {
		            newArray[i] = array[i];
		        }
		        array = newArray; 
		    }

		    for (int i = size; i > index; i--) {
		        array[i] = array[i - 1];
		    }

		    array[index] = toAdd;
		    size++; 

		    return true;
		}
		
		@Override
		public boolean add(E toAdd) throws NullPointerException {
			// TODO Auto-generated method stub
			if (toAdd == null) {
				throw new NullPointerException("Null elements cannot be added");
			}
			
			if (size == array.length) {
		        @SuppressWarnings("unchecked")
		        E[] newArray = (E[]) new Object[array.length * 2];
		        for (int i = 0; i < size; i++) {
		            newArray[i] = array[i];
		        }
		        array = newArray; 
		    }
			
			array[size++] = toAdd;
			
			return true;
		}
		@Override
		public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
			// TODO Auto-generated method stub
			if (toAdd == null) {
				throw new NullPointerException("Null elements cannot be added");
			}
			
			Iterator<? extends E> iterator = toAdd.iterator();
		    while (iterator.hasNext()) {
		        add(iterator.next());
		    }
		    return true;
		}
		
		@Override
		public E get(int index) throws IndexOutOfBoundsException {
			// TODO Auto-generated method stub
			if (index < 0 || index >= size()) {
				throw new IndexOutOfBoundsException("Invalid index");
			}
			
			return array[index];
		}
		@Override
		public E remove(int index) throws IndexOutOfBoundsException {
			// TODO Auto-generated method stub
			if (index < 0 || index >= size()) {
				throw new IndexOutOfBoundsException("Invalid index");
			}
			
			E removedElement = array[index];
			for (int i = index; i < size - 1; i++) {
				array[i] = array[i + 1];
			}
			
			size--;
			return removedElement;
		}
		
		@Override
		public E remove(E toRemove) throws NullPointerException {
			// TODO Auto-generated method stub
			if (toRemove == null) {
				throw new NullPointerException("Null elements cannot be added");
			}
			
			for (int i = 0; i < size; i++) {
				if (array[i].equals(toRemove)) {
					return remove(i);
				}
			}
			return null;
		}
		
		@Override
		public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
			// TODO Auto-generated method stub
			if (toChange == null) {
				throw new NullPointerException("cannot add null elements");
			}
			
			if (index < 0 || index >= size()) {
				throw new IndexOutOfBoundsException("Invalid Index");
			}
			
			E oldElement = array[index];
			array[index] = toChange;
			
			return oldElement;
		}
		
		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			if (size == 0) {
				return true;
			}
			
			return false;
		}
		@Override
		public boolean contains(E toFind) throws NullPointerException {
			// TODO Auto-generated method stub
			if (toFind == null) {
				throw new NullPointerException("cannot add null elements");
			}
			
			for (int i = 0; i < size; i++) {
				if (array[i].equals(toFind)) {
					return true;
				}
			}
			
			return false;
			
		}
		@Override
		public E[] toArray(E[] toHold) throws NullPointerException {
			// TODO Auto-generated method stub
			if (toHold.length < size)
			toHold = (E[]) Array.newInstance(toHold.getClass().getComponentType(), size);
			    else if (toHold.length > size)
			    toHold[size] = null;
			     System.arraycopy(array, 0, toHold, 0, size);
			     return toHold;
		}
		@Override
		public Object[] toArray() {
			// TODO Auto-generated method stub
			@SuppressWarnings("unchecked")
			E[] newArray = (E[]) new Object[size];
		    System.arraycopy(array, 0, newArray, 0, size);
		    return newArray;
		}
		@Override
		public Iterator<E> iterator() {
			// TODO Auto-generated method stub
			Iterator<E> it =  new Iterator<E>() {
		        private int currentIndex  = 0;

		        @Override
		        public boolean hasNext() {
		            return currentIndex  < size && array[currentIndex] != null;
		        }

		        @Override
		        public E next() {
		            return array[currentIndex++];
		        }
		    };
			return it;
		}
		
}

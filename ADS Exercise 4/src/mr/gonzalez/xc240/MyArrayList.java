package mr.gonzalez.xc240;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import structures.RandomAccessListI;

/**
 * Custom ArrayList
 *
 * <p>As a follow up assignment for a guy who want to build is own List types, this is a custom arrayList</p>
 * <p>It was testing using Exercise 3</p>
 *
 * ADS Ex04: Exercise 4
 *
 * @author Sujay Swain
 *
 */
public class MyArrayList<E> implements RandomAccessListI<E>, Iterable<E> {
	public static final int CAPACITY_DEFAULT=10;		//initial default size of array, you may change this
	public static final double CAPACITY_MULTIPLIER=2;	//initial default multiplier when resizing array, you may change this
	private E[] store; 									//array
	private int numElements;							//logical size of array
	
	
	
	/**
	 * Constructor.  Note the cast: We can't make arrays of a type parameter, so we make
	 * an array of objects and cast it to E[].  Create new array with given size.
	 * @param initialCapacity
	 */
	
	public MyArrayList(int initialCapacity){
		store = (E[]) new Object[initialCapacity];
	}
	
	/*
	 * Constructor.  Create new array with default size
	 */
	/**
	 * Create ArrayList with default capacity
	 */
	@SuppressWarnings("unchecked")
	public MyArrayList(){
		numElements = 0;
		store=(E[])new Object[CAPACITY_DEFAULT];
	}

	

	/**
	 * Adds an element to the array.  Resize if necessary.
	 */
	public void add(E toAdd) {
		if (checkResize()) {
		    resize();
        }
        store[numElements] = toAdd;
		numElements ++;
	}

	/**
	 * Get the logical size of the array
	 */
	public int size() {
		return numElements;
	}
 

	/**
	 * Checks whether the parameter element is in the array.  Use an iterator.
	 */
	public boolean contains(Object val) {
	    ArrayListIterator iterator = new ArrayListIterator();
	    while (iterator.hasNext()) {
            if (iterator.next().equals(val)) {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
	}

	

	/**
	 * Returns an Object[] of the LOGICAL SIZE of the instance variable array.
	 * i.e. a perfectly sized array of elements.
	 *
	 */
	public Object[] toArray() {
		Object[] niceList = new Object[numElements];
		for (int x = 0; x < numElements; x++) {
		    niceList[x] = store[x];
        }
		return niceList;
	}


	/**
	 * Is the list empty?
	 */
	public boolean isEmpty() {
		if (store.length == 0)
		    return true;
        else
		    return false;
	}


	/**
	 * Compares logical size and physical size of array.  Do we need a resize?  
	 * There must always be space for a new element.
	 * @return true if resize is required (no capacity left)
	 */
	private boolean checkResize() {
		return store.length == numElements;
	}


	/**
	 * Create a new, larger array via the Arrays class, and it's copyOf method, google if you'd like, and copy everything
	 * from the array into store.  New array should be larger by a factor of CAPACITY_MULTIPLIER
	 */
	private void resize(){
        store = Arrays.copyOf(store, (int) (store.length * CAPACITY_MULTIPLIER));
	}


	 
	/**
	 * IMPORTANT METHOD
	 * Adds this element at the given index.  Shift everything else and resize as necessary.
	 * If trying to add an element with an invalid index, throw an IndexOutOfBoundsException.  For
	 * example, if you are trying to add an element at index 7 to an ArrayList with only 3 elements.
	 * Adding an element at index 3 to an ArrayList of 3 elements should not throw an exception.
	 */
	public void add(int i, E value) {
        if (checkResize()){
            resize();
        }

        for(int j = store.length-1; j > i; j--){
            store[j] = store[j - 1];
        }
        store[i] = value;
        numElements++;
	}


	/**
	 * Set the element at the given index to this value.
	 * Throw an IndexOutOfBounds Exception if the index is out of range
	 */
	public E set(int i, E value) {
        store[i] = value;

		return value;
	}


	/**
	 * IMPORTANT METHOD
	 * Remove the element at the given index; shift everything else and resize as necessary.
	 * Return the element that was removed from the list.
	 * Throw an IndexOutOfBounds Exception if the index is out of range
	 */
	@SuppressWarnings("unchecked")
	public E remove(int i) {

		if (numElements < store.length/CAPACITY_MULTIPLIER) {
			E[] storeNew = (E[]) new Object[store.length/(int) CAPACITY_MULTIPLIER];
			for (int x = 0; x < store.length; x++) {
				if (store[x] != null) {
					storeNew[x] = store[x];
				}
			}
			store = storeNew;
		}

		E returnVal = store[i];
		store[i] = null;
		numElements--;

		E[] storeNew = (E[]) new Object[store.length];
		int counter = 0;
		for (int x = 0; x < store.length; x++) {
			if (store[x] != null) {
				storeNew[counter] = store[x];
				counter++;
			}
		}
		store = Arrays.copyOf(storeNew, store.length);

		return returnVal;
	}

	

	/**
	 * Return the element at the given index.
	 * Throw an IndexOutOfBounds Exception if the index is out of range
	 */
	public E get(int i) {
		return store[i];
	}
	

	/**
	 * Remove the first instance of the value, return true if the list contained the specified element.
	 */
	public boolean remove(E val) {
		if (contains(val)) {
			for (int x = 0; x < store.length; x++) {
				if (this.get(x).equals(val)) {
					this.remove(x);
					return true;
				}
			}
		}
		return false;
	}


	/**
	 * Empty the array list.  Think: Do you NEED to set everything to null?
	 */

    @SuppressWarnings("unchecked")
	public void clear() {
		// TODO Implement this method! What if you just set numElements to 0 and then resized?
        E[] storeNew = (E[]) new Object[10];
        store = Arrays.copyOf(storeNew, CAPACITY_DEFAULT);
	}


	/**
	 * create and return a new instance of the inner class ArrayListIterator
	 */
	public Iterator<E> iterator() {
        return new ArrayListIterator();
	}
	


	/**
	 * This is an inner class that defines an iterator for the MyArrayList
	 *
	 */
	public class ArrayListIterator implements Iterator<E>{
		
		private int at=0;						//index of current element
		private boolean readyToDelete=false;	//ready to remove an element?

		/**
		 * Compare where we are to the logical size of the array.  Is there a next element?
		 * Returns true if the iteration has more elements. (In other words, returns true if next() would return an element rather than throwing an exception.)
		 */
		public boolean hasNext() {
			return at <= numElements;
		}

	
		/**
		 * If the iteration has no more elements, throw a NoSuchElementException
		 * Otherwise, increment the current element tracker, flip your ready to delete flag, and
		 * return the previous (current-1) element.
		 */
		public E next() {
			if (!hasNext()) {
			    throw new NoSuchElementException();
            }
			readyToDelete = !readyToDelete;
			remove();
			at++;
			return store[at - 1];
		}


		/**
		 * Removes from the underlying collection the last element returned by this iterator. 
		 * This method can be called only once per call to next(). Again: A call to remove MUST 
		 * be preceded by a call to next.  That's when we throw the exception.The behavior of an 
		 * iterator is unspecified if the underlying collection is modified while the iteration
		 * is in progress in any way other than by calling this method.
		 * <p>
		 * If we've never before called next OR if we've already called remove since the last call to next, 
		 * throw an IllegalStateException
		 * Else adjust your delete flag and remove the appropriate element.
		 * 
		 * Remember, you can call an outer-class method via: OuterClass.this.method()
		 * 
		 */
		public void remove() {
			if (!readyToDelete) {
			    throw new IllegalStateException();
            }
            MyArrayList.this.remove(at - 1);
			readyToDelete = !readyToDelete;
		}
		
	}
	

}
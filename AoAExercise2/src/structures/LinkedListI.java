package structures;

import java.util.Iterator;

public interface LinkedListI<E> extends CollectionI<E>{
	/**
	 * For test classes only (not used in general) 
	 * @return
	 */
	public ListNodeI<E> getHead();
	
	/**
	 * Add a value to the end of the list
	 * @param value to add, can be null
	 */
	public void prepend(E value);
	
	
	/**
	 * Add a value to the start of the list
	 * @param value to add, can be null
	 */
	public void append(E value);
	
	/**
	 * Add value at the specified
	 * @param value to add, can be null
	 */
	public void add(int index, E value);
	
	/**
	 * Returns the element at the specified position in this list
	 * @param index of element to retrieve
	 */
	public E get(int index);
	
	/**
	 * Retrieves and removes the head of the list
	 * @return the old head
	 */
	public E remove();
	
	/**
	 * Removes the element at the specified position in this list
	 * @param index of element to remove
	 * @return the element formerly at that index
	 */
	public E remove(int index);
	
	/**
	 * Replaces the element at the specified position in this list with the specified element
	 * @param index to change
	 * @param value to replace with
	 * @return value formerly at given index
	 */
	public E set(int index, E value);
	
	/**
	 * Returns the number of elements in this list
	 * @return size of the linked list
	 */
	public int size();
	
	/*
	 * Remember that you'll also need to provide for iterators!  Likely do this
	 * by writing an inner class SimpleLinkedListIterator<E> that implements
	 * Iterator<E>
	 * 
	 * The version of add(E value) that comes from CollectionI should add the
	 * element to the head of the list.  This is the same thing as addFirst.
	 * You could even call your addFirst from add.
	 */
	
}

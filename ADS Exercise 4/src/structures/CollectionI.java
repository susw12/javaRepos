package structures;
 

/**
 * A number of elements, not necessarily ordered. 
 *
 * @param <V>
 */
public interface CollectionI<V> extends Iterable<V> {
	
	

	/**
	 * Add an element to the Collection
	 * @param val value to add 
	 */
	public void add(V val);
	
	/**
	 * Determine if an element is in the collection, using .equals()
	 * @param val search for this  
	 * @return true if found
	 */
	public boolean contains(Object o);
 

	/** 
	 * Returns an array containing all of the elements of this collection.
	 * @return all elements
	 * */
	public Object[] toArray( ); 
	

	/**
	 * Returns true if this collection contains no elements.
	 * @return true if there's an element in the list
	 */
	public boolean isEmpty();
	

	/**
	 * Returns the number of elements in this collection.
	 * @return element count
	 */
	public int size();

	/**
	 * Remove an element from the collection
	 * @param val remove this element
	 * @return true if element was present and removed
	 */
	public boolean remove(V val) ;

	/**
	 * Removes all of the elements from this collection
	 */
	public void clear();

	

}

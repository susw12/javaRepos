package structures;


/**
 * A collection that preserves insertion order, and supports operations on elements at particular positions
 * Note that in real life, the RandomAccess interface is actually just a "marker" interface, meaning it doesn't specify any actual methods.  Classes just implement it to show that they support fast arbitrary-index access.
 * @param <E> element class
 */
public interface RandomAccessListI<E> extends CollectionI<E> {

	/**
	 * Adds an element at a position. Moves existing and following elements to the right
	 * @param i index to add at
	 * @param value   to set
	 * @throws IndexOutOfBoundsException i<0 or i>size()
	 */
	public void add(int i,E value);
	
	/**
	 * Sets an element's value
	 * @param i index to set
	 * @param value new value  
	 * @throws IndexOutOfBoundsException i<0 or i>size()
	 * @return previous value 
	 */
	public E set(int i,E value);
	 
	/**
	 * Removes an element and shuffles elements on its right one position to left
	 * @param i index to remove 
	 * @throws IndexOutOfBoundsException i<0 or i>=size()
	 * @return returns the element removed
	 */
	public E remove(int i);
	 
	/**
	 * Gets an element  
	 * @param i index to get 
	 * @throws IndexOutOfBoundsException i<0 or i>=size()
	 * @return value at this position
	 */
	public E get(int i);
	  
}

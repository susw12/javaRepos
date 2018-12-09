package structures;
/**
 * 
 * @param <E> type of value
 */
public interface ListNodeI<E> {
	
	public E getValue( );
	public void setValue(E theNewValue);

	public ListNodeI<E> getNext( );
	public void setNext(ListNodeI<E> theNewNext);
	
}

package swain.sujay.xc240.ListType;

import structures.LinkedListI;
import structures.ListNodeI;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Custom ListType
 *
 * <p>As a follow up assignment for a guy who want to build is own List types, this is a custom ListType</p>
 *
 * ADS Ex04: Exercise 4
 *
 * @author Sujay Swain
 *
 */

public class MyLinkedList<E> implements LinkedListI<E>, Iterable<E> {
    private SimpleNode<E> head;
    private SimpleNode<E> tail;
    private int length;

    /**
     * Create an empty ListType
     */
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    /**
     * Create a ListType with only one value and length 1
     * @param node
     */
    public MyLinkedList(SimpleNode<E> node) {
        this.head = node;
        this.tail = node;
        this.length = 1;
    }

    /**
     * For test classes only (not used in general)
     * @return head
     */
    @Override
    public ListNodeI<E> getHead() {
        return this.head;
    }

    /**
     * Add a value to the start of the list
     * @param value to add, can be null
     */
    @Override
    public void append(E value) {
        SimpleNode<E> node = new SimpleNode<E>(value);
        if (this.head == null && this.tail == null) {
            this.head = node;
            this.tail = node;
            length++;
        }

        else {
            node.setNext(this.head);
            this.head = node;
            this.length++;
        }
    }

    /**
     * Add a value to the prepend of the list
     * @param value to add, can be null
     */
    @Override
    public void prepend(E value) {
        this.add(value);
    }

    /**
     * Add value at the specified
     * @param value to add, can be null
     */
    @Override
    public void add(int index, E value) {
        if (index == 0) {
            append(value);
        }
        else if (index == this.length) {
            prepend(value);
        }
        else {
            SimpleNode<E> breakPoint = this.head;
            SimpleNode<E> nodeAdd = new SimpleNode<E>(value);
            for (int x = 0; x < index - 1; x++) {
                breakPoint = (SimpleNode<E>) breakPoint.getNext();
            }
            nodeAdd.setNext(breakPoint.getNext());
            breakPoint.setNext(nodeAdd);
        }

    }

    /**
     * Returns the element at the specified position in this list
     * @param index of element to retrieve
     */
    @Override
    public E get(int index) {
        SimpleNode<E> currentLocation = this.head;
        for (int x = 0; x < index; x++) {
            currentLocation = (SimpleNode<E>) currentLocation.getNext();
        }
        return currentLocation.getValue();
    }

    /**
     * Retrieves and removes the head of the list
     * @return the old head
     */
    @Override
    public E remove() {
        E returnVal = this.head.getValue();
        this.head = (SimpleNode<E>) this.head.getNext();
        this.length--;
        return returnVal;
    }

    /**
     * Removes the element at the specified position in this list
     * @param index of element to remove
     * @return the element formerly at that index
     */
    @Override
    public E remove(int index) {
        if (index > 0) {
            SimpleNode<E> breakPoint = this.head;
            for (int x = 0; x < index - 1; x++) {
                breakPoint = (SimpleNode<E>) breakPoint.getNext();
            }
            E returnValue = breakPoint.getNext().getValue();
            breakPoint.setNext(breakPoint.getNext().getNext());
            length--;
            return returnValue;
        }
        else {
            E returnValue = this.get(0);
            remove();
            return returnValue;
        }
    }

    /**
     * Replaces the element at the specified position in this list with the specified element
     * @param index to change
     * @param value to replace with
     * @return value formerly at given index
     */
    @Override
    public E set(int index, E value) {
        SimpleNode<E> breakPoint = this.head;
        for (int x = 0; x < index; x++) {
            breakPoint = (SimpleNode<E>) breakPoint.getNext();
        }
        breakPoint.setValue(value);
        return value;
    }

    /**
     * Add an element to the Collection
     * @param val value to add
     */
    @Override
    public void add(E val) {
        SimpleNode<E> node = new SimpleNode<E>(val);
        if (this.head == null && this.tail == null) {
            this.head = node;
            this.tail = node;
            length++;
        }

        else {
            this.tail.setNext(node);
            this.tail = node;
            this.length++;
        }
    }

    /**
     * Determine if an element is in the collection, using .equals()
     * @param o search for this
     * @return true if found
     */
    @Override
    public boolean contains(Object o) {
        Iterator<E> iterator = this.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns an array containing all of the elements of this collection.
     * @return all elements
     * */
    @Override
    public Object[] toArray() {
        E[] store = (E[]) new Object[this.length];
        SimpleNode<E> breakPoint = this.head;
        for (int x = 0; x < this.length; x++) {
            store[x] = breakPoint.getValue();
            breakPoint = (SimpleNode<E>) breakPoint.getNext();
        }
        return store;

    }

    /**
     * Returns true if this collection contains no elements.
     * @return true if there's an element in the list
     */
    @Override
    public boolean isEmpty() {
        if (this.length == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Returns the number of elements in this collection.
     * @return element count
     */
    @Override
    public int size() {
        return this.length;
    }

    /**
     * Remove an element from the collection
     * @param val remove this element
     * @return true if element was present and removed
     */
    @Override
    public boolean remove(E val) {
        if (this.contains(val)) {
            for (int x = 0; x < this.length; x++) {
                if (this.get(x).equals(val)) {
                    this.remove(x);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Removes all of the elements from this collection
     */
    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    public class LinkedListIterator implements Iterator<E> {

        private SimpleNode<E> nextNode = head;

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E returnValue = nextNode.getValue();
            nextNode = (SimpleNode<E>) nextNode.getNext();
            return returnValue;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported");
        }
    }


}

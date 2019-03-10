package net.mr.gonzalez.exercise2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.Math;

/**
 A hash set.

 <p>
 Represents a hash set.
 Contains methods for adding, removing, and looking for things, as well as an iterator
 </p>

 3/10/19
 AOA EX02: HashSet
 @author Sujay Swain
 */

public class MyHashSet<E> extends java.lang.Object implements Iterable<E>{
    public static final int DEFAULT_INITIAL_CAPACITY = 10;
    public static final double LOAD_FACTOR = .75;
    private static final int PRIME = 223063091;
    private E[] hashTable;
    private int size;

    @SuppressWarnings("unchecked")
    public MyHashSet() {
        size = 0;
        hashTable = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public MyHashSet(int initialCapacity){
        size = 0;
        hashTable = (E[]) new Object[initialCapacity];
    }

    /**
     Adds an element to the set.

     <p>
     Adds an element to the hashtable
     First checks to make sure that the element is not already there
     Then it adds it to the hashtable, but makes the hashtable larger if needed
     </p>

     @param element
     @author Sujay Swain
     */
    @SuppressWarnings("unchecked")
    public void add(E element) {
        if (!this.contains(element)) {
            if (this.getCapacity()*LOAD_FACTOR <= this.getSize()+1) {
                E[] replacementArray = (E[]) new Object[this.getCapacity()*2];
                for (int x = 0; x < this.toArray().length; x++) {
                    int position = Math.abs((PRIME * this.toArray()[x].hashCode()) % replacementArray.length);
                    while (replacementArray[position] != null) {
                        if (position++ < replacementArray.length) {
                            position--;
                            position++;
                        }
                        else {
                            position = 0;
                        }
                    }
                    replacementArray[position] = (E) toArray()[x];
                }
                hashTable = replacementArray;
            }
            int position = Math.abs((PRIME * element.hashCode()) % hashTable.length);
            while (hashTable[position] != null) {
                if (position++ < hashTable.length) {
                    position--;
                    position++;
                }
                else {
                    position = 0;
                }
            }
            hashTable[position] = element;
            size++;
        }
    }

    /**
     * Checks if an element is in the hashset.
     *
     * <p>
     * Returns whether or not the element in hashtable
     * </p>
     *
     * @param element
     * @return Boolean Value
     * @author Sujay Swain
     */
    public boolean contains(E element) {
        for (int x = 0; x < this.getCapacity(); x++) {
            if (hashTable[x] == element) {
                return true;
            }
        }
        return false;
    }

    /**
     * Capacity return
     *
     * <p>
     *     Returns the total capacity for the hashtable
     * </p>
     * @return capacity
     * @author Sujay Swain
     */
    public int getCapacity() {
        return hashTable.length;
    }

    /**
     * Size return
     *
     * <p>
     *     Returns the current size AKA the number of elements in the hashtable
     * </p>
     * @return size
     * @author Sujay Swain
     */
    public int getSize() {
        return size;
    }

    /**
     * Removes an element
     *
     * <p>
     *     Removes an element from the hashtable as specifed
     * </p>
     * @param element
     * @author Sujay Swain
     */
    public void remove(E element) {
        if (this.contains(element)) {
            for (int x = 0; x < this.getCapacity(); x++) {
                if (hashTable[x] == element) {
                    hashTable[x] = null;
                    size--;
                }
            }
        }
    }

    /**
     * Returns a nice array
     *
     * <p>
     *     Returns the array in a readable and usable format
     * </p>
     * @return niceList
     * @author Sujay Swain
     */

    public Object[] toArray() {
        Object[] niceList = new Object[this.getSize()];
        int position = 0;
        for (int x = 0; x < this.getCapacity(); x++) {
            if (hashTable[x] != null) {
                niceList[position] = hashTable[x];
                position++;
            }
        }
        return niceList;
    }

    /**
     * Returns the table
     *
     * <p>
     *     Returns the hashtable in a object list format
     * </p>
     * @return hashTable
     * @author Sujay Swain
     */
    public Object[] getHashTable() {
        return hashTable;
    }

    /**
     * Returns an iterator
     *
     * <p>
     *     Returns an Iterator that can be used to iterate over all of the elements in the collection.
     * </p>
     *
     * @return Iterator
     * @author Sujay Swain
     */
    @Override
    public Iterator<E> iterator() {
        return new HashSetIterator();
    }

    public class HashSetIterator implements Iterator<E>{

        private int at=0;
        private E[] hashTableNice = (E[]) MyHashSet.this.toArray();

        /**
         * Checks feasability
         *
         * <p>
         *     Checks to see if there is a next element
         * </p>
         * @return Boolean Value
         * @author Sujay Swain
         */
        public boolean hasNext() {
            return at < size;
        }

        /**
         * Returns next value
         *
         * <p>
         *     Returns the next available value in the list
         * </p>
         * @return value
         * @author Sujay Swain
         */
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            at++;
            System.out.println(at);
            return hashTableNice[at - 1];
        }

        /**
         * Not needed
         */
        public void remove() {
            throw new UnsupportedOperationException("Not supported");
        }

    }
}
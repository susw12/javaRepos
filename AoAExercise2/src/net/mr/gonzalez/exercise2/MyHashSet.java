package net.mr.gonzalez.exercise2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyHashSet<E> extends java.lang.Object implements Iterable<E>{
    public static final int DEFAULT_INITIAL_CAPACITY = 10;
    public static final double LOAD_FACTOR = 10;
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

    public void add(E element) {
        if (this.contains(element)) {
            int position = (PRIME * hashCode(element)) % hashTable.length;
            while (hashTable[position] != null) {
                position++;
            }
            hashTable[position] = element;
            size++;
        }

    }

    public boolean contains(E element) {
        for (int x = 0; x < hashTable.length; x++) {
            if (hashTable[x] == element) {
                return true;
            }
        }
        return false;
    }

    public int getCapacity() {
        return hashTable.length;
    }

    public int getSize() {
        return size;
    }

    public void remove(E element) {
        if (this.contains(element)) {
            for (int x = 0; x < hashTable.length; x++) {
                if (hashTable[x] == element) {
                    hashTable[x] = null;
                }
            }
        }
    }

    private int hashCode(E element) {
        //return super.hashCode(element);
        return 860057;
    }


    @Override
    public Iterator<E> iterator() {
        return new HashSetIterator();
    }

    public class HashSetIterator implements Iterator<E>{

        private int at=0;
        private boolean readyToDelete=false;

        public boolean hasNext() {
            return at <= size;
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            readyToDelete = !readyToDelete;
            remove();
            at++;
            return hashTable[at - 1];
        }

        public void remove() {
            if (!readyToDelete) {
                throw new IllegalStateException();
            }
            MyHashSet.this.remove(hashTable[at - 1]);
            readyToDelete = !readyToDelete;
        }

    }
}

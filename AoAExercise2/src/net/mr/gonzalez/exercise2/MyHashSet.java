package net.mr.gonzalez.exercise2;

import javafx.scene.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.Math;

public class MyHashSet<E> extends java.lang.Object implements Iterable<E>{
    public static final int DEFAULT_INITIAL_CAPACITY = 10;
    public static final double LOAD_FACTOR = .75;
    private static final int PRIME = 223063091;
    private Node[] hashTable;
    private int size;

    @SuppressWarnings("unchecked")
    public MyHashSet() {
        size = 0;
        hashTable = new Node[DEFAULT_INITIAL_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public MyHashSet(int initialCapacity){
        size = 0;
        hashTable = new Node[initialCapacity];
    }

    @SuppressWarnings("unchecked")
    public void add(E element) {
        if (!this.contains(element)) {
            int position = (PRIME * element.hashCode()) % hashTable.length;
            while (hashTable[position] != null) {
                position++;
            }
            hashTable[position] = element;
            size++;
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
                System.out.print("ReplacementArray: [");
                for (int x = 0; x < replacementArray.length; x++) {
                    System.out.print(replacementArray[x] + ", ");
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

    public boolean contains(E element) {
        for (int x = 0; x < this.getCapacity(); x++) {
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
            for (int x = 0; x < this.getCapacity(); x++) {
                if (hashTable[x] == element) {
                    hashTable[x] = null;
                    size--;
                }
            }
        }
    }

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

    public Object[] getHashTable() {
        return hashTable;
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

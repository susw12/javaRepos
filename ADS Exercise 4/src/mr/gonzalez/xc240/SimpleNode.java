package mr.gonzalez.xc240;

import structures.ListNodeI;

public class SimpleNode<E>implements ListNodeI<E> {
    private E store;
    private ListNodeI<E> next;

    public SimpleNode() {
        this.store = null;
        this.next = null;
    }

    public SimpleNode(E value) {
        this.store = value;
        this.next = null;
    }

    @Override
    public E getValue() {
        return store;
    }

    @Override
    public void setValue(E theNewValue) {
        store = theNewValue;

    }

    @Override
    public ListNodeI<E> getNext() {
        return this.next;
    }

    @Override
    public void setNext(ListNodeI<E> theNewNext) {
        this.next = theNewNext;

    }
}

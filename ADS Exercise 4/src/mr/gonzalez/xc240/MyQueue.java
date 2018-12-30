package mr.gonzalez.xc240;

public class MyQueue<E>{
    MyLinkedList<E> store = new MyLinkedList<E>();

    public E pop() { return store.remove(store.size() - 1); }

    public void append(E val) { store.prepend(val); }
}
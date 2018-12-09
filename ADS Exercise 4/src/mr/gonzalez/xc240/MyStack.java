package mr.gonzalez.xc240;

public class MyStack<E>{
    MyLinkedList<E> store = new MyLinkedList<E>();

    public E pop() { return store.remove(); }

    public void append(E val) { store.append(val); }
}
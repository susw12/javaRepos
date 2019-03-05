package net.mr.gonzalez.exercise2;

public class MyHashSetTester {
    public static void main(String[] args) {
        MyHashSet<String> hashset = new MyHashSet<>(15);
        System.out.println(hashset.getCapacity());
        hashset.add("Hello");
        System.out.println(hashset.getSize());
        System.out.print("[");
        for (int x = 0; x < hashset.toArray().length; x++) {
            System.out.print((String) hashset.toArray()[x] + ", ");
        }
        System.out.print("\b\b]");

    }
}

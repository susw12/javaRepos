package net.mr.gonzalez.exercise2;

public class MyHashSetTester {
    public static void main(String[] args) {
        MyHashSet<String> hashset = new MyHashSet<>(4);
        hashset.add("Hello");
        hashset.add("What is going on?");
        hashset.add("2838838");
        hashset.add("a3948dj783ujdiuyhias8y98498y4398y");
        hashset.add("adhflkaiwjhisdjhfiuhwe");
        dataOutput(hashset);

    }

    private static void dataOutput(MyHashSet<String> hashset) {
        System.out.print("Array: [");
        for (int x = 0; x < hashset.toArray().length; x++) {
            System.out.print(hashset.toArray()[x] + ", ");
        }
        System.out.print("\b\b]\n");
        System.out.print("HashTable: [");
        for (int x = 0; x < hashset.getHashTable().length; x++) {
            System.out.print(hashset.getHashTable()[x] + ", ");
        }
        System.out.print("\b\b]\n");
    }

}

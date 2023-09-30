package org.example;

public class Main {
    public static void main(String[] args) {
        IntegerList integerList = new IntegerListImpl();
            long start = System.currentTimeMillis();
            integerList.sortBubble();
        System.out.println("Bubble");
            System.out.println(System.currentTimeMillis() - start);

        integerList.sortSelection();
        System.out.println("Selection");
        System.out.println(System.currentTimeMillis() - start);


        integerList.sortInsertion();
        System.out.println("Insertion");
        System.out.println(System.currentTimeMillis() - start);

    }
}
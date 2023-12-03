package ru.polytech.labs.j110.lab3.task2;

import ru.polytech.labs.j110.lab3.task2.model.DoublyLinkedList;

public class DoublyLinkedListMain {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.add(4);
        list.add(5);

        Integer[] array = {6, 7, 8};
        list.addAllFirst(array);

        System.out.println("Значения списка в прямом порядке: ");
        list.printAsc();

        System.out.println("Значения списка в обратном порядке: ");
        list.printDesc();
    }
}
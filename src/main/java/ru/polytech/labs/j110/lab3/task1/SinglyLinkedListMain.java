package ru.polytech.labs.j110.lab3.task1;

import ru.polytech.labs.j110.lab3.task1.model.CustomLinkedList;

public class SinglyLinkedListMain {
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();

        list.addFirst(1);
        list.addFirst(2);
        list.add(3);

        list.printList();

        System.out.println("Содержит 2: " + list.contains(2));
        System.out.println("Содержит 4: " + list.contains(4));

        list.remove(1);
        list.printList();

        list.forEach(System.out::print);
    }
}
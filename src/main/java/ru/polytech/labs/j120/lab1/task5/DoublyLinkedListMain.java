package ru.polytech.labs.j120.lab1.task5;

import ru.polytech.labs.j120.lab1.task5.model.DoublyLinkedList;

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

        System.out.println("Значения в списке (прямая итерация): ");
        for (Integer item : list) {
            System.out.print(item + " ");
        }
        System.out.println();

        System.out.println("Значения в списке (обратная итерация): ");
        for (Integer item : list.reverseIterable()) {
            System.out.print(item + " ");
        }
        System.out.println();

        int valueToFind = 3;

        System.out.println("Значения от начала до узла со значением " + valueToFind + ": ");
        for (Integer item : list.iterableFromHeadToValue(valueToFind)) {
            System.out.print(item + " ");
        }
        System.out.println();

        System.out.println("Значения от узла со значением " + valueToFind + " до конца: ");
        for (Integer item : list.iterableFromValueToTail(valueToFind)) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
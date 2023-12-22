package ru.polytech.labs.j120.lab1.task2;

import ru.polytech.labs.j120.lab1.task2.model.CustomLinkedList;

public class SinglyLinkedListMain {
    public static void main(String[] args) {
        CustomLinkedList<Integer> list = new CustomLinkedList<>();

        // Добавление элементов в список
        list.addFirst(1);
        list.addFirst(2);
        list.add(3);

        // Вывод всех значений в списке при помощи for-each
        System.out.println("Значения в списке: ");
        for (Integer item : list) {
            System.out.print(item + " ");
        }
        System.out.println();

        int valueToFind = 1;

        // Перебор значений от начала списка до узла со значением valueToFind
        System.out.println("Значения от начала до узла со значением " + valueToFind + ": ");
        for (Integer item : list.iterableFromHeadToValue(valueToFind)) {
            System.out.print(item + " ");
        }
        System.out.println();

        // Перебор значений от узла со значением valueToFind до конца списка
        System.out.println("Значения от узла со значением " + valueToFind + " до конца: ");
        for (Integer item : list.iterableFromValueToTail(valueToFind)) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
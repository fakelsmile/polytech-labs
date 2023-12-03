package ru.polytech.labs.j110.lab3.task3;

import ru.polytech.labs.j110.lab3.task3.model.ExpandedSinglyLinkedList;

public class ExpandedSinglyLinkedListMain {
    public static void main(String[] args) {
        ExpandedSinglyLinkedList<Integer> list = new ExpandedSinglyLinkedList<>();

        // Добавление элементов в список
        list.add(1);
        list.add(2);
        list.add(3);

        // Вывод элементов из списка
        System.out.println("Исходный список:");
        list.forEach(System.out::print);
        System.out.println();

        // Добавление массива значений в начало списка
        Integer[] valuesToAdd = {4, 5, 6};
        list.addAllAscFirst(valuesToAdd);
        System.out.println("Список после добавления значений в начало:");
        list.forEach(System.out::print);
        System.out.println();

        // Создание другого списка
        ExpandedSinglyLinkedList<Integer> otherList = new ExpandedSinglyLinkedList<>();
        otherList.add(7);
        otherList.add(8);
        otherList.add(9);

        // Поглощение другого списка и добавление в конец текущего списка
        list.consume(otherList);
        System.out.println("Список после поглощения другого списка и добавления его значений в конец:");
        list.forEach(System.out::print);
        System.out.println();
    }
}

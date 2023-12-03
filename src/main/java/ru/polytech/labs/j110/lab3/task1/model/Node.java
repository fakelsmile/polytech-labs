package ru.polytech.labs.j110.lab3.task1.model;

class Node {

    final int data;

    Node next;

    /**
     * Конструктор узла списка
     *
     * @param data значение узла
     */
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

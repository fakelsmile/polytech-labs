package ru.polytech.labs.lab3.singly.model;

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

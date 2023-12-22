package ru.polytech.labs.j120.lab1.task2.model;

class Node<T> {

    final T data;

    Node<T> next;

    /**
     * Конструктор узла списка
     *
     * @param data значение узла
     */
    Node(T data) {
        this.data = data;
        this.next = null;
    }
}
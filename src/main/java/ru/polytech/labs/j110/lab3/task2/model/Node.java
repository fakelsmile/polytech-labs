package ru.polytech.labs.j110.lab3.task2.model;

class Node<T> {

    T data;

    Node<T> prev;

    Node<T> next;

    /**
     * Создает новый узел с указанными данными
     *
     * @param data данные, которые будут храниться в узле
     */
    public Node(T data) {
        this.data = data;
    }
}

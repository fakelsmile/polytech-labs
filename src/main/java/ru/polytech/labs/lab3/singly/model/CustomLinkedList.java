package ru.polytech.labs.lab3.singly.model;

import java.util.function.Consumer;

public class CustomLinkedList {

    private Node head;

    private Node tail;

    /**
     * Добавление значения в начало списка
     *
     * @param value значение, которое нужно добавить в начало списка
     */
    public void addFirst(int value) {
        Node newNode = new Node(value);
        if (checkEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    /**
     * Извлечение значения из начала списка без его удаления
     *
     * @return значение из начала списка
     */
    public int getFirst() {
        if (checkEmpty()) {
            return -1; // или вернуть другое значение по умолчанию
        }
        return head.data;
    }

    /**
     * Извлечение значения из начала списка с удалением
     *
     * @return значение из начала списка
     */
    public int removeFirst() {
        if (checkEmpty()) {
            return -1; // или вернуть другое значение по умолчанию
        }
        int value = head.data;
        if (head.equals(tail)) {
            head = tail = null;
        } else {
            head = head.next;
        }
        return value;
    }

    /**
     * Добавление значения в конец списка
     *
     * @param value значение, которое нужно добавить в конец списка
     */
    public void add(int value) {
        Node newNode = new Node(value);
        if (checkEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    /**
     * Извлечение значения из конца списка без его удаления
     *
     * @return значение из конца списка
     */
    public int get() {
        if (checkEmpty()) {
            return -1; // или вернуть другое значение по умолчанию
        }
        return tail.data;
    }

    /**
     * Извлечение значения из конца списка с удалением
     *
     * @return значение из конца списка.
     */
    public int remove() {
        if (checkEmpty()) {
            return -1; // или вернуть другое значение по умолчанию
        }
        int value = tail.data;
        if (head.equals(tail)) {
            head = tail = null;
        } else {
            Node current = head;
            while (!current.next.equals(tail)) {
                current = current.next;
            }
            tail = current;
            tail.next = null;
        }
        return value;
    }

    /**
     * Проверка, содержит ли список заданное значение
     *
     * @param value значение, которое нужно проверить на наличие в списке
     * @return true, если значение содержится в списке, в противном случае - false
     */
    public boolean contains(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Печать всех значений списка
     */
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    /**
     * Удаление заданного значения из списка
     *
     * @param value значение, которое нужно удалить из списка (если оно существует)
     */
    public void remove(int value) {
        if (checkEmpty()) {
            return;
        }
        if (head.data == value) {
            removeFirst();
        } else {
            Node current = head;
            while (current.next != null && current.next.data != value) {
                current = current.next;
            }
            if (current.next != null) {
                current.next = current.next.next;
            }
        }
    }

    /**
     * Выполнение действия для каждого значения в списке
     *
     * @param action действие, которое нужно выполнить для каждого значения в списке
     */
    public void forEach(Consumer<Integer> action) {
        if (action == null) {
            throw new IllegalArgumentException("Действие не может быть null");
        }
        Node current = head;
        while (current != null) {
            action.accept(current.data);
            current = current.next;
        }
    }

    /**
     * Проверяет, является ли список пустым
     *
     * @return true, если список пуст, в противном случае - false
     */
    private boolean checkEmpty() {
        return head == null;
    }
}

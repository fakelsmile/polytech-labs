package ru.polytech.labs.lab3.doubly.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements Iterable<T> {

    private Node<T> head;

    private Node<T> tail;

    /**
     * Конструктор для создания пустого двусвязного списка
     */
    public DoublyLinkedList() {}

    /**
     * Добавляет элемент в начало списка
     *
     * @param data данные, которые нужно добавить в список
     */
    public void addFirst(T data) {
        checkEmpty(data);
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    /**
     * Добавляет массив элементов в начало списка
     *
     * @param values массив данных, которые нужно добавить в список
     */
    public void addAllFirst(T... values) {
        checkEmpty(values);
        for (int i = values.length - 1; i >= 0; i--) {
            addFirst(values[i]);
        }
    }

    /**
     * Добавляет элементы из коллекции в начало списка с сохранением порядка
     *
     * @param values коллекция, содержащая данные для добавления в список
     */
    public void addAllFirst(Collection<T> values) {
        checkEmpty(values);
        for (T value : values) {
            addFirst(value);
        }
    }

    /**
     * Добавляет элемент в конец списка
     *
     * @param data данные, которые нужно добавить в список
     */
    public void add(T data) {
        checkEmpty(data);
        Node<T> newNode = new Node<>(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    /**
     * Добавляет массив элементов в конец списка
     *
     * @param values массив данных, которые нужно добавить в список
     */
    public void addAll(T... values) {
        checkEmpty(values);
        for (T value : values) {
            add(value);
        }
    }

    /**
     * Добавляет элементы из коллекции в конец списка с сохранением порядка
     *
     * @param values коллекция, содержащая данные для добавления в список
     */
    public void addAll(Collection<T> values) {
        checkEmpty(values);
        for (T value : values) {
            add(value);
        }
    }

    /**
     * Поглощает другой список, добавляя его элементы в начало этого списка
     * После поглощения, второй список очищается
     *
     * @param list другой двусвязный список, который нужно поглотить
     */
    public void consumeListFirst(DoublyLinkedList<T> list) {
        checkEmpty(list);
        if (list.head != null) {
            if (head == null) {
                head = list.head;
                tail = list.tail;
            } else {
                list.tail.next = head;
                head.prev = list.tail;
                head = list.head;
            }
            list.clear();
        }
    }

    /**
     * Поглощает другой список, добавляя его элементы в конец этого списка
     * После поглощения, второй список очищается
     *
     * @param list другой двусвязный список, который нужно поглотить
     */
    public void consumeList(DoublyLinkedList<T> list) {
        checkEmpty(list);
        if (list.head != null) {
            if (tail == null) {
                head = list.head;
                tail = list.tail;
            } else {
                list.head.prev = tail;
                tail.next = list.head;
                tail = list.tail;
            }
            list.clear();
        }
    }

    /**
     * Печатает все значения списка в прямом порядке
     */
    public void printAsc() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    /**
     * Печатает все значения списка в обратном порядке
     */
    public void printDesc() {
        Node<T> current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    // Реализация Iterable для итерации по списку
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Объект не найден");
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    /**
     * Проверяет, что переданное значение не является null
     *
     * @param value Значение для проверки.
     */
    private void checkEmpty(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Значение не может быть null");
        }
    }

    /**
     * Проверяет, что переданный массив значений не является null
     *
     * @param values массив значений для проверки
     */
    private void checkEmpty(T... values) {
        if (values == null) {
            throw new IllegalArgumentException("Массив не может быть null");
        }
    }

    /**
     * Проверяет, что переданная коллекция значений не является null
     *
     * @param values коллекция значений для проверки
     */
    private void checkEmpty(Collection<T> values) {
        if (values == null) {
            throw new IllegalArgumentException("Коллекция не может быть null");
        }
    }

    /**
     * Проверяет, что переданный двусвязный список значений не является null
     *
     * @param list двусвязный список значений для проверки
     */
    private void checkEmpty(DoublyLinkedList<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("Двусвязный список не может быть null");
        }
    }

    /**
     * Очищает список, удаляя все элементы
     */
    private void clear() {
        head = tail = null;
    }
}
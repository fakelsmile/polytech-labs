package ru.polytech.labs.j110.lab3.task3.model;

import java.util.Collection;
import java.util.function.Consumer;

public class ExpandedSinglyLinkedList<T> {

    private static final int NODE_CAPACITY = 8;

    private Node<T> head;

    private Node<T> tail;

    private static class Node<T> {

        T[] data;

        int count;

        Node<T> next;

        Node() {
            data = (T[]) new Object[NODE_CAPACITY];
            count = 0;
            next = null;
        }
    }

    /**
     * Создает пустой развёрнутый односвязный список
     */
    public ExpandedSinglyLinkedList() {
        head = tail = new Node<>();
    }

    /**
     * Добавляет элемент в конец списка
     *
     * @param value добавляемый элемент
     */
    public void add(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Значение не может быть null");
        }
        if (tail.count == NODE_CAPACITY) {
            tail.next = new Node<>();
            tail = tail.next;
        }
        tail.data[tail.count++] = value;
    }

    /**
     * Добавляет массив значений в начало списка с сохранением порядка
     *
     * @param values массив значений, добавляемых в начало списка
     */
    public void addAllAscFirst(T... values) {
        if (values == null) {
            throw new IllegalArgumentException("Массив не может быть null");
        }
        for (int i = values.length - 1; i >= 0; i--) {
            if (head.count == NODE_CAPACITY) {
                Node<T> newHead = new Node<>();
                newHead.next = head;
                head = newHead;
            }
            for (int j = head.count; j > 0; j--) {
                head.data[j] = head.data[j - 1];
            }
            head.data[0] = values[i];
            head.count++;
        }
    }

    /**
     * Добавляет коллекцию значений в начало списка с сохранением порядка
     *
     * @param values коллекция значений, добавляемых в начало списка
     */
    public void addAllAscFirst(Collection<T> values) {
        if (values == null) {
            throw new IllegalArgumentException("Коллекция не может быть null");
        }
        for (T value : values) {
            if (head.count == NODE_CAPACITY) {
                Node<T> newHead = new Node<>();
                newHead.next = head;
                head = newHead;
            }
            for (int i = head.count; i > 0; i--) {
                head.data[i] = head.data[i - 1];
            }
            head.data[0] = value;
            head.count++;
        }
    }

    /**
     * Добавляет массив значений в конец списка с сохранением порядка
     *
     * @param values массив значений, добавляемых в конец списка
     */
    public void addAllAsc(T... values) {
        checkEmpty(values);
        for (T value : values) {
            add(value);
        }
    }

    /**
     * Добавляет коллекцию значений в конец списка с сохранением порядка
     *
     * @param values коллекция значений, добавляемых в конец списка
     */
    public void addAllAsc(Collection<T> values) {
        checkEmpty(values);
        for (T value : values) {
            add(value);
        }
    }

    /**
     * Поглощает другой развёрнутый односвязный список, добавляя его значения в начало текущего списка
     * После поглощения, второй список будет очищен
     *
     * @param list другой развёрнутый односвязный список, который будет поглощен
     */
    public void consumeFirst(ExpandedSinglyLinkedList<T> list) {
        checkEmpty(list);
        Node<T> otherTail = list.tail;
        list.clear();
        otherTail.next = head;
        head = list.head;
    }

    /**
     * Поглощает другой развёрнутый односвязный список, добавляя его значения в конец текущего списка
     * После поглощения, второй список будет очищен
     *
     * @param list другой развёрнутый односвязный список, который будет поглощен
     */
    public void consume(ExpandedSinglyLinkedList<T> list) {
        checkEmpty(list);
        tail.next = list.head;
        tail = list.tail;
        list.clear();
    }

    /**
     * Выполняет указанное действие для каждого элемента списка
     *
     * @param action действие, выполняемое для каждого элемента
     */
    public void forEach(Consumer<T> action) {
        if (action == null) {
            throw new IllegalArgumentException("Действие не может быть null");
        }
        Node<T> current = head;
        while (current != null) {
            for (int i = 0; i < NODE_CAPACITY && i < current.count; i++) {
                action.accept(current.data[i]);
            }
            current = current.next;
        }
    }

    /**
     * Проверяет, что переданное значение не является null
     *
     * @param value значение для проверки.
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
     * Проверяет, что переданный односвязный список значений не является null
     *
     * @param list односвязный список значений для проверки
     */
    private void checkEmpty(ExpandedSinglyLinkedList<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("Односвязный список не может быть null");
        }
    }

    /**
     * Очищает список, удаляя все элементы
     */
    private void clear() {
        head = tail = new Node<>();
    }
}

package ru.polytech.labs.j120.lab1.task2.model;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CustomLinkedList<T> implements Iterable<T> {

    private Node<T> head;

    private Node<T> tail;

    /**
     * Добавляет значение в начало списка
     *
     * @param value значение, которое нужно добавить в начало списка
     */
    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        if (checkEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    /**
     * Извлекает значение из начала списка без его удаления
     *
     * @return значение из начала списка
     */
    public T getFirst() {
        if (checkEmpty()) {
            return null;
        }
        return head.data;
    }

    /**
     * Извлекает значение из начала списка с удалением
     *
     * @return значение из начала списка
     */
    public T removeFirst() {
        if (checkEmpty()) {
            return null;
        }
        T value = head.data;
        if (head.equals(tail)) {
            head = tail = null;
        } else {
            head = head.next;
        }
        return value;
    }

    /**
     * Добавляет значение в конец списка
     *
     * @param value значение, которое нужно добавить в конец списка
     */
    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (checkEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    /**
     * Извлекает значение из конца списка без его удаления
     *
     * @return значение из конца списка
     */
    public T get() {
        if (checkEmpty()) {
            return null;
        }
        return tail.data;
    }

    /**
     * Извлекает значение из конца списка с удалением
     *
     * @return значение из конца списка.
     */
    public T remove() {
        if (checkEmpty()) {
            return null;
        }
        T value = tail.data;
        if (head.equals(tail)) {
            head = tail = null;
        } else {
            Node<T> current = head;
            while (!current.next.equals(tail)) {
                current = current.next;
            }
            tail = current;
            tail.next = null;
        }
        return value;
    }

    /**
     * Проверяет, содержит ли список заданное значение
     *
     * @param value значение, которое нужно проверить на наличие в списке
     * @return true, если значение содержится в списке, в противном случае - false
     */
    public boolean contains(T value) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Печатает все значения списка
     */
    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    /**
     * Удаляет заданное значение из списка (если оно существует)
     *
     * @param value значение, которое нужно удалить из списка (если оно существует)
     */
    public void remove(T value) {
        if (checkEmpty()) {
            return;
        }
        if (head.data.equals(value)) {
            removeFirst();
        } else {
            Node<T> current = head;
            while (current.next != null && !current.next.data.equals(value)) {
                current = current.next;
            }
            if (current.next != null) {
                current.next = current.next.next;
            }
        }
    }

    /**
     * Выполняет действие для каждого значения в списке
     *
     * @param action действие, которое нужно выполнить для каждого значения в списке
     */
    public void forEach(Consumer<? super T> action) {
        if (action == null) {
            throw new IllegalArgumentException("Action cannot be null");
        }
        Node<T> current = head;
        while (current != null) {
            action.accept(current.data);
            current = current.next;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator(head);
    }

    public void forEachNode() {
        for (T data : this) {
            System.out.print(data + " -> ");
        }
        System.out.println("null");
    }

    /**
     * Получает итератор для перебора списка от начала до узла с заданным значением
     *
     * @param value значение, с которого начинается перебор
     * @return итератор, который перебирает список от начала до узла с заданным значением
     */
    public Iterable<T> iterableFromHeadToValue(T value) {
        return () -> new Iterator<T>() {
            private Node<T> current = head;
            private boolean found = false;

            @Override
            public boolean hasNext() {
                return !found && current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Элемент не найден");
                }
                T data = current.data;
                if (current.data.equals(value)) {
                    found = true;
                }
                current = current.next;
                return data;
            }
        };
    }

    /**
     * Получает итератор для перебора списка от узла с заданным значением до конца
     *
     * @param value значение, с которого начинается перебор
     * @return итератор, который перебирает список от узла с заданным значением до конца
     */
    public Iterable<T> iterableFromValueToTail(T value) {
        return () -> new Iterator<T>() {
            private Node<T> current = head;
            private boolean found = false;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Элемент не найден");
                }
                while (current != null) {
                    if (found || current.data.equals(value)) {
                        found = true;
                        T data = current.data;
                        current = current.next;
                        return data;
                    }
                    current = current.next;
                }
                throw new NoSuchElementException("Элемент не найден");
            }
        };
    }

    /**
     * Проверяет, является ли список пустым
     *
     * @return true, если список пуст, в противном случае - false
     */
    private boolean checkEmpty() {
        return head == null;
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node<T> current;

        LinkedListIterator(Node<T> start) {
            this.current = start;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = current.data;
            current = current.next;
            return data;
        }
    }
}

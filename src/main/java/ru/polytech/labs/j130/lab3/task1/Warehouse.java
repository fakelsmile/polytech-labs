package ru.polytech.labs.j130.lab3.task1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Warehouse {

    private int totalProducts = 0;

    private Queue<Integer> products = new LinkedList<>();

    private final int capacity;

    private final Lock lock = new ReentrantLock();

    private final Condition notEmpty = lock.newCondition();

    private final Condition notFull = lock.newCondition();

    /**
     * Конструктор класса Warehouse
     *
     * @param capacity ёмкость склада
     */
    public Warehouse(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Метод для поставки товара на склад
     *
     * @param product количество товара, которое необходимо поставить на склад
     */
    public void produce(int product) throws InterruptedException {
        lock.lock();
        try {
            while (totalProducts + product > capacity) {
                System.out.println("Склад полон, поставщик ожидает...");
                notFull.await();
            }

            products.offer(product);
            totalProducts += product;
            System.out.println("Поставщик поставил " + product + ", остаток на складе: " + totalProducts);
            notEmpty.signalAll();

        } finally {
            lock.unlock();
        }
    }

    /**
     * Метод для поставки товара со склада
     *
     * @param requiredQuantity требуемое количество товара для отгрузки
     */
    public void consume(int requiredQuantity) throws InterruptedException {
        lock.lock();
        try {
            while (totalProducts < requiredQuantity) {
                System.out.println("Склад пуст или товара недостаточно, потребитель ожидает...");
                notEmpty.await();
            }

            int remainingQuantity = requiredQuantity;
            while (!products.isEmpty() && remainingQuantity > 0) {
                int product = products.poll();
                totalProducts -= product;
                remainingQuantity -= product;
            }

            System.out.println("Потребитель забрал "
                    + (requiredQuantity - remainingQuantity)
                    + ", остаток на складе: "
                    + totalProducts
            );
            notFull.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

package ru.polytech.labs.j130.lab3.task2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Database {

    private int readersCount;

    private int writersCount;

    private boolean writerPresent = false;

    private Lock lock = new ReentrantLock();

    private Condition noReaders = lock.newCondition();

    private Condition noWriters = lock.newCondition();

    /**
     * Метод, вызываемый читателем для начала чтения
     *
     * @param readerId идентификатор читателя
     */
    public void startReading(int readerId) throws InterruptedException {
        lock.lock();
        try {
            while (writerPresent || writersCount > 0) {
                noReaders.await();
            }
            readersCount++;
            System.out.println("Читатель " + readerId + " начал читать. Количество читателей: " + readersCount);
        } finally {
            lock.unlock();
        }
    }

    /**
     * Метод, вызываемый читателем для завершения чтения
     *
     * @param readerId идентификатор читателя
     */
    public void endReading(int readerId) {
        lock.lock();
        try {
            readersCount--;
            System.out.println("Читатель " + readerId + " закончил читать. Количество читателей: " + readersCount);
            if (readersCount == 0) {
                noWriters.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * Метод, вызываемый писателем для начала записи
     *
     * @param writerId идентификатор писателя
     */
    public void startWriting(int writerId) throws InterruptedException {
        lock.lock();
        try {
            while (writerPresent || readersCount > 0) {
                noWriters.await();
            }
            writersCount++;
            writerPresent = true;
            System.out.println("Писатель " + writerId + " начал писать. Количество писателей: " + writersCount);
        } finally {
            lock.unlock();
        }
    }

    /**
     * Метод, вызываемый писателем для завершения записи
     *
     * @param writerId идентификатор писателя
     */
    public void endWriting(int writerId) {
        lock.lock();
        try {
            writersCount--;
            System.out.println("Писатель " + writerId + " закончил писать. Количество писателей: " + writersCount);
            writerPresent = false;
            noReaders.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
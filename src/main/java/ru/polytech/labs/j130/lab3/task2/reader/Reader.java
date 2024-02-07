package ru.polytech.labs.j130.lab3.task2.reader;

import ru.polytech.labs.j130.lab3.task2.Database;

import java.util.Random;

public class Reader implements Runnable {

    private final Database database;

    private final int id;

    private final Random random = new Random();

    /**
     * Конструктор класса Reader
     *
     * @param database база данных, с которой работает читатель
     * @param id       идентификатор читателя
     */
    public Reader(Database database, int id) {
        this.database = database;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while (true) {
                database.startReading(id);
                Thread.sleep(random.nextInt(1000));
                database.endReading(id);
                Thread.sleep(random.nextInt(2000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
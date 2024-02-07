package ru.polytech.labs.j130.lab3.task2.writer;

import ru.polytech.labs.j130.lab3.task2.Database;

import java.util.Random;

public class Writer implements Runnable {

    private final Database database;

    private final int id;

    private final Random random = new Random();

    /**
     * Конструктор класса Writer
     *
     * @param database база данных, с которой работает писатель
     * @param id       идентификатор писателя
     */
    public Writer(Database database, int id) {
        this.database = database;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while (true) {
                database.startWriting(id);
                Thread.sleep(random.nextInt(1000));
                database.endWriting(id);
                Thread.sleep(random.nextInt(2000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
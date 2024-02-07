package ru.polytech.labs.j130.lab3.task1.consumer;

import ru.polytech.labs.j130.lab3.task1.Warehouse;

import java.util.Random;

public class Consumer implements Runnable {

    private final Warehouse warehouse;

    private final Random random = new Random();

    /**
     * Конструктор класса Consumer
     *
     * @param warehouse склад, на котором работает потребитель
     */
    public Consumer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int requiredQuantity = random.nextInt(10) + 1;
                warehouse.consume(requiredQuantity);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package ru.polytech.labs.j130.lab3.task1.producer;

import ru.polytech.labs.j130.lab3.task1.Warehouse;

import java.util.Random;

public class Producer implements Runnable {

    private final Warehouse warehouse;

    private final Random random = new Random();

    /**
     * Конструктор класса Producer
     *
     * @param warehouse склад, на котором работает поставщик
     */
    public Producer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int product = random.nextInt(10) + 1;
                warehouse.produce(product);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

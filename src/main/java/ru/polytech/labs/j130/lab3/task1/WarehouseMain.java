package ru.polytech.labs.j130.lab3.task1;

import ru.polytech.labs.j130.lab3.task1.consumer.Consumer;
import ru.polytech.labs.j130.lab3.task1.producer.Producer;

public class WarehouseMain {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse(20);

        Thread producer1 = new Thread(new Producer(warehouse));
        Thread producer2 = new Thread(new Producer(warehouse));
        Thread consumer1 = new Thread(new Consumer(warehouse));
        Thread consumer2 = new Thread(new Consumer(warehouse));

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }
}
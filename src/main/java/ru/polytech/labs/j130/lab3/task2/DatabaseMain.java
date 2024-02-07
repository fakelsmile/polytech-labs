package ru.polytech.labs.j130.lab3.task2;

import ru.polytech.labs.j130.lab3.task2.reader.Reader;
import ru.polytech.labs.j130.lab3.task2.writer.Writer;

public class DatabaseMain {
    public static void main(String[] args) {
        Database database = new Database();
        int numReaders = 3;
        int numWriters = 3;

        for (int i = 1; i <= numReaders; i++) {
            new Thread(new Reader(database, i)).start();
        }

        for (int i = 1; i <= numWriters; i++) {
            new Thread(new Writer(database, i)).start();
        }
    }
}

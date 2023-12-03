package ru.polytech.labs.j110.lab2.task1;

import ru.polytech.labs.j110.lab2.task1.model.Person;

public class University {

    /**
     * Выводит информацию о всех персонах в университете
     *
     * @param people Массив персон, представленных в университете
     */
    public static void printAll(Person[] people) {
        for (Person person : people) {
            person.print();
            System.out.println();
        }
    }
}

package ru.polytech.labs.lab2.university;

import ru.polytech.labs.lab2.university.model.Person;

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

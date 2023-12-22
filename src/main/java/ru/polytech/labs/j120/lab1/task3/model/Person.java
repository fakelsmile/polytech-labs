package ru.polytech.labs.j120.lab1.task3.model;

import java.util.Collection;

public abstract class Person {

    private final String name;

    public final Gender gender;

    private String department;

    protected Person(String name, Gender gender, String department) {
        this.name = name;
        this.gender = gender;
        this.department = department;
    }

    public void print() {
        String pronoun = gender.getPronoun();
        String verb = "studies";
        System.out.println("This is " + name + ". " + pronoun + " " + verb + " at " + department + ".");
    }

    /**
     * Выводит информацию о каждом человеке в коллекции
     *
     * @param people коллекция объектов типа Person или его потомков
     */
    public static void printPeople(Collection<? extends Person> people) {
        for (Person person : people) {
            person.print();
        }
    }
}


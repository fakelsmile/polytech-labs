package ru.polytech.labs.j120.lab1.task4.model;

public abstract class Person {

    private final String name;

    public final Gender gender;

    private String department;

    /**
     * Конструктор для создания объекта Person
     *
     * @param name       имя
     * @param gender     пол
     * @param department отделение
     */
    protected Person(String name, Gender gender, String department) {
        this.name = name;
        this.gender = gender;
        this.department = department;
    }

    /**
     * Выводит информацию о человеке
     */
    public void print() {
        String pronoun = gender.getPronoun();
        String verb = "studies";
        System.out.println("This is " + name + ". " + pronoun + " " + verb + " at " + department + ".");
    }
}
package ru.polytech.labs.lab2.university.model;

public class Aspirant extends Person {

    private String thesisTitle;

    /**
     * Конструктор для создания объекта Aspirant
     *
     * @param name        имя
     * @param gender      пол
     * @param department  отделение
     * @param thesisTitle название диссертации
     */
    public Aspirant(String name, Gender gender, String department, String thesisTitle) {
        super(name, gender, department);
        this.thesisTitle = thesisTitle;
    }

    @Override
    public void print() {
        super.print();
        String pronoun = gender.getPronoun(true);
        System.out.println(pronoun + " thesis title is " + thesisTitle);
    }
}
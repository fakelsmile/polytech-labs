package ru.polytech.labs.j110.lab2.task1.model;

public class Teacher extends Person {

    private Degree degree;

    private final String specialty;

    /**
     * Конструктор для создания объекта Teacher
     *
     * @param name       имя
     * @param gender     пол
     * @param department отделение
     * @param degree     ученая степень
     * @param specialty  специальность
     */
    public Teacher(String name, Gender gender, String department, Degree degree, String specialty) {
        super(name, gender, department);
        this.degree = degree;
        this.specialty = specialty;
    }

    @Override
    public void print() {
        super.print();
        String pronoun = gender.getPronoun();
        System.out.println(pronoun + " has " + degree + " degree in " + specialty + ".");
    }
}

package ru.polytech.labs.j120.lab1.task3.model;

public enum Course {

    FIRST("I"),

    SECOND("II"),

    THIRD("III");

    private final String romanNumeral;

    Course(String romanNumeral) {
        this.romanNumeral = romanNumeral;
    }

    public String getRomanNumeral() {
        return romanNumeral;
    }
}

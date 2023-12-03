package ru.polytech.labs.j110.lab2.task1.model;

public enum Course {

    FIRST("I"),

    SECOND("II"),

    THIRD("III");

    private String romanNumeral;

    Course(String romanNumeral) {
        this.romanNumeral = romanNumeral;
    }

    public String getRomanNumeral() {
        return romanNumeral;
    }
}

package ru.polytech.labs.lab2.university.model;

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

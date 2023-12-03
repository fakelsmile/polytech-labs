package ru.polytech.labs.j110.lab2.task1.model;

public enum Degree {

    CANDIDATE("Candidate"),

    DOCTOR("Doctor"),

    PHD("PhD"),

    MSC("MSC");

    private String label;

    Degree(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

package ru.polytech.labs.j120.lab1.task4.model;

public enum EducationGrade {

    BACHELOR("Bachelor"),

    MASTER("Master"),

    ASPIRANT("Aspirant");

    private final String label;

    EducationGrade(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

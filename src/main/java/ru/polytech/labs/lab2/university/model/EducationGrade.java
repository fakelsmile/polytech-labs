package ru.polytech.labs.lab2.university.model;

public enum EducationGrade {

    BACHELOR("Bachelor"),

    MASTER("Master"),

    ASPIRANT("Aspirant");

    private String label;

    EducationGrade(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

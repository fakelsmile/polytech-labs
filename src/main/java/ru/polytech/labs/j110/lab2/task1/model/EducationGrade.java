package ru.polytech.labs.j110.lab2.task1.model;

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

package ru.polytech.labs.j110.lab2.task1.model;

public enum Gender {

    MALE("He", "His"),

    FEMALE("She", "Her");

    private String pronoun;

    private String pronounPrint;

    Gender(String pronoun, String pronounPrint) {
        this.pronoun = pronoun;
        this.pronounPrint = pronounPrint;
    }

    public String getPronoun() {
        return pronoun;
    }

    public String getPronoun(boolean possessive) {
        return possessive ? pronounPrint : pronoun;
    }
}

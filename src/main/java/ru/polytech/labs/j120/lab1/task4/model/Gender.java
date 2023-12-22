package ru.polytech.labs.j120.lab1.task4.model;

public enum Gender {

    MALE("He", "His"),

    FEMALE("She", "Her");

    private final String pronoun;

    private final String pronounPrint;

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

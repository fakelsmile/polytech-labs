package ru.polytech.labs.j110.lab2.task2.model;

public enum FileFormat {

    DOCX("docx"),

    PNG("png"),

    MP3("mp3"),

    AVI("avi");

    private String value;

    FileFormat(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static FileFormat getByValue(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Формат не найден!");
        }

        for (FileFormat format : values()) {
            if (format.value.equalsIgnoreCase(value)) {
                return format;
            }
        }

        throw new IllegalArgumentException("Формат не найден!");
    }
}

package ru.polytech.labs.j110.lab1.task2.model;

public class Publisher {

    private String name;

    private String city;

    /**
     * Конструктор для создания издателя с указанием имени и города
     *
     * @param name имя издателя
     * @param city город издателя
     */
    public Publisher(String name, String city) {
        setName(name);
        setCity(city);
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public void setName(String name) {
        if (name == null || name.trim().isBlank()) {
            throw new IllegalArgumentException("Имя издателя не должно быть пустым!");
        }
        this.name = name;
    }

    public void setCity(String city) {
        if (city == null || city.trim().isBlank()) {
            throw new IllegalArgumentException("Город не должен быть пустым!");
        }
        this.city = city;
    }
}
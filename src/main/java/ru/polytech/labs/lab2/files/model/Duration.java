package ru.polytech.labs.lab2.files.model;

public class Duration {

    private int hours;

    private int minutes;

    private int seconds;

    /**
     * Конструктор для создания объекта продолжительности времени
     *
     * @param hours   часы
     * @param minutes минуты
     * @param seconds секунды
     */
    public Duration(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}

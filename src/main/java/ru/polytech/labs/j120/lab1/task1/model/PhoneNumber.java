package ru.polytech.labs.j120.lab1.task1.model;

import java.util.Objects;

public class PhoneNumber {

    private final int regionCode;

    private final int localNumber;

    /**
     * Конструктор класса PhoneNumber для создания объекта номера телефона
     *
     * @param regionCode  код региона
     * @param localNumber местный номер
     */
    public PhoneNumber(int regionCode, int localNumber) {
        if (isValidRegionCode(regionCode) && isValidLocalNumber(localNumber)) {
            this.regionCode = regionCode;
            this.localNumber = localNumber;
        } else {
            throw new IllegalArgumentException("Неверный формат номера");
        }
    }

    /**
     * Переопределение метода equals для сравнения объектов PhoneNumber
     *
     * @param o объект для сравнения
     * @return true, если объекты равны, иначе false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneNumber that)) return false;
        return regionCode == that.regionCode && localNumber == that.localNumber;
    }

    /**
     * Переопределение метода hashCode для генерации хэш-кода объекта PhoneNumber
     *
     * @return хэш-код объекта PhoneNumber
     */
    @Override
    public int hashCode() {
        return Objects.hash(regionCode, localNumber);
    }

    /**
     * Переопределение метода toString для форматирования номера телефона
     *
     * @return строковое представление номера телефона
     */
    @Override
    public String toString() {
        StringBuilder formattedNumber = new StringBuilder("(");
        formattedNumber.append(String.format("%03d", regionCode)).append(")");

        String localStr = String.format("%07d", localNumber);
        formattedNumber.append(localStr, 0, 3).append("-").append(localStr, 3, 5).append("-").append(localStr, 5, 7);

        return formattedNumber.toString();
    }

    /**
     * Проверяет соответствие кода региона формату
     *
     * @param regionCode код региона
     * @return true, если код региона соответствует формату, иначе false
     */
    private boolean isValidRegionCode(int regionCode) {
        // Предположим, что код региона может быть от 3 до 4 цифр
        return String.valueOf(regionCode).matches("\\d{3,4}");
    }

    /**
     * Проверяет соответствие местного номера формату
     *
     * @param localNumber местный номер
     * @return true, если местный номер соответствует формату, иначе false
     */
    private boolean isValidLocalNumber(int localNumber) {
        // Предположим, что местный номер может быть от 6 до 7 цифр
        return String.valueOf(localNumber).matches("\\d{6,7}");
    }
}

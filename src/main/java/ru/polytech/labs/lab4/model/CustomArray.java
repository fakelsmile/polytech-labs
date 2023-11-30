package ru.polytech.labs.lab4.model;

public interface CustomArray {

    /**
     * Получает значение по указанному индексу
     *
     * @param index индекс значения
     * @return значение по указанному индексу
     */
    boolean getByIndex(int index);

    /**
     * Устанавливает значение по указанному индексу в true
     *
     * @param index индекс, для которого нужно установить значение true
     */
    void setTrue(int index);

    /**
     * Устанавливает значение по указанному индексу в заданное булево значение
     *
     * @param index индекс, для которого нужно установить значение
     * @param value значение для установки
     */
    void set(int index, boolean value);

    /**
     * Сбрасывает значение по указанному индексу в false
     *
     * @param index индекс, для которого нужно сбросить значение в false
     */
    void reset(int index);

    /**
     * Инвертирует значение по указанному индексу
     *
     * @param index индекс, для которого нужно инвертировать значение
     */
    void revers(int index);

    /**
     * Возвращает количество значений true в массиве
     *
     * @return количество значений true в массиве
     */
    int countTrue();

    /**
     * Возвращает строковое представление массива
     *
     * @return строковое представление массива
     */
    String toString();
}

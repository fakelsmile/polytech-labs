package ru.polytech.labs.j110.lab4.model;

public class BooleanArray implements CustomArray {

    private final boolean[] array = new boolean[1024];

    @Override
    public boolean getByIndex(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public void setTrue(int index) {
        set(index, true);
    }

    @Override
    public void set(int index, boolean value) {
        checkIndex(index);
        array[index] = value;
    }

    @Override
    public void reset(int index) {
        set(index, false);
    }

    @Override
    public void revers(int index) {
        checkIndex(index);
        array[index] = !array[index];
    }

    @Override
    public int countTrue() {
        int count = 0;
        for (boolean value : array) {
            if (value) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (boolean value : array) {
            result.append(value ? '1' : '0');
        }
        return result.toString();
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Индекс вне допустимых границ: " + index);
        }
    }
}

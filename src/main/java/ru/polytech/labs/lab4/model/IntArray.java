package ru.polytech.labs.lab4.model;

public class IntArray implements CustomArray {

    private final int[] array = new int[32]; // каждый int хранит 32 бита

    @Override
    public boolean getByIndex(int index) {
        int intIndex = getIntIndex(index);
        int bitIndex = getBitIndex(index);
        return ((array[intIndex] >> bitIndex) & 1) == 1;
    }

    @Override
    public void setTrue(int index) {
        set(index, true);
    }

    @Override
    public void set(int index, boolean value) {
        int intIndex = getIntIndex(index);
        int bitIndex = getBitIndex(index);
        if (value) {
            array[intIndex] |= (1 << bitIndex);
        } else {
            array[intIndex] &= ~(1 << bitIndex);
        }
    }

    @Override
    public void reset(int index) {
        set(index, false);
    }

    @Override
    public void revers(int index) {
        int intIndex = getIntIndex(index);
        int bitIndex = getBitIndex(index);
        array[intIndex] ^= (1 << bitIndex);
    }

    @Override
    public int countTrue() {
        int count = 0;
        for (int value : array) {
            count += Integer.bitCount(value);
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length * 32; i++) {
            result.append(getByIndex(i) ? '1' : '0');
        }
        return result.toString();
    }

    private int getIntIndex(int index) {
        checkIndex(index);
        return index / 32;
    }

    private int getBitIndex(int index) {
        checkIndex(index);
        return index % 32;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= array.length * 32) {
            throw new IndexOutOfBoundsException("Индекс вне допустимых границ: " + index);
        }
    }
}

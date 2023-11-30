package ru.polytech.labs.lab4;

import ru.polytech.labs.lab4.model.BooleanArray;
import ru.polytech.labs.lab4.model.CustomArray;
import ru.polytech.labs.lab4.model.IntArray;

public class CustomArrayMain {
    public static void main(String[] args) {
        // Пример использования BooleanArray
        CustomArray boolArray = new BooleanArray();

        System.out.println("Начальный массив: " + boolArray);

        System.out.println("Начальное значение по индексу 0: " + boolArray.getByIndex(0));
        System.out.println("Начальное значение по индексу 3: " + boolArray.getByIndex(3));
        boolArray.setTrue(0);
        boolArray.setTrue(3);
        System.out.println("Измененное значение по индексу 0: " + boolArray.getByIndex(0));
        System.out.println("Измененное значение по индексу 3: " + boolArray.getByIndex(3));


        System.out.println("Начальное значение по индексу 5: " + boolArray.getByIndex(5));
        boolArray.set(5, true);
        System.out.println("Измененное значение по индексу 5: " + boolArray.getByIndex(5));

        boolArray.reset(3);

        System.out.println("Изменённый массив: " + boolArray);
        System.out.println("Количество значений true: " + boolArray.countTrue());

        System.out.println();

        // Пример использования IntArray
        CustomArray intArray = new IntArray();

        System.out.println("Начальный массив: " + intArray);

        System.out.println("Начальное значение по индексу 0: " + intArray.getByIndex(0));
        System.out.println("Начальное значение по индексу 3: " + intArray.getByIndex(3));
        intArray.setTrue(0);
        intArray.setTrue(3);
        System.out.println("Измененное значение по индексу 0: " + intArray.getByIndex(0));
        System.out.println("Измененное значение по индексу 3: " + intArray.getByIndex(3));

        System.out.println("Начальное значение по индексу 5: " + intArray.getByIndex(5));
        intArray.set(5, true);
        System.out.println("Измененное значение по индексу 5: " + intArray.getByIndex(5));

        intArray.reset(3);

        System.out.println("Изменённый массив: " + intArray);
        System.out.println("Количество значений true: " + intArray.countTrue());
    }
}

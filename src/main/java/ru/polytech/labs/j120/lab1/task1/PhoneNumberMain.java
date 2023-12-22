package ru.polytech.labs.j120.lab1.task1;

import ru.polytech.labs.j120.lab1.task1.model.PhoneNumber;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneNumberMain {
    public static void main(String[] args) {
        PhoneNumber number1 = new PhoneNumber(981, 1234567);
        PhoneNumber number2 = new PhoneNumber(4567, 1234567);
        PhoneNumber number3 = new PhoneNumber(4567, 123456);
        PhoneNumber number4 = new PhoneNumber(123, 4567890);
        PhoneNumber number5 = new PhoneNumber(123, 4567890);

        Set<PhoneNumber> phoneSet = new HashSet<>();
        phoneSet.add(number1);
        phoneSet.add(number2);
        phoneSet.add(number3);
        phoneSet.add(number4);

        Map<PhoneNumber, String> phoneInfoMap = new HashMap<>();
        phoneInfoMap.put(number1, "Иван");
        phoneInfoMap.put(number2, "Петр");
        phoneInfoMap.put(number3, "Василий");
        phoneInfoMap.put(number4, "Елена");
        phoneInfoMap.put(number5, "Анна");

        for (Map.Entry<PhoneNumber, String> entry : phoneInfoMap.entrySet()) {
            System.out.println("Номер: " + entry.getKey() + ", Владелец: " + entry.getValue());
        }
    }
}

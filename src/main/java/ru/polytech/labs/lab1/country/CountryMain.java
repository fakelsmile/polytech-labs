package ru.polytech.labs.lab1.country;

import ru.polytech.labs.lab1.country.model.Country;

public class CountryMain {
    public static void main(String[] args) {
        // Для удобства записи больших чисел используется формат 17.1e6,
        // "6" означает, что нужно умножить мантиссу (17.1) на 10^6, что равно 1 000 000
        Country[] countries = new Country[]{
                new Country("Russia", 17.1e6, 146.7e6, "Moscow", 12.6e6),
                new Country("Finland", 338e3, 5.5e6, "Helsinki", 655e3),
                new Country("France", 643.8e3, 67.8e6, "Paris", 2.1e6),
                new Country("Andorra", 467e3, 85.4e3, "Andorra la Vella", 22.6e3),
                new Country("Singapore", 725e3, 5.7e6)
        };

        Country.printAll(countries);
    }
}
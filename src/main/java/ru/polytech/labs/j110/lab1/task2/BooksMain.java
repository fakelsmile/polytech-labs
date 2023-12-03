package ru.polytech.labs.j110.lab1.task2;

import ru.polytech.labs.j110.lab1.task2.model.Book;
import ru.polytech.labs.j110.lab1.task2.model.Publisher;

public class BooksMain {
    public static void main(String[] args) {
        Publisher[] publishers = new Publisher[]{
                new Publisher("Проспект", "Москва"),
                new Publisher("Питер", "Санкт-Петербург"),
                new Publisher("БХВ", "Санкт-Петебург"), // Ошибка сделана намеренно
                new Publisher("Диалектика", "Киев")
        };

        Book[] books = new Book[]{
                new Book(
                        "Computer Science: основы программирования на Java, ООП, алгоритмы и структуры данных",
                        new String[]{"Седжвик Роберт", "Уэйн Кевин"},
                        2018,
                        publishers[1]
                ),
                new Book(
                        "Разработка требований к программному обеспечению. 3-е издание, дополненное",
                        new String[]{"Вигерс Карл"},
                        2019,
                        publishers[2]
                ),
                new Book(
                        "Java. Полное руководство, 10-е издание",
                        new String[]{"Шилдт Герберт"},
                        2018,
                        publishers[3]
                ),
                new Book(
                        "C/C++. Процедурное программирование",
                        new String[]{"Полубенцева М.И."},
                        2017,
                        publishers[2]
                ),
                new Book("Конституция РФ", 2020, publishers[0])
        };

        System.out.println("Исходный массив:");
        Book.printAll(books);

        // Исправляем ошибку в названии города издательства "БХВ"
        publishers[2].setCity("Санкт-Петербург");

        System.out.println("Массив после исправления названия города:");
        Book.printAll(books);

        // После исправления в название города издательства "БХВ" и повторной печати, вывод изменится для всех книг,
        // этого издательства, так как замена значения города была произведена у ссылки
    }
}
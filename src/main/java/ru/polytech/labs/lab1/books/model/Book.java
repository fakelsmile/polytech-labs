package ru.polytech.labs.lab1.books.model;

public class Book {

    private String title;

    private Publisher publisher;

    private int publicationYear;

    private String[] authors;

    /**
     * Конструктор для создания книги без указания авторов
     *
     * @param title           название книги
     * @param publicationYear год публикации книги
     * @param publisher       издатель книги
     */
    public Book(String title, int publicationYear, Publisher publisher) {
        this(title, publicationYear, publisher, (String[]) null);
    }

    /**
     * Конструктор для создания книги с одним автором
     *
     * @param title           название книги
     * @param author          имя автора книги
     * @param publicationYear год публикации книги
     * @param publisher       издатель книги
     */
    public Book(String title, String author, int publicationYear, Publisher publisher) {
        this(title, publicationYear, publisher, author);
    }

    /**
     * Конструктор для создания книги с несколькими авторами
     *
     * @param title           название книги
     * @param authors         массив имен авторов книги
     * @param publicationYear год публикации книги
     * @param publisher       издатель книги
     */
    public Book(String title, String[] authors, int publicationYear, Publisher publisher) {
        this(title, publicationYear, publisher, authors);
    }

    private Book(String title, int publicationYear, Publisher publisher, String... authors) {
        setTitle(title);
        setPublicationYear(publicationYear);
        setPublisher(publisher);
        setAuthors(authors);
    }

    public String getTitle() {
        return title;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String[] getAuthors() {
        return authors;
    }

    public int getAuthorCount() {
        return authors.length;
    }

    public String getAuthor(int index) {
        if (index < 0 || authors == null || index >= authors.length) {
            throw new IllegalArgumentException("Недопустимый индекс автора!");
        }
        return authors[index];
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isBlank()) {
            throw new IllegalArgumentException("Название не должно быть пустым!");
        }
        this.title = title;
    }

    public void setPublisher(Publisher publisher) {
        if (publisher == null) {
            throw new IllegalArgumentException("Издатель не должен быть пустым!");
        }
        this.publisher = publisher;
    }

    public void setPublicationYear(int publicationYear) {
        if (publicationYear <= 0) {
            throw new IllegalArgumentException("Год публикации должен быть больше нуля!");
        }
        this.publicationYear = publicationYear;
    }

    public void setAuthors(String[] authors) {
        if (authors != null) {
            for (String author : authors) {
                if (author == null || author.trim().isBlank()) {
                    throw new IllegalArgumentException("Имена авторов не должны быть пустыми!");
                }
            }
        }
        this.authors = authors;
    }

    /**
     * Метод формирования вывода информации о книге
     */
    public void print() {
        StringBuilder bookInfo = new StringBuilder();
        bookInfo.append("Название: ").append(title).append("\n");
        bookInfo.append("Издатель: ").append(publisher.getName()).append(" в городе ").append(publisher.getCity()).append("\n");
        bookInfo.append("Год публикации: ").append(publicationYear).append("\n");

        if (authors != null && authors.length > 0) {
            bookInfo.append("Автор(ы): ").append(String.join(", ", authors)).append("\n");
        }

        System.out.println(bookInfo);
    }

    /**
     * Метод вывода информации из массива книг
     *
     * @param books массив книг
     */
    public static void printAll(Book[] books) {
        for (Book book : books) {
            book.print();
        }
    }
}
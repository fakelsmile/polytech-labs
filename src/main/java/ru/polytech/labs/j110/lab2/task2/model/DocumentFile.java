package ru.polytech.labs.j110.lab2.task2.model;

public class DocumentFile extends FormattedFile {

    private int pageCount;

    /**
     * Конструктор для создания объекта документа.
     *
     * @param fileName  имя файла
     * @param size      размер файла
     * @param format    формат
     * @param pageCount количество страниц
     */
    public DocumentFile(String fileName, long size, String format, int pageCount) {
        super(fileName, size, format);
        this.pageCount = pageCount;
    }

    @Override
    public void setFormat(String format) {
        FileFormat fileFormat = FileFormat.getByValue(format);
        if (fileFormat != FileFormat.DOCX) {
            throw new IllegalArgumentException("Формат не является подходящим!");
        }
        this.format = fileFormat;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public String getDetails() {
        return String.format("%s, %d pages", format, pageCount);
    }
}

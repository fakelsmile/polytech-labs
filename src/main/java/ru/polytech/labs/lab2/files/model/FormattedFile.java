package ru.polytech.labs.lab2.files.model;

public abstract class FormattedFile extends File {

    protected FileFormat format;

    /**
     * Конструктор для создания объекта файла
     *
     * @param fileName имя файла
     * @param size     размер файла
     * @param format   формат
     */
    protected FormattedFile(String fileName, long size, String format) {
        super(fileName, size);
        setFormat(format);
    }

    public abstract void setFormat(String format);

    public String getFormat() {
        return format.getValue();
    }
}

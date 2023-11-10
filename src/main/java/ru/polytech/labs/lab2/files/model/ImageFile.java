package ru.polytech.labs.lab2.files.model;

public class ImageFile extends FormattedFile {

    private int width;

    private int height;

    /**
     * Конструктор для создания объекта изображения
     *
     * @param fileName имя файла
     * @param size     размер файла
     * @param format   формат
     * @param width    ширина изображения
     * @param height   высота изображения
     */
    public ImageFile(String fileName, long size, String format, int width, int height) {
        super(fileName, size, format);
        this.width = width;
        this.height = height;
    }

    @Override
    public void setFormat(String format) {
        FileFormat fileFormat = FileFormat.getByValue(format);
        if (fileFormat != FileFormat.PNG) {
            throw new IllegalArgumentException("Формат не является подходящим!");
        }
        this.format = fileFormat;
    }


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String getDetails() {
        return String.format("%s, %dx%d", format, width, height);
    }
}
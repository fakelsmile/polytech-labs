package ru.polytech.labs.lab2.files.model;

public class ImageSize {

    private int width;

    private int height;

    /**
     * Конструктор для создания объекта размера изображения
     *
     * @param width  ширина изображения
     * @param height высота изображения
     */
    public ImageSize(int width, int height) {
        this.width = width;
        this.height = height;
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
    public String toString() {
        return String.format("%dx%d", width, height);
    }
}

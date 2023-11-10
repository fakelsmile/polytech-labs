package ru.polytech.labs.lab2.files.model;

public abstract class File {

    private String fileName;

    private long size;

    /**
     * Конструктор для создания объекта файла
     *
     * @param fileName имя файла
     * @param size     размер файла
     */
    protected File(String fileName, long size) {
        this.fileName = fileName;
        this.size = size;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getDetails() {
        return "";
    }

    /**
     * Выводит информацию о массиве файлов
     *
     * @param files массив файлов
     */
    public static void printAll(File[] files) {
        System.out.println("      File name      |    Size    | Details");
        System.out.println("---------------------+------------+----------");

        for (File file : files) {
            String name = file.getFileName();
            long size = file.getSize();
            String details = file.getDetails();
            System.out.println(String.format("%-20s | %10d | %s", name, size, details));
        }
    }
}

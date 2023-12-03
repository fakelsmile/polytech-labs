package ru.polytech.labs.j110.lab2.task2.model;

public class MultimediaFile extends FormattedFile {

    private String contentDescription;

    private Duration duration;

    /**
     * Конструктор для создания объекта мультимедийного файла
     *
     * @param fileName           имя файла
     * @param size               размер файла
     * @param format             формат
     * @param contentDescription описание содержания мультимедиа
     * @param duration           продолжительность мультимедиа
     */
    public MultimediaFile(String fileName, long size, String format, String contentDescription, Duration duration) {
        super(fileName, size, format);
        this.contentDescription = contentDescription;
        this.duration = duration;
    }

    @Override
    public void setFormat(String format) {
        FileFormat fileFormat = FileFormat.getByValue(format);
        switch (fileFormat) {
            case AVI:
            case MP3:
                this.format = fileFormat;
                break;
            default:
                throw new IllegalArgumentException("Формат не является подходящим!");
        }
    }

    public String getContentDescription() {
        return contentDescription;
    }

    public void setContentDescription(String contentDescription) {
        this.contentDescription = contentDescription;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    @Override
    public String getDetails() {
        return String.format("audio, %s, %s", contentDescription, duration.toString());
    }
}
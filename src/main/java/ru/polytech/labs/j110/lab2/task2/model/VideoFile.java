package ru.polytech.labs.j110.lab2.task2.model;

public class VideoFile extends MultimediaFile {

    private ImageSize imageSize;

    /**
     * Конструктор для создания объекта видеофайла
     *
     * @param fileName           имя файла
     * @param size               размер файла
     * @param format             формат
     * @param contentDescription описание содержания видео
     * @param duration           продолжительность видео
     * @param imageSize          размер изображения видео
     */
    public VideoFile(
            String fileName,
            long size,
            String format,
            String contentDescription,
            Duration duration,
            ImageSize imageSize) {
        super(fileName, size, format, contentDescription, duration);
        this.imageSize = imageSize;
    }

    public ImageSize getImageSize() {
        return imageSize;
    }

    public void setImageSize(ImageSize imageSize) {
        this.imageSize = imageSize;
    }

    @Override
    public void setFormat(String format) {
        FileFormat fileFormat = FileFormat.getByValue(format);
        if (fileFormat != FileFormat.AVI) {
            throw new IllegalArgumentException("Формат не является подходящим!");
        }
        this.format = fileFormat;
    }

    @Override
    public String getDetails() {
        return String.format(
                "video, %s, %s, %s", getContentDescription(), getDuration().toString(), imageSize.toString()
        );
    }
}

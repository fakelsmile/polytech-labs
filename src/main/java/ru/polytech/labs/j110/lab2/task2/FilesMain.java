package ru.polytech.labs.j110.lab2.task2;

import ru.polytech.labs.j110.lab2.task2.model.DocumentFile;
import ru.polytech.labs.j110.lab2.task2.model.Duration;
import ru.polytech.labs.j110.lab2.task2.model.File;
import ru.polytech.labs.j110.lab2.task2.model.ImageFile;
import ru.polytech.labs.j110.lab2.task2.model.ImageSize;
import ru.polytech.labs.j110.lab2.task2.model.MultimediaFile;
import ru.polytech.labs.j110.lab2.task2.model.VideoFile;

public class FilesMain {
    public static void main(String[] args) {
        File[] files = new File[4];
        files[0] = new DocumentFile("j110-lab2-hiers.docx", 23212, "docx", 2);
        files[1] = new ImageFile("spb-map.png", 1703527, "png", 1024, 3072);
        files[2] = new MultimediaFile("06-PrettyGirl.mp3", 7893454, "mp3", "Eric Clapton - Pretty Girl", new Duration(0, 5, 28));
        files[3] = new VideoFile("BackToTheFuture1.avi", 1470984192, "avi", "Back to the future I, 1985", new Duration(1, 48, 8), new ImageSize(640, 352));

        File.printAll(files);

        // Создаем массив на базе дочернего типа DocumentFile
        DocumentFile[] documentFiles = new DocumentFile[2];
        documentFiles[0] = new DocumentFile("report.docx", 12345, "docx", 10);
        documentFiles[1] = new DocumentFile("notes.docx", 67890, "docx", 5);

        // Вызываем метод printAll для массива documentFiles, который содержит объекты типа DocumentFile.
        // Этот метод подходит для массива дочернего типа, так как DocumentFile является подтипом File
        // и наследует метод getDetails() от File, который используется в методе printAll для вывода
        // специфичных деталей типа DocumentFile.
        System.out.println();
        File.printAll(documentFiles);
    }
}

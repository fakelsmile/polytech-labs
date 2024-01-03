package ru.polytech.labs.j120.lab4.task1.model;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Objects;

public class FileViewer extends Application {

    // Список файлов
    private ListView<String> fileList;

    // Текстовое поле для содержимого файла
    private TextArea fileContent;

    // Массив файлов в текущей директории
    private File[] children;

    /**
     * Переход к указанной директории и отображение ее содержимого
     *
     * @param path путь к директории
     */
    private void goToDir(String path) {
        File dir = new File(path);
        File[] a = dir.listFiles();
        if (a == null) {
            fileContent.setText("Ошибка чтения директории.");
            return;
        }

        Arrays.sort(a, this::compareFiles);
        children = a;

        File parent = dir.getParentFile();
        if (parent != null) {
            children = Arrays.copyOf(children, children.length + 1);
            System.arraycopy(children, 0, children, 1, children.length - 1);
            children[0] = parent;
        }

        fileList.getItems().clear();
        for (File child : children) {
            fileList.getItems().add(child.getName());
        }
    }

    /**
     * Обработка изменения выбранного элемента в списке файлов
     *
     * @param selectedFile выбранный файл
     */
    private void listSelectionChanged(String selectedFile) {
        int ndx = fileList.getSelectionModel().getSelectedIndex();
        if (ndx == -1) return;

        File selected = children[ndx];
        if (selected.isDirectory()) {
            fileContent.setText("");
            goToDir(selected.getAbsolutePath());
        } else {
            try {
                byte[] bytes = Files.readAllBytes(selected.toPath());
                String content = new String(bytes, StandardCharsets.UTF_8);
                fileContent.setText(content);
                fileContent.positionCaret(0);
            } catch (IOException ex) {
                fileContent.setText("Ошибка чтения файла: " + ex.getMessage());
            }
        }
    }

    /**
     * Сравнение файлов для сортировки
     *
     * @param firstFile первый файл
     * @param secondFile второй файл
     * @return результат сравнения
     */
    private int compareFiles(File firstFile, File secondFile) {
        if (firstFile.isDirectory() && secondFile.isFile()) return -1;
        if (firstFile.isFile() && secondFile.isDirectory()) return 1;
        return Objects.requireNonNull(firstFile.getName()).compareTo(secondFile.getName());
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        fileList = new ListView<>();
        fileList.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> listSelectionChanged(newValue));
        fileList.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                int ndx = fileList.getSelectionModel().getSelectedIndex();
                if (ndx >= 0 && children[ndx].isDirectory()) {
                    goToDir(children[ndx].getAbsolutePath());
                }
            }
        });
        fileList.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                int ndx = fileList.getSelectionModel().getSelectedIndex();
                if (ndx >= 0 && children[ndx].isDirectory()) {
                    goToDir(children[ndx].getAbsolutePath());
                }
            }
        });

        fileContent = new TextArea();
        fileContent.setEditable(false);

        SplitPane splitPane = new SplitPane();
        splitPane.setOrientation(Orientation.HORIZONTAL);
        splitPane.getItems().addAll(fileList, fileContent);

        root.setCenter(splitPane);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Просмотр файлов");
        primaryStage.show();

        goToDir(System.getProperty("user.dir"));
    }
}


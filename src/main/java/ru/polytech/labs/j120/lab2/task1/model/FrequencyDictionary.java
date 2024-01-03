package ru.polytech.labs.j120.lab2.task1.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyDictionary {

    private final Map<String, Integer> wordFrequency;

    private final String filePath;

    /**
     * Конструктор класса FrequencyDictionary
     * Инициализирует словарь для хранения частоты слов
     *
     * @param filePath путь к текстовому файлу
     */
    public FrequencyDictionary(String filePath) {
        this.filePath = filePath;
        this.wordFrequency = new HashMap<>();
    }

    /**
     * Обрабатывает текстовый файл для подсчета частоты слов
     *
     * @return словарь частоты слов
     */
    public Map<String, Integer> getWordFrequency() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.lines()
                    .flatMap(line -> Arrays.stream(line.toLowerCase()
                            .replace(",", " ")
                            .replace("«", " ")
                            .replace("»", " ")
                            .replace("-", " ")
                            .replace(" — ", " ")
                            .replace("…", " ")
                            .split("[\\s\\p{Punct}]+")))
                    .filter(word -> word.length() > 1)
                    .forEach(this::updateWordFrequency);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
            System.exit(1);
        }
        return Collections.unmodifiableMap(wordFrequency);
    }

    /**
     * Обновляет частоту слова в словаре
     *
     * @param word слово для обновления частоты
     */
    private void updateWordFrequency(String word) {
        wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
    }

    /**
     * Генерирует отчеты на основе словаря частоты слов
     *
     * @param wordFrequency словарь частоты слов
     * @param reportPath    путь для сохранения отчетов
     */
    public void generateReports(Map<String, Integer> wordFrequency, String reportPath) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordFrequency.entrySet());

        list.sort(Map.Entry.comparingByKey());
        saveReport(reportPath + "report-by-alph.txt", list);

        list.sort(Comparator.comparing(a -> new StringBuilder(a.getKey()).reverse().toString()));
        saveReport(reportPath + "report-by-alph-rev.txt", list);

        list.sort((a, b) -> {
            int freqComparison = b.getValue().compareTo(a.getValue());
            return freqComparison != 0 ? freqComparison : a.getKey().compareTo(b.getKey());
        });
        saveReport(reportPath + "report-by-freq.txt", list);
    }

    /**
     * Сохраняет отчет в файл
     *
     * @param fileName имя файла для сохранения отчета
     * @param list     список записей частоты слов
     */
    private void saveReport(String fileName, List<Map.Entry<String, Integer>> list) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            list.forEach(entry -> writer.println(entry.getKey() + ": " + entry.getValue()));
            System.out.println("Сохранено: " + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении отчета " + fileName + ": " + e.getMessage());
        }
    }
}

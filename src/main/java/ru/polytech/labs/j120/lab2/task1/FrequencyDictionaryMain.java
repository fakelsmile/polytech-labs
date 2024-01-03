package ru.polytech.labs.j120.lab2.task1;

import ru.polytech.labs.j120.lab2.task1.model.FrequencyDictionary;

import java.util.Map;

public class FrequencyDictionaryMain {
    public static void main(String[] args) {
        String filePath = "путь к файлу";
        String reportPath = "путь к директории для сохранения отчетов";

        FrequencyDictionary frequencyDictionary = new FrequencyDictionary(filePath);
        Map<String, Integer> wordFrequency = frequencyDictionary.getWordFrequency();

        if (!wordFrequency.isEmpty()) {
            frequencyDictionary.generateReports(wordFrequency, reportPath);
        }
    }
}

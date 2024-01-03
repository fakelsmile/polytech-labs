package ru.polytech.labs.j120.lab2.task2.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScriptInterpreter {

    private static final Pattern SET_PATTERN = Pattern.compile("^set\\s+(\\$\\w+)\\s*=\\s*(.*)$");

    private static final Pattern PRINT_PATTERN = Pattern.compile("^print\\s+(.*)$");

    private static final Pattern INPUT_PATTERN = Pattern.compile("^input\\s+\"([^\"]+)\",\\s*(\\$\\w+)$");

    private final Map<String, Integer> variables = new HashMap<>();

    /**
     * Выполняет скрипт, расположенный по указанному пути к файлу
     *
     * @param filePath путь к файлу со скриптом
     */
    public void runScript(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.lines()
                    .filter(line -> !line.trim().isEmpty() && !line.trim().startsWith("#"))
                    .forEach(this::processLine);
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    /**
     * Проверяет, соответствует ли строка заданному шаблону команды
     *
     * @param line    строка для проверки
     * @param matcher объект Matcher для соответствующего шаблона
     * @return true, если строка соответствует шаблону, иначе false
     */
    private boolean validateCommand(String line, Matcher matcher) {
        if (matcher.matches()) {
            return true;
        } else {
            System.out.println("Ошибка: Некорректная команда в строке: " + line);
            return false;
        }
    }

    /**
     * Обрабатывает каждую строку файла скрипта
     *
     * @param line строка для обработки
     */
    private void processLine(String line) {
        getCommandType(line)
                .ifPresent(commandType -> {
                    switch (commandType) {
                        case SET:
                            handleSetCommand(line, SET_PATTERN.matcher(line));
                            break;
                        case PRINT:
                            handlePrintCommand(line, PRINT_PATTERN.matcher(line));
                            break;
                        case INPUT:
                            handleInputCommand(line, INPUT_PATTERN.matcher(line));
                            break;
                    }
                });
    }

    /**
     * Определяет тип команды в заданной строке
     *
     * @param line строка с командой
     * @return вариант типа CommandType, соответствующий найденной команде
     */
    private Optional<CommandType> getCommandType(String line) {
        return Arrays.stream(CommandType.values())
                .filter(commandType -> line.startsWith(commandType.getCommand()))
                .findFirst();
    }

    /**
     * Обрабатывает команду 'set', устанавливая значение переменной
     *
     * @param line    строка с командой 'set'
     * @param matcher объект Matcher для соответствующего шаблона
     */
    private void handleSetCommand(String line, Matcher matcher) {
        if (validateCommand(line, matcher)) {
            String variable = matcher.group(1);
            String expression = matcher.group(2);

            try {
                int result = evaluateExpression(expression);
                variables.put(variable, result);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка в выражении: " + e.getMessage());
            }
        }
    }

    /**
     * Обрабатывает команду 'print', выводя содержимое на экран
     *
     * @param line    строка с командой 'print'
     * @param matcher объект Matcher для соответствующего шаблона
     */
    private void handlePrintCommand(String line, Matcher matcher) {
        if (validateCommand(line, matcher)) {
            String contentToPrint = matcher.group(1);
            List<String> tokens = printContent(contentToPrint);

            String output = tokens.stream()
                    .map(String::trim)
                    .map(this::resolveFragment)
                    .reduce("", String::concat);

            if (!output.isEmpty()) {
                System.out.println(output);
            }
        }
    }

    /**
     * Обрабатывает команду 'input', ожидая ввода значения от пользователя
     *
     * @param line    строка с командой 'input'
     * @param matcher объект Matcher для соответствующего шаблона
     */
    private void handleInputCommand(String line, Matcher matcher) {
        if (validateCommand(line, matcher) && matcher.matches()) {
            String prompt = matcher.group(1);
            String variable = matcher.group(2);

            Scanner scanner = new Scanner(System.in);
            System.out.print(prompt);
            int input = scanner.nextInt();

            variables.put(variable, input);
        }
    }

    /**
     * Определяет содержимое фрагмента
     *
     * @param fragment фрагмент для определения содержимого
     * @return содержимое фрагмента
     */
    private String resolveFragment(String fragment) {
        if (fragment.startsWith("\"") && fragment.endsWith("\"")) {
            return fragment.substring(1, fragment.length() - 1);
        } else if (fragment.startsWith("$") && variables.containsKey(fragment)) {
            return String.valueOf(variables.get(fragment));
        } else {
            System.out.println("Ошибка: Неизвестная переменная или некорректное выражение: " + fragment);
            System.exit(1); // Завершение программы при ошибке
            return "";
        }
    }

    /**
     * Вычисляет значение выражения
     *
     * @param expression выражение для вычисления
     * @return результат вычисления выражения
     */
    private int evaluateExpression(String expression) {
        String[] fragments = expression.split("\\s+");
        int result = 0;
        boolean addition = true;

        for (String fragment : fragments) {
            switch (fragment) {
                case "+":
                    addition = true;
                    break;
                case "-":
                    addition = false;
                    break;
                default:
                    result = calculateValueByFragment(result, fragment, addition);
            }
        }
        return result;
    }

    /**
     * Вычисляет значение по фрагменту и выполняет операции сложения/вычитания
     *
     * @param result   текущий результат вычислений
     * @param fragment фрагмент для вычисления
     * @param addition флаг операции сложения/вычитания
     * @return результат операции сложения/вычитания
     */
    private int calculateValueByFragment(int result, String fragment, boolean addition) {
        if (fragment.startsWith("$")) {
            if (variables.containsKey(fragment)) {
                int value = variables.get(fragment);
                return addition ? result + value : result - value;
            } else {
                throw new IllegalArgumentException("Неизвестная переменная: " + fragment);
            }
        } else {
            try {
                int value = Integer.parseInt(fragment);
                return addition ? result + value : result - value;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Некорректное выражение: " + fragment);
            }
        }
    }

    /**
     * Разделяет содержимое команды 'print' на фрагменты
     *
     * @param contentToPrint содержимое для печати
     * @return список фрагментов содержимого
     */
    private List<String> printContent(String contentToPrint) {
        List<String> fragments = new ArrayList<>();
        Matcher fragmentMatcher = Pattern.compile("([\"].+?\")|([$]\\w+)|([\\d+]+)|([-+])").matcher(contentToPrint);

        while (fragmentMatcher.find()) {
            fragments.add(fragmentMatcher.group());
        }

        return fragments;
    }
}
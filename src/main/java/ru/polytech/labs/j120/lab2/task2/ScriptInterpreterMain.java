package ru.polytech.labs.j120.lab2.task2;

import ru.polytech.labs.j120.lab2.task2.model.ScriptInterpreter;

public class ScriptInterpreterMain {

    public static void main(String[] args) {
        String filePath = "путь к файлу";
        ScriptInterpreter interpreter = new ScriptInterpreter();
        interpreter.runScript(filePath);
    }
}

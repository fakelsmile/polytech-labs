package ru.polytech.labs.j120.lab2.task2.model;

public enum CommandType {
    SET("set"),
    PRINT("print"),
    INPUT("input");


    CommandType(String command){
        this.command=command;
    }
    private final String command;

    public String getCommand() {
        return command;
    }
}

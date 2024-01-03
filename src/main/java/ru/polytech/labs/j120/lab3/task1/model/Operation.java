package ru.polytech.labs.j120.lab3.task1.model;

public enum Operation {
    ADDITION((a1, a2) -> a1 + a2),
    SUBTRACTION((a1, a2) -> a1 - a2),
    MULTIPLICATION((a1, a2) -> a1 * a2),
    DIVISION((a1, a2) -> a1 / a2);

    BinaryDoubleOperator operator;

    Operation(BinaryDoubleOperator operator) {
        this.operator = operator;
    }

}

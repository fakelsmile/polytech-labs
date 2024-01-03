package ru.polytech.labs.j120.lab3.task1.model;

/**
 * Функциональный интерфейс для выполнения операций над двумя числами типа double
 */
@FunctionalInterface
public interface BinaryDoubleOperator {
    double eval(double a1, double a2);
}

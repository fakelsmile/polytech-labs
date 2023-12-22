package ru.polytech.labs.j120.lab1.task4;

import ru.polytech.labs.j120.lab1.task4.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentMain {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        Student.addAll(students);

        for (Student student : students) {
            student.print();
        }
    }
}

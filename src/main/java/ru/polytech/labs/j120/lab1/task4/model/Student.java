package ru.polytech.labs.j120.lab1.task4.model;

import java.util.Collection;

public class Student extends Person {

    private EducationGrade grade;

    private Course course;

    /**
     * Конструктор для создания объекта Student
     *
     * @param name       имя
     * @param gender     пол
     * @param department отделение
     * @param grade      уровень образования
     * @param course     курс
     */
    public Student(String name, Gender gender, String department, EducationGrade grade, Course course) {
        super(name, gender, department);
        this.grade = grade;
        this.course = course;
    }

    @Override
    public void print() {
        super.print();
        String pronoun = gender.getPronoun();
        String gradeStr = grade.getLabel();
        String courseStr = course.getRomanNumeral();
        System.out.println(pronoun + " is in " + courseStr + " year " + gradeStr + " student.");
    }

    /**
     * Статический метод для заполнения коллекции данными о студентах
     *
     * @param collection коллекция, которую нужно заполнить
     */
    public static void addAll(Collection<? super Student> collection) {
        // Добавление данных о студентах в переданную коллекцию
        collection.add(new Student("Leo Wilkinson", Gender.MALE, "Computer science", EducationGrade.BACHELOR, Course.THIRD));
        collection.add(new Student("Anna Cunningham", Gender.FEMALE, "World economy", EducationGrade.BACHELOR, Course.FIRST));
    }
}

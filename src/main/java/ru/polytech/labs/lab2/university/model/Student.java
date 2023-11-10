package ru.polytech.labs.lab2.university.model;

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
}

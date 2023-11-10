package ru.polytech.labs.lab2.university;

import ru.polytech.labs.lab2.university.model.Aspirant;
import ru.polytech.labs.lab2.university.model.Course;
import ru.polytech.labs.lab2.university.model.Degree;
import ru.polytech.labs.lab2.university.model.EducationGrade;
import ru.polytech.labs.lab2.university.model.Gender;
import ru.polytech.labs.lab2.university.model.Person;
import ru.polytech.labs.lab2.university.model.Student;
import ru.polytech.labs.lab2.university.model.Teacher;

public class UniversityMain {
    public static void main(String[] args) {
        Person[] people = {
                new Teacher("Ronald Turner", Gender.MALE, "Computer science", Degree.PHD, "Programming paradigms"),
                new Teacher("Ruth Hollings", Gender.FEMALE, "Jurisprudence", Degree.MSC, "Domestic arbitration"),
                new Student("Leo Wilkinson", Gender.MALE, "Computer science", EducationGrade.BACHELOR, Course.THIRD),
                new Student("Anna Cunningham", Gender.FEMALE, "World economy", EducationGrade.BACHELOR, Course.FIRST),
                new Student("Jill Lundqvist", Gender.FEMALE, "Jurisprudence", EducationGrade.MASTER, Course.FIRST),
                new Aspirant("Ronald Correa", Gender.MALE, "Computer science", "Design of a functional programming language.")
        };

        University.printAll(people);
    }
}

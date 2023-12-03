package ru.polytech.labs.j110.lab2.task1;

import ru.polytech.labs.j110.lab2.task1.model.Aspirant;
import ru.polytech.labs.j110.lab2.task1.model.Course;
import ru.polytech.labs.j110.lab2.task1.model.Degree;
import ru.polytech.labs.j110.lab2.task1.model.EducationGrade;
import ru.polytech.labs.j110.lab2.task1.model.Gender;
import ru.polytech.labs.j110.lab2.task1.model.Person;
import ru.polytech.labs.j110.lab2.task1.model.Student;
import ru.polytech.labs.j110.lab2.task1.model.Teacher;

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

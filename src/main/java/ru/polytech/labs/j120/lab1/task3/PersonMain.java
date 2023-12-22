package ru.polytech.labs.j120.lab1.task3;

import ru.polytech.labs.j120.lab1.task3.model.Course;
import ru.polytech.labs.j120.lab1.task3.model.EducationGrade;
import ru.polytech.labs.j120.lab1.task3.model.Gender;
import ru.polytech.labs.j120.lab1.task3.model.Person;
import ru.polytech.labs.j120.lab1.task3.model.Student;

import java.util.ArrayList;
import java.util.Collection;

public class PersonMain {
    public static void main(String[] args) {
        Collection<Student> students = new ArrayList<>();
        students.add(new Student("Leo Wilkinson", Gender.MALE, "Computer science", EducationGrade.BACHELOR, Course.THIRD));
        students.add(new Student("Anna Cunningham", Gender.FEMALE, "World economy", EducationGrade.BACHELOR, Course.FIRST));

        // Метод printPeople выведет информацию о каждом человеке в коллекции,
        // так как за счет использования wildcard <? extends Person> в параметре,
        // метод printPeople может обрабатывать коллекции любого класса, расширяющего Person.

        Person.printPeople(students);
    }
}

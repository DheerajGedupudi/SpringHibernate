package practice;

import Entity.Student;

import java.util.ArrayList;
import java.util.List;

public class DemoCrud
{
    public static void main(String[] args)
    {
        Student student1 = new Student("Ram", "Sharma", "ram@gmail.com");
        Student student2 = new Student("Sham", "Varma", "Sham@gmail.com");
        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);

//        CreateStudent.add(list);

//        DeleteStudent.deleteLastStudent();

        UpdateStudent.updateLastStudentWithFirstName("Nolan");
    }

}

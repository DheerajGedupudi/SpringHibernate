package practice;

import Entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForDheeraj
{
    public static void main(String[] args)
    {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            //begin

            session.beginTransaction();

            Student dheeraj = new Student("Dheeraj", "Hey", "dheeraj@hello.com");

            Course course1 = new Course("Rubix Cube - How to solve 3x3 Cube");
            Course course2 = new Course("Advanced Rubix Cube - Moving to 4x4 Cube");

            System.out.println("New Student : "+dheeraj);
            System.out.println("The courses are : "+course1+", "+course2);

            session.save(dheeraj);

            System.out.println("New student is saved");

            //adding student to the courses
            course1.addStudent(dheeraj);
            course2.addStudent(dheeraj);

            System.out.println("Saving the courses");

            session.save(course1);
            session.save(course2);

            session.getTransaction().commit();

            System.out.println("Done");
        }
        finally {
            session.close();
            factory.close();
        }
    }

}

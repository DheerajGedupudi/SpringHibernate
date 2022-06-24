package practice;

import Entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndStudents
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

            //course create
            Course myCourse = new Course("Pubg - How to survive the Pubg");
            System.out.println("Saving course");

            session.save(myCourse);
            System.out.println("Course has been saved : "+myCourse);

            //student create
            Student student1 = new Student("John", "Hello", "john@gmail.com");
            Student student2 = new Student("James", "Bond", "james@gmail.com");

            myCourse.addStudent(student1);
            myCourse.addStudent(student2);

            System.out.println("Saving students");

            session.save(student1);
            session.save(student2);

            System.out.println("Students are saved : "+myCourse.getStudents());

            session.getTransaction().commit();

            System.out.println("Done");
        }
        finally {
            session.close();
            factory.close();
        }
    }

}

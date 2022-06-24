package practice;

import Entity.Course;
import Entity.Instructor;
import Entity.InstructorDetail;
import Entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourses
{
    public static void main(String[] args)
    {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            //begin

            session.beginTransaction();

            int id = 1;

            Instructor myInstructor = session.get(Instructor.class, id);

            Course course1 = new Course("Eat - How to eat Apple");
            Course course2 = new Course("Eat - How to eat Mango");

            myInstructor.add(course1);
            myInstructor.add(course2);

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

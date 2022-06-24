package practice;

import Entity.Course;
import Entity.Instructor;
import Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorsCourses
{
    public static void main(String[] args)
    {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            //begin

            session.beginTransaction();

            int id = 1;

            Instructor myInstructor = session.get(Instructor.class, id);

            System.out.println("Instructor is : "+myInstructor);

//            System.out.println("Courses are : "+myInstructor.getCourses());

            session.getTransaction().commit();

            session.close();
            System.out.println("Session is closed");

            //Lazy Loading Check
            System.out.println("Courses are : "+myInstructor.getCourses());

            System.out.println("Done");
        }
        finally {
            session.close();
            factory.close();
        }
    }

}

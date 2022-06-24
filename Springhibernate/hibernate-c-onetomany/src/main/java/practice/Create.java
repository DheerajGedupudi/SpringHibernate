package practice;

import Entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Create
{
    public static void main(String[] args)
    {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            Instructor myInstructor = new Instructor("John", "Son", "john@son.com");

            InstructorDetail myInstructorDetail = new InstructorDetail("www.youtube/john.com", "Sleep");

            myInstructor.setInstructorDetail(myInstructorDetail);

            //begin

            session.beginTransaction();

            System.out.println("Saving the Instructor : "+myInstructor);
            session.save(myInstructor);

            session.getTransaction().commit();

            System.out.println("Done");
        }
        finally {
            factory.close();
        }
    }

}

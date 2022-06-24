package practice;

import Entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructor
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
            Instructor myInstructor = new Instructor("Jack", "Hey", "jack@hello.com");

            InstructorDetail myInstructorDetail = new InstructorDetail("www.youtube/jack.com", "Eating");

            myInstructor.setInstructorDetail(myInstructorDetail);

            //begin

            session.beginTransaction();

            System.out.println("Saving the Instructor : "+myInstructor);
            session.save(myInstructor);

            session.getTransaction().commit();

            System.out.println("Done");
        }
        finally {
            session.close();
            factory.close();
        }
    }

}

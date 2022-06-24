package practice;

import Entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetail
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

            //begin

            session.beginTransaction();

            int id = 100;
            InstructorDetail myInstructorDetail = session.get(InstructorDetail.class, id);

            System.out.println("Got InstructorDetails : "+myInstructorDetail);

            System.out.println("The related instructor : "+myInstructorDetail.getInstructor());

            session.getTransaction().commit();

            System.out.println("Done");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }
    }

}

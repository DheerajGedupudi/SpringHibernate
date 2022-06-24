package practice;

import Entity.Instructor;
import Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Delete
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

            int id = 2;

            //begin

            session.beginTransaction();

            Instructor myInstructor = session.get(Instructor.class, id);

            System.out.println("Got the instructor : "+myInstructor);

            if (myInstructor!=null)
            {
                System.out.println("Deleting");

                session.delete(myInstructor);
            }

            session.getTransaction().commit();

            System.out.println("Done");
        }
        finally {
            factory.close();
        }
    }

}

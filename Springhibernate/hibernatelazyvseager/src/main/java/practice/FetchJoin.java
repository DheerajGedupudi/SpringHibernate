package practice;

import Entity.Course;
import Entity.Instructor;
import Entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoin
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

            Query<Instructor> query =
                    session.createQuery("select i from Instructor i Join Fetch i.courses where i.id = :myInstructorId", Instructor.class);

            query.setParameter("myInstructorId", id);

            Instructor myInstructor = query.getSingleResult();

            System.out.println("Instructor is : "+myInstructor);

            session.getTransaction().commit();

            session.close();

            System.out.println("Session is closed");

            System.out.println("Courses are : "+myInstructor.getCourses());

            System.out.println("Done");
        }
        finally {
            session.close();
            factory.close();
        }
    }

}

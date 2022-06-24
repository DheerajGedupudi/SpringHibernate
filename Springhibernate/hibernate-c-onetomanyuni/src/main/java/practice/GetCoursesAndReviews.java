package practice;

import Entity.Course;
import Entity.Instructor;
import Entity.InstructorDetail;
import Entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCoursesAndReviews
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

            int id = 10;
            Course myCourse = session.get(Course.class, id);

            System.out.println(myCourse);

            System.out.println(myCourse.getReviews());

            myCourse.addReview(new Review("CallOfDuty is a great game"));

            session.save(myCourse);

            session.getTransaction().commit();

            System.out.println("Done");
        }
        finally {
            session.close();
            factory.close();
        }
    }

}

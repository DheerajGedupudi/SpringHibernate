package practice;

import Entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndReviews
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

            Course myCourse = new Course("Pubg - How to survive the Pubg");

            myCourse.addReview(new Review("Thanks. Learnt how to choose guns"));
            myCourse.addReview(new Review("Thanks. Learnt how to throw grenades"));
            myCourse.addReview(new Review("Bad Course. Clickbaited me"));

            System.out.println("Saving the course");
            System.out.println(myCourse);
            System.out.println(myCourse.getReviews());

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

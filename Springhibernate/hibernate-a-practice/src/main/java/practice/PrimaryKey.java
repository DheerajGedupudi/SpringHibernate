package practice;

import Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKey
{
    public static void main(String[] args)
    {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            System.out.println("creating 3 new student");

            Student student1 = new Student("Ramesh", "Hello", "ramesh@zemoso.com");
            Student student2 = new Student("Suresh", "Hi", "suresh@zemoso.com");
            Student student3 = new Student("Mahesh", "Hey", "mahesh@zemoso.com");

            session.beginTransaction();

            System.out.println("Saving the students");
            session.save(student1);
            session.save(student2);
            session.save(student3);

            session.getTransaction().commit();

            System.out.println("Done");
        }
        finally {
            factory.close();
        }
    }
}

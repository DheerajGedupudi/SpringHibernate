package practice;

import Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudent
{
    public static void main(String[] args)
    {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            System.out.println("creating a new student");

            Student myStudent = new Student("John", "Son", "john@zemoso.com");

            session.beginTransaction();

            System.out.println("Saving a student");
            System.out.println(myStudent);
            session.save(myStudent);

            session.getTransaction().commit();

            //Reading

            System.out.println("Saved student with ID : "+myStudent.getId());

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Student with Id : "+myStudent.getId());

            Student theStudent = session.get(Student.class, myStudent.getId());

            System.out.println("Get the student : "+theStudent);

            session.getTransaction().commit();

            System.out.println("Done");
        }
        finally {
            factory.close();
        }
    }
}

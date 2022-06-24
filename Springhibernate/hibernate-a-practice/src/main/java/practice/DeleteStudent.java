package practice;

import Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DeleteStudent
{
    public static void main(String[] args)
    {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            session.beginTransaction();

            int id = 10;

            System.out.println("Getting student with id : "+id);

            Student myStudent = session.get(Student.class, id);

            System.out.println(("Deleting the student : "+myStudent));

            session.delete(myStudent);

            session.getTransaction().commit();

            System.out.println("Done");
        }
        finally {
            factory.close();
        }
    }

    public static void deleteLastStudent()
    {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            List<Integer> list = session.createQuery("select max(id) from Student").getResultList();

            int lastId = list.get(list.size() - 1);

            System.out.println(lastId);

            Student theStudent = session.get(Student.class, lastId);

            session.delete(theStudent);

            session.getTransaction().commit();

            System.out.println("Done");
        }
        finally {
            factory.close();
        }
    }
}

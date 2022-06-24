package practice;

import Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UpdateStudent
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

            int id = 2;

//            System.out.println("Getting the student with id : "+id);
//
//            Student myStudent = session.get(Student.class, id);
//
//            System.out.println("Got : "+myStudent);
//
//            System.out.println("Updating the student");
//            myStudent.setFirstName("David");

            //update 2

//            System.out.println("Update David's email");
//            session.createQuery("update Student set email='david@gmail.com' where firstName='David'").executeUpdate();

            //update 3

            List<Integer> list = session.createQuery("select max(id) from Student").getResultList();

            int lastId = list.get(list.size()-1);System.out.println(lastId);

            session.createQuery("update Student set firstName='Person123' where id='"+lastId+"'").executeUpdate();
//
            session.getTransaction().commit();
//
            System.out.println("Done");
        }
        finally {
            factory.close();
        }
    }

    public static void updateLastStudentWithFirstName(String firstName)
    {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            session.beginTransaction();

            List<Integer> list = session.createQuery("select max(id) from Student").getResultList();

            int lastId = list.get(list.size()-1);

            System.out.println(lastId);

            session.createQuery("update Student set firstName='"+firstName+"' where id='"+lastId+"'").executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done");
        }
        finally {
            factory.close();
        }
    }
}

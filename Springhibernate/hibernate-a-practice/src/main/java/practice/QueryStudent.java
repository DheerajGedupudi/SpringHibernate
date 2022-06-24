package practice;

import Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class QueryStudent
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

            //query

            List<Student> theStudents = session.createQuery("from Student").getResultList();

            printList(theStudents);

            //query2
            
            theStudents = session.createQuery("from Student s where s.lastName='Son'").getResultList();

            System.out.println("Students with Last Name : Son");

            printList(theStudents);


            //query3

            theStudents = session.createQuery("from Student s where s.firstName='Ramesh' OR s.lastName='Son'").getResultList();

            System.out.println("Students with Firstname : Ramesh or Lastname : Son");

            printList(theStudents);

            //query4
             theStudents = session.createQuery("from Student s where s.lastName LIKE '%son'").getResultList();

            System.out.println("Students with Lastname ending with : son");

            printList(theStudents);

            session.getTransaction().commit();

            System.out.println("Done");
        }
        finally {
            factory.close();
        }
    }

    private static void printList(List<Student> theStudents) {
        for (Student student : theStudents)
        {
            System.out.println(student);
        }
    }
}

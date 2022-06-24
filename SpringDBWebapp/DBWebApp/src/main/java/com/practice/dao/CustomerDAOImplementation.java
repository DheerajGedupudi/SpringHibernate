package com.practice.dao;

import com.practice.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImplementation implements CustomerDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers()
    {
        System.out.println("------------Inside getCustomers()-------");
        Session session = sessionFactory.getCurrentSession();

        System.out.println("The session is : "+session.toString());

        Query<Customer> theQuery = session.createQuery("from Customer order by firstName", Customer.class);

        System.out.println("The query is : "+theQuery.toString());

        List<Customer> customers = theQuery.getResultList();

        System.out.println("The List is : "+customers);

        return customers;
    }

    @Override
    public void saveCustomer(Customer myCustomer)
    {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(myCustomer);
    }

    @Override
    public Customer getCustomer(int myId)
    {
        Session session = sessionFactory.getCurrentSession();

        Customer myCustomer = session.get(Customer.class, myId);

        return myCustomer;
    }

    @Override
    public void deleteCustomer(int id)
    {
        Session session = sessionFactory.getCurrentSession();

        Query myQuery = session.createQuery("delete from Customer where id=:customerId");

        myQuery.setParameter("customerId",id);

        myQuery.executeUpdate();
    }
}

package com.practice.service;

import com.practice.dao.CustomerDAO;
import com.practice.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImplementation implements CustomerService
{
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer myCustomer)
    {
        customerDAO.saveCustomer(myCustomer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int myId) {
        return customerDAO.getCustomer(myId);
    }

    @Override
    @Transactional
    public void deleteCustomer(int id)
    {
        customerDAO.deleteCustomer(id);
    }
}

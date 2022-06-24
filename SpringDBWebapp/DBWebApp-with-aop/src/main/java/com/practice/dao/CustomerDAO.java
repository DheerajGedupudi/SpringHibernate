package com.practice.dao;

import com.practice.entity.Customer;

import java.util.List;

public interface CustomerDAO
{
    public List<Customer> getCustomers();

    void saveCustomer(Customer myCustomer);

    Customer getCustomer(int myId);

    void deleteCustomer(int id);
}

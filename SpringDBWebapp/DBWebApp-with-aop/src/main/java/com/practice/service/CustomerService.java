package com.practice.service;

import com.practice.entity.Customer;

import java.util.List;

public interface CustomerService
{
    public List<Customer> getCustomers();

    public void saveCustomer(Customer myCustomer);

    Customer getCustomer(int myId);

    void deleteCustomer(int id);
}

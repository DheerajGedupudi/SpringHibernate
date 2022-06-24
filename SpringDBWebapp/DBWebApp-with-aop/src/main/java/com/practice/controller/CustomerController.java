package com.practice.controller;

import com.practice.entity.Customer;
import com.practice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController
{
    //injecting service layer
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomer(Model myModel)
    {
        System.out.println("----------------------------------Inside listCustomer()-------------------------");

        List<Customer> theCustomers = customerService.getCustomers();

        System.out.println("The customers are : "+theCustomers);

        myModel.addAttribute("customers", theCustomers);

        return "list-customers";
    }

    @GetMapping("/showFormNewCustomer")
    public String showFormNewCustomer(Model myModel)
    {
        Customer myCustomer = new Customer();

        myModel.addAttribute("customer", myCustomer);

        return "customer-form";
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute("customer") Customer myCustomer)
    {
        customerService.saveCustomer(myCustomer);

        return "redirect:/customer/list";
    }

    @GetMapping("/showFormUpdateCustomer")
    public String showFormUpdateCustomer(@RequestParam("customerId") int myId, Model myModel)
    {
        Customer myCustomer = customerService.getCustomer(myId);

        myModel.addAttribute("customer", myCustomer);

        return "save-customer-form";
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("customerId") int id)
    {
        customerService.deleteCustomer(id);

        return "redirect:/customer/list";
    }

}

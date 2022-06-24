package com.practice.controller;

//import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController
{
    @RequestMapping("showForm")
    public String showTheForm(Model model)
    {
        model.addAttribute("customer", new Customer());

        return "customer-form";
    }

    @RequestMapping("processForm")
    public String processTheForm(@Valid
                                     @ModelAttribute("customer") Customer myCustomer,
                                 BindingResult theBindingResult)
    {
        System.out.println("Last Name : |"+myCustomer.getLastName()+"|");
        System.out.println("Binding result : "+theBindingResult+"\n\n\n\n");
        System.out.println(myCustomer.getNumberCheck());
        if (theBindingResult.hasErrors())
        {
            System.out.println("Errors");
            System.out.println("|"+myCustomer.getPinCode()+"|");
            return "customer-form";
        }
        else
        {
            System.out.println("No Errors");
            return "customer-confirmation";
        }
    }

    //init binder

    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        StringTrimmerEditor editor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, editor);
    }
}

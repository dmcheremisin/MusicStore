package com.music.store.controller;

import com.music.store.entity.BillingAddress;
import com.music.store.entity.Customer;
import com.music.store.entity.ShippingAddress;
import com.music.store.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegisterController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/register")
    public String registerPage(Model model) {
        Customer customer = new Customer();
        customer.setBillingAddress(new BillingAddress());
        customer.setShippingAddress(new ShippingAddress());
        customer.setEnabled(true);

        model.addAttribute("customer", customer);

        return "registerCustomer";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "registerCustomer";
        }

        List<Customer> customers = customerService.getAllCustomers();

        if(customers.stream().anyMatch(c -> customer.getEmail().equalsIgnoreCase(c.getEmail()))) {
            model.addAttribute("emailMsg", "Email already exists");
            return "registerCustomer";
        }

        if(customers.stream().anyMatch(c -> customer.getUserName().equalsIgnoreCase(c.getUserName()))) {
            model.addAttribute("userNameMsg", "User name already exists");
            return "registerCustomer";
        }

        customerService.addCustomer(customer);
        return "registerSuccess";
    }
}

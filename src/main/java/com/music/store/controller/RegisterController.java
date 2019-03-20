package com.music.store.controller;

import com.music.store.entity.BillingAddress;
import com.music.store.entity.Customer;
import com.music.store.entity.ShippingAddress;
import com.music.store.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String register(@ModelAttribute("customer") Customer customer,  Model model) {
        customerService.addCustomer(customer);

        return "registerSuccess";
    }
}

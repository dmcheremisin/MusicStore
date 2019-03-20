package com.music.store.services;

import com.music.store.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer addCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    List<Customer> getAllCustomers();


}

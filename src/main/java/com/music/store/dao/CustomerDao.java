package com.music.store.dao;

import com.music.store.entity.Customer;

import java.util.List;

public interface CustomerDao {

    Customer addCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    List<Customer> getAllCustomers();
}

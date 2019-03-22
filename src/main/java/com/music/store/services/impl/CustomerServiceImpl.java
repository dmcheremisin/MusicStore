package com.music.store.services.impl;

import com.music.store.dao.CustomerDao;
import com.music.store.entity.Customer;
import com.music.store.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public Customer addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
        return customer;
    }

    @Override
    public Customer getCustomerById(int customerId) {
        return customerDao.getCustomerById(customerId);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    @Override
    public Customer getCustomerByUsername(String userName) {
        return customerDao.getCustomerByUsername(userName);
    }
}

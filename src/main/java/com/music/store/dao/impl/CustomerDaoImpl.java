package com.music.store.dao.impl;

import com.music.store.dao.CustomerDao;
import com.music.store.entity.Authority;
import com.music.store.entity.Cart;
import com.music.store.entity.Customer;
import com.music.store.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Customer addCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        customer.getBillingAddress().setCustomer(customer);
        customer.getShippingAddress().setCustomer(customer);

        session.saveOrUpdate(customer);
        session.saveOrUpdate(customer.getBillingAddress());
        session.saveOrUpdate(customer.getShippingAddress());

        User user = new User();
        user.setName(customer.getUserName());
        user.setPassword("{noop}"+customer.getPassword());
        user.setEnabled(true);
        user.setCustomerId(customer.getCustomerId());

        Authority authority = new Authority();
        authority.setUser(user);
        authority.setAuthority("ROLE_USER");

        session.saveOrUpdate(user);
        session.saveOrUpdate(authority);

        Cart cart = new Cart();
        cart.setCustomer(customer);
        customer.setCart(cart);
        session.saveOrUpdate(cart);
        session.saveOrUpdate(customer);

        return customer;
    }

    @Override
    public Customer getCustomerById(int customerId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, customerId);
    }

    @Override
    public List<Customer> getAllCustomers() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from customer");
        List<Customer> customers = query.getResultList();
        return customers;
    }

    @Override
    public Customer getCustomerByUsername(String userName) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Customer where username = ?");
        query.setParameter(0, userName);

        return (Customer) query.getSingleResult();
    }
}

package com.music.store.dao.impl;

import com.music.store.dao.ProductDao;
import com.music.store.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
    }

    @Override
    public Product getProductById(String id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class, id);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        Session session = sessionFactory.getCurrentSession();
        List<Product> products = session.createQuery("from Product").list();
        return products;
    }

    @Override
    public void deleteProduct(String id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getProductById(id));
    }
}

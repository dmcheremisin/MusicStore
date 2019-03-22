package com.music.store.dao.impl;

import com.music.store.dao.CartItemDao;
import com.music.store.entity.CartItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void addCartItem(CartItem cartItem) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cartItem);
    }

    @Override
    public void removeCartItem(CartItem cartItem) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(cartItem);
    }

    @Override
    public CartItem getCartItemByProductId(int productId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CartItem where productId = ?");
        query.setParameter(0, productId);

        return (CartItem) query.getSingleResult();
    }
}

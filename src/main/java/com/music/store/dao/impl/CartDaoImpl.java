package com.music.store.dao.impl;

import com.music.store.dao.CartDao;
import com.music.store.entity.Cart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CartDaoImpl implements CartDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Cart getCartById(int cartId) {
        Session session = sessionFactory.getCurrentSession();
        Cart cart = session.get(Cart.class, cartId);
        return cart;
    }

    @Override
    public void updateCart(Cart cart) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cart);
    }

    @Override
    public void removeAllCartItems(Cart cart) {
        Session session = sessionFactory.getCurrentSession();
        cart.getCartItems().forEach(session::delete);
    }
}

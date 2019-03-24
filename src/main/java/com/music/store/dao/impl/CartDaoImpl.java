package com.music.store.dao.impl;

import com.music.store.dao.CartDao;
import com.music.store.entity.Cart;
import com.music.store.entity.CartItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

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
        double total = getCustomerOrderGrandTotal(cart);
        cart.setTotal(total);

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cart);
    }

    @Override
    public void removeAllCartItems(Cart cart) {
        Session session = sessionFactory.getCurrentSession();
        cart.getCartItems().forEach(session::delete);
    }

    @Override
    public Cart validate(Integer cartId) throws IOException {
        Cart cart = getCartById(cartId);
        if(cart == null || cart.getCartItems() == null || cart.getCartItems().size() == 0){
            throw new IOException("Cart is not valid with id " + cartId);
        }
        updateCart(cart);
        return cart;
    }

    private double getCustomerOrderGrandTotal(Cart cart) {
        double grandTotal=0;
        for (CartItem cartItem : cart.getCartItems()) {
            grandTotal += cartItem.getTotalPrice();
        }
        return grandTotal;
    }
}

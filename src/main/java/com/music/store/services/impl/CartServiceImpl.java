package com.music.store.services.impl;

import com.music.store.dao.CartDao;
import com.music.store.entity.Cart;
import com.music.store.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    @Override
    public Cart getCartById(int cartId) {
        return cartDao.getCartById(cartId);
    }

    @Override
    public void updateCart(Cart cart) {
        cartDao.updateCart(cart);
    }

    @Override
    public void removeAllCartItems(Cart cart) {
        cartDao.removeAllCartItems(cart);
    }
}

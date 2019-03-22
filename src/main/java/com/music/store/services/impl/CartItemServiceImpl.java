package com.music.store.services.impl;

import com.music.store.dao.CartItemDao;
import com.music.store.entity.CartItem;
import com.music.store.services.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemDao cartItemDao;

    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemDao.addCartItem(cartItem);
    }

    @Override
    public void removeCartItem(CartItem cartItem) {
        cartItemDao.removeCartItem(cartItem);
    }

    @Override
    public CartItem getCartItemByProductId(int productId) {
        return cartItemDao.getCartItemByProductId(productId);
    }
}

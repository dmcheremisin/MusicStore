package com.music.store.dao;

import com.music.store.entity.Cart;

import java.io.IOException;

public interface CartDao {

    Cart getCartById(int cartId);

    void updateCart(Cart cart);

    void removeAllCartItems(Cart cart);

    Cart validate(Integer cartId) throws IOException;
}

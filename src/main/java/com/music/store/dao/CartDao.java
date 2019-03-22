package com.music.store.dao;

import com.music.store.entity.Cart;

public interface CartDao {

    Cart getCartById(int cartId);

    void updateCart(Cart cart);

    void removeAllCartItems(Cart cart);
}

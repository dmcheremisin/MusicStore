package com.music.store.dao;

import com.music.store.entity.CartItem;

public interface CartItemDao {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    CartItem getCartItemByProductId(int productId);
}

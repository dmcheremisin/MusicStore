package com.music.store.services;

import com.music.store.entity.Cart;

public interface CartService {

    Cart getCartById(int cartId);

    void updateCart(Cart cart);

    void removeAllCartItems(Cart cart);
}

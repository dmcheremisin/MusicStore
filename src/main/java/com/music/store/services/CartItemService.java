package com.music.store.services;

import com.music.store.entity.CartItem;

public interface CartItemService {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    CartItem getCartItemByProductId(int productId);
}

package com.music.store.dao;

import com.music.store.entity.Cart;

/**
 * Created by Dmitrii on 15.03.2019.
 */
public interface CartDao {
    Cart get(String cartId);
    Cart add(Cart cart);
    void update(String id, Cart cart);
    void delete(String id);
}

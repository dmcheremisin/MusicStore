package com.music.store.dao.impl;

import com.music.store.dao.CartDao;
import com.music.store.entity.Cart;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dmitrii on 15.03.2019.
 */
@Repository
public class CartDaoImpl implements CartDao {

    private Map<String, Cart> listOfCarts = new HashMap<>();

    @Override
    public Cart add(Cart cart) {
        if (listOfCarts.keySet().contains(cart.getId())) {
            throw new IllegalArgumentException(
                    String.format("Can not add cart with %s, because it exists", cart.getId()));
        }
        listOfCarts.put(cart.getId(), cart);
        return cart;
    }

    @Override
    public Cart get(String cartId) {
        return listOfCarts.get(cartId);
    }

    @Override
    public void update(String id, Cart cart) {
        if (listOfCarts.keySet().contains(cart.getId())) {
            throw new IllegalArgumentException(
                    String.format("Can not update cart with %s, because it doesn't exist", cart.getId()));
        }
        listOfCarts.put(cart.getId(), cart);
    }

    @Override
    public void delete(String id) {
        if (!listOfCarts.keySet().contains(id)) {
            throw new IllegalArgumentException(
                    String.format("Can not delete cart with %s, because it doesn't exist", id));
        }
        listOfCarts.remove(id);
    }
}

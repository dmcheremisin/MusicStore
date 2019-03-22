package com.music.store.viewModels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dmitrii on 15.03.2019.
 */
public class CartViewModel {
    private Integer id;
    private List<CartItemViewModel> cartItems;
    private double total;

    public CartViewModel(){
        cartItems = new ArrayList<>();
        total = 0;
    }

    public CartViewModel(Integer id) {
        this();
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<CartItemViewModel> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemViewModel> cartItems) {
        this.cartItems = cartItems;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

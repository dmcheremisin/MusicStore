package com.music.store.viewModels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dmitrii on 15.03.2019.
 */
public class CartViewModel {
    private String id;
    private List<CartItemViewModel> cartItems;
    private double total;

    public CartViewModel(){
        cartItems = new ArrayList<>();
        total = 0;
    }

    public CartViewModel(String id) {
        this();
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

package com.music.store.entity;

import com.music.store.viewModels.CartItemViewModel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dmitrii on 15.03.2019.
 */
public class Cart {
    private String id;
    private Map<Integer, CartItem> cartItems = new HashMap<>();
    private double total;

    public Cart() {
    }

    public Cart(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<Integer, CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<Integer, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void addCartItem(CartItem cartItem){
        int productId = cartItem.getProduct().getProductId();
        cartItems.merge(productId, cartItem, (item, cartItemVm) -> {
            item.setQuantity(item.getQuantity() + cartItemVm.getQuantity());
            item.setTotalPrice(item.getQuantity() * item.getProduct().getProductPrice());
            return item;
        });
        updateTotal();
    }

    public void removeCartItem(CartItem cartItemViewModel) {
        int productId = cartItemViewModel.getProduct().getProductId();
        cartItems.remove(productId);
        updateTotal();
    }

    private void updateTotal() {
        total = 0;
        for(CartItem cartItem : cartItems.values()){
            total += cartItem.getTotalPrice();
        }
    }
}

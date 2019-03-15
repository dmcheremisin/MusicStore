package com.music.store.viewModels;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dmitrii on 15.03.2019.
 */
public class CartViewModel {
    private String id;
    private Map<Integer, CartItemViewModel> cartItems;
    private double total;

    public CartViewModel(){
        cartItems = new HashMap<>();
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

    public Map<Integer, CartItemViewModel> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<Integer, CartItemViewModel> cartItems) {
        this.cartItems = cartItems;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void addCartItem(CartItemViewModel cartItemViewModel){
        int productId = cartItemViewModel.getProductViewModel().getProductId();
        cartItems.merge(productId, cartItemViewModel, (item, cartItemVm) -> {
            item.setQuantity(item.getQuantity() + cartItemVm.getQuantity());
            return item;
        });
        updateTotal();
    }

    public void removeCartItem(CartItemViewModel cartItemViewModel) {
        int productId = cartItemViewModel.getProductViewModel().getProductId();
        cartItems.remove(productId);
        updateTotal();
    }

    private void updateTotal() {
        total = 0;
        for(CartItemViewModel cartItemViewModel : cartItems.values()){
            total += cartItemViewModel.getTotalPrice();
        }
    }
}

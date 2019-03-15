package com.music.store.viewModels;

/**
 * Created by Dmitrii on 15.03.2019.
 */
public class CartItemViewModel {
    private ProductViewModel productViewModel;
    private int quantity;
    private double totalPrice;

    public CartItemViewModel() {
    }

    public CartItemViewModel(ProductViewModel productViewModel, int quatity, double totalPrice) {
        this.productViewModel = productViewModel;
        this.quantity = quatity;
        this.totalPrice = totalPrice;
    }

    public ProductViewModel getProductViewModel() {
        return productViewModel;
    }

    public void setProductViewModel(ProductViewModel productViewModel) {
        this.productViewModel = productViewModel;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}

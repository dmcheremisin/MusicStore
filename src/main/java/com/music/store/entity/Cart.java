package com.music.store.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Dmitrii on 15.03.2019.
 */

@Entity
@Table(name = "cart")
public class Cart implements Serializable {

    private static final long serialVersionUID = 5543344561234328734L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartId")
    private String cartId;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<CartItem> cartItems;

    @OneToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @Column(name = "total")
    private double total;

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

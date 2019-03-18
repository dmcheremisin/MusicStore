package com.music.store.converters.impl;

import com.music.store.converters.CartViewModelToCartModel;
import com.music.store.converters.ProductToProductViewModelConverter;
import com.music.store.entity.Cart;
import com.music.store.entity.CartItem;
import com.music.store.entity.Product;
import com.music.store.viewModels.CartItemViewModel;
import com.music.store.viewModels.CartViewModel;
import com.music.store.viewModels.ProductViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitrii on 15.03.2019.
 */
@Component
public class CartViewModelToCartModelImpl implements CartViewModelToCartModel {

    @Autowired
    private ProductToProductViewModelConverter productConverter;

    @Override
    public Cart convert(CartViewModel cartViewModel) {
        Cart cart = new Cart();

        cart.setCartId(cartViewModel.getId());
        cart.setTotal(cartViewModel.getTotal());
        if(cartViewModel.getCartItems() != null && !cartViewModel.getCartItems().isEmpty()) {
            List<CartItem> cartItems = new ArrayList<>();
            cartViewModel.getCartItems().forEach(v -> cartItems.add(convert(v)));
            cart.setCartItems(cartItems);
        }

        return cart;
    }

    public CartViewModel convert(Cart cart) {
        CartViewModel cartViewModel = new CartViewModel();

        cartViewModel.setId(cart.getCartId());
        cartViewModel.setTotal(cart.getTotal());
        if(cart.getCartItems() != null && !cart.getCartItems().isEmpty()) {
            List<CartItemViewModel> cartItems = new ArrayList<>();
            cart.getCartItems().forEach(v -> cartItems.add(convert(v)));
            cartViewModel.setCartItems(cartItems);
        }

        return cartViewModel;
    }

    private CartItem convert(CartItemViewModel cartItemViewModel) {
        CartItem cartItem = new CartItem();
        cartItem.setQuantity(cartItemViewModel.getQuantity());
        cartItem.setTotalPrice(cartItemViewModel.getTotalPrice());

        ProductViewModel productViewModel = cartItemViewModel.getProductViewModel();
        Product product = productConverter.convert(productViewModel);
        cartItem.setProduct(product);

        return cartItem;
    }

    private CartItemViewModel convert(CartItem cartItem) {
        CartItemViewModel cartItemViewModel = new CartItemViewModel();
        cartItemViewModel.setQuantity(cartItem.getQuantity());
        cartItemViewModel.setTotalPrice(cartItem.getTotalPrice());

        Product product = cartItem.getProduct();
        ProductViewModel productViewModel = productConverter.convert(product);
        cartItemViewModel.setProductViewModel(productViewModel);

        return cartItemViewModel;
    }
}

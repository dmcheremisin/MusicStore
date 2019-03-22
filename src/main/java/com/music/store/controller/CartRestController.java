package com.music.store.controller;

import com.music.store.entity.Cart;
import com.music.store.entity.CartItem;
import com.music.store.entity.Customer;
import com.music.store.entity.Product;
import com.music.store.services.CartItemService;
import com.music.store.services.CartService;
import com.music.store.services.CustomerService;
import com.music.store.services.ProductService;
import com.music.store.viewModels.ProductViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/cart")
public class CartRestController {

    @Autowired
    private CartService cartService;
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductService productService;

    @RequestMapping("/{cartId}")
    public Cart getCartById(@PathVariable int cartId) {
        Cart cart = cartService.getCartById(cartId);
        return cart;
    }

    @PutMapping("/add/{productId}")
    public void addItem(@PathVariable int productId, @AuthenticationPrincipal User user) {
        Customer customer = customerService.getCustomerByUsername(user.getUsername());
        Cart cart = customer.getCart();
        Product product = productService.getProductById(productId);
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem cartItem : cartItems) {
            if (product.getProductId() == cartItem.getProduct().getProductId()) {
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                cartItem.setTotalPrice(product.getProductPrice() * cartItem.getQuantity());
                cartItemService.addCartItem(cartItem);
                return;
            }
        }

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(1);
        cartItem.setTotalPrice(product.getProductPrice());
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);
    }

    @PutMapping("/remove/{productId}")
    public void removeItem(@PathVariable int productId) {
        CartItem cartItem = cartItemService.getCartItemByProductId(productId);
        cartItemService.removeCartItem(cartItem);
    }

    @DeleteMapping("/{cartId}")
    public void clearCart(@PathVariable int cartId) {
        Cart cart = cartService.getCartById(cartId);
        cartService.removeAllCartItems(cart);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Please, verify your request")
    public void handleClientErrors(Exception e){}

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
    public void handleServerErrors(Exception e){}


}

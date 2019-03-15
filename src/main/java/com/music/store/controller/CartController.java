package com.music.store.controller;

import com.music.store.converters.CartViewModelToCartModel;
import com.music.store.dao.CartDao;
import com.music.store.dao.ProductDao;
import com.music.store.entity.Cart;
import com.music.store.entity.CartItem;
import com.music.store.entity.Product;
import com.music.store.viewModels.CartViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Dmitrii on 15.03.2019.
 */
@RestController
@RequestMapping("/rest/cart")
public class CartController {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CartViewModelToCartModel cartViewModelToCartModel;

    @GetMapping("/{cartId}")
    public CartViewModel get(@PathVariable String cartId){
        Cart cart = cartDao.get(cartId);
        return cartViewModelToCartModel.convert(cart);
    }

    @PutMapping("/{cartId}")
    public void update(@PathVariable String cartId, @RequestBody CartViewModel cartViewModel) {
        Cart cart = cartViewModelToCartModel.convert(cartViewModel);
        cartDao.update(cartId, cart);
    }

    @DeleteMapping("/{cartId}")
    public void delete(@PathVariable String cartId) {
        cartDao.delete(cartId);
    }

    @PutMapping("/add/{productId}")
    public void addItem(@PathVariable Integer productId, HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        Cart cart = cartDao.get(sessionId);
        if(cart == null) {
            cart = cartDao.add(new Cart());
        }
        Product product = productDao.getProductById(productId);
        if(product == null){
            throw new IllegalArgumentException("Not found product with id = " + productId);
        }
        cart.addCartItem(new CartItem());
        cartDao.update(sessionId, cart);
    }

    @PutMapping("/remove/{productId}")
    public void removeItem(@PathVariable Integer productId, HttpServletRequest request){
        String sessionId = request.getSession().getId();
        Cart cart = cartDao.get(sessionId);
        if(cart == null) {
            cart = cartDao.add(new Cart());
        }
        Product product = productDao.getProductById(productId);
        if(product == null){
            throw new IllegalArgumentException("Not found product with id = " + productId);
        }
        cart.removeCartItem(new CartItem());
        cartDao.update(sessionId, cart);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Please, verify your request")
    public void handleClientErrors(Exception e){}

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
    public void handleServerErrors(Exception e){}
}

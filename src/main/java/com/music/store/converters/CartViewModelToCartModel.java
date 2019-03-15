package com.music.store.converters;

import com.music.store.entity.Cart;
import com.music.store.viewModels.CartViewModel;

/**
 * Created by Dmitrii on 15.03.2019.
 */
public interface CartViewModelToCartModel {
    Cart convert(CartViewModel cartViewModel);
    CartViewModel convert(Cart cart);
}

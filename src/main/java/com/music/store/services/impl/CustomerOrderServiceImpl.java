package com.music.store.services.impl;

import com.music.store.dao.CustomerOrderDao;
import com.music.store.entity.Cart;
import com.music.store.entity.CartItem;
import com.music.store.entity.CustomerOrder;
import com.music.store.services.CartService;
import com.music.store.services.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Dmitrii on 23.03.2019.
 */

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private CustomerOrderDao customerOrderDao;

    @Autowired
    private CartService cartService;

    @Override
    public void addCustomerOrder(CustomerOrder customerOrder) {
        customerOrderDao.addCustomerDao(customerOrder);
    }

}

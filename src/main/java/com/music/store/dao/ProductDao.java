package com.music.store.dao;

import com.music.store.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitrii on 09.03.2019.
 */
public class ProductDao {

    private List<Product> productList;

    public List<Product> getProductList() {
        productList = new ArrayList<>();

        Product product1 = new Product();
        product1.setProductName("Guitar");
        product1.setProductCategory("Instrument");
        product1.setProductDescription("This is a fender strat guitar");
        product1.setProductPrice(1200);
        product1.setProductCondition("new");
        product1.setProductStatus("Active");
        product1.setUnitInStock(11);
        product1.setProductManufacturer("Fender");
        
        Product product2 = new Product();
        product2.setProductName("Record");
        product2.setProductCategory("Record");
        product2.setProductDescription("This is an awesome mix of 20th century!");
        product2.setProductPrice(25);
        product2.setProductCondition("new");
        product2.setProductStatus("Active");
        product2.setUnitInStock(51);
        product2.setProductManufacturer("EMI");      
        
        Product product3 = new Product();
        product3.setProductName("Speaker");
        product3.setProductCategory("Accessory");
        product3.setProductDescription("This is a Polk Shelf Speaker.");
        product3.setProductPrice(355);
        product3.setProductCondition("new");
        product3.setProductStatus("Active");
        product3.setUnitInStock(9);
        product3.setProductManufacturer("Polk");

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);

        return productList;
    }
}

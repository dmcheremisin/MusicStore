package com.music.store.dao;

import com.music.store.model.Product;

import java.util.List;

public interface ProductDao {
    void addProduct(Product product);

    Product getProductById(int id);

    List<Product> getAllProducts();

    void deleteProduct(int id);
}

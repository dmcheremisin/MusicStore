package com.music.store.dao;

import com.music.store.entity.Product;

import java.util.List;

public interface ProductDao {
    Product addEditProduct(Product product);

    Product getProductById(int id);

    List<Product> getAllProducts();

    void deleteProduct(int id);
}

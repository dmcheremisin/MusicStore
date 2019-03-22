package com.music.store.services;

import com.music.store.entity.Product;
import com.music.store.viewModels.ProductViewModel;

import java.util.List;

public interface ProductService {

    List<Product> getProductList();

    Product getProductById(int id);

    Product addEditProduct(Product productViewModel);

    void deleteProduct(int id);
}

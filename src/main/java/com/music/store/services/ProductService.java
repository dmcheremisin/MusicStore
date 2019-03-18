package com.music.store.services;

import com.music.store.entity.Product;
import com.music.store.viewModels.ProductViewModel;

import java.util.List;

public interface ProductService {

    List<ProductViewModel> getProductList();

    ProductViewModel getProductById(int id);

    void addEditProduct(ProductViewModel productViewModel);

    void deleteProduct(int id);
}

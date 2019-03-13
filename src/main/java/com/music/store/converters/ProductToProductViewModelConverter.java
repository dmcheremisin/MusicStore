package com.music.store.converters;

import com.music.store.entity.Product;
import com.music.store.viewModels.ProductViewModel;

import java.util.List;

public interface ProductToProductViewModelConverter {
    Product convert(ProductViewModel productViewModel);
    ProductViewModel convert(Product product);
    List<Product> convertProductViewModels(List<ProductViewModel> viewModels);
    List<ProductViewModel> convertProducts(List<Product> products);
}

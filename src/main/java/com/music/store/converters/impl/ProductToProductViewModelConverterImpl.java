package com.music.store.converters.impl;

import com.music.store.converters.ProductToProductViewModelConverter;
import com.music.store.entity.Product;
import com.music.store.viewModels.ProductViewModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductToProductViewModelConverterImpl implements ProductToProductViewModelConverter {

    public Product convert(ProductViewModel productViewModel) {
        Product product = new Product();
        product.setProductId(productViewModel.getProductId());
        product.setProductName(productViewModel.getProductName());
        product.setProductCategory(productViewModel.getProductCategory());
        product.setProductDescription(productViewModel.getProductDescription());
        product.setProductPrice(productViewModel.getProductPrice());
        product.setProductCondition(productViewModel.getProductCondition());
        product.setProductStatus(productViewModel.getProductStatus());
        product.setUnitInStock(productViewModel.getUnitInStock());
        product.setProductManufacturer(productViewModel.getProductManufacturer());

        return product;
    }

    public ProductViewModel convert(Product product) {
        ProductViewModel productViewModel = new ProductViewModel();
        productViewModel.setProductId(product.getProductId());
        productViewModel.setProductName(product.getProductName());
        productViewModel.setProductCategory(product.getProductCategory());
        productViewModel.setProductDescription(product.getProductDescription());
        productViewModel.setProductPrice(product.getProductPrice());
        productViewModel.setProductCondition(product.getProductCondition());
        productViewModel.setProductStatus(product.getProductStatus());
        productViewModel.setUnitInStock(product.getUnitInStock());
        productViewModel.setProductManufacturer(product.getProductManufacturer());

        return productViewModel;
    }

    public List<Product> convertProductViewModels(List<ProductViewModel> viewModels) {
        List<Product> products = new ArrayList<>();
        if (viewModels != null && !viewModels.isEmpty()) {
            viewModels.forEach(vM -> products.add(convert(vM)));
        }
        return products;
    }

    public List<ProductViewModel> convertProducts(List<Product> products) {
        List<ProductViewModel> productViewModels = new ArrayList<>();
        if (products != null && !products.isEmpty()) {
            products.forEach(p -> productViewModels.add(convert(p)));
        }
        return productViewModels;
    }

}

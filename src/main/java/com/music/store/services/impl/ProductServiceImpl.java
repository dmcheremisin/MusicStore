package com.music.store.services.impl;

import com.music.store.converters.ProductToProductViewModelConverter;
import com.music.store.dao.ProductDao;
import com.music.store.entity.Product;
import com.music.store.services.ProductService;
import com.music.store.viewModels.ProductViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductToProductViewModelConverter productToProductViewModelConverter;

    @Override
    public List<ProductViewModel> getProductList() {
        List<Product> allProducts = productDao.getAllProducts();
        List<ProductViewModel> productViewModels = productToProductViewModelConverter.convertProducts(allProducts);
        return productViewModels;
    }

    @Override
    public ProductViewModel getProductById(int id) {
        Product product = productDao.getProductById(id);
        ProductViewModel productViewModel = productToProductViewModelConverter.convert(product);
        return productViewModel;
    }

    @Override
    public void addEditProduct(ProductViewModel productViewModel) {
        Product product = productToProductViewModelConverter.convert(productViewModel);
        productDao.addEditProduct(product);
    }

    @Override
    public void deleteProduct(int id) {
        productDao.deleteProduct(id);
    }

}

package com.music.store.controller;

import com.music.store.converters.ProductToProductViewModelConverter;
import com.music.store.dao.ProductDao;
import com.music.store.model.Product;
import com.music.store.viewModels.ProductViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/productList")
public class ProductController {


    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductToProductViewModelConverter productToProductViewModelConverter;

    @RequestMapping()
    public String getProducts(Model model) {
        List<Product> productList = productDao.getAllProducts();
        List<ProductViewModel> productViewModels = productToProductViewModelConverter.convertProducts(productList);
        model.addAttribute("products", productViewModels);

        return "productList";
    }

    @RequestMapping("/viewProduct/{id}")
    public String viewProduct(@PathVariable int id, Model model) {
        Product product = productDao.getProductById(id);
        ProductViewModel productViewModel = productToProductViewModelConverter.convert(product);
        model.addAttribute("product", productViewModel);
        return "viewProduct";
    }
}

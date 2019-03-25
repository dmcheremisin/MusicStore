package com.music.store.controller;

import com.music.store.converters.ProductToProductViewModelConverter;
import com.music.store.entity.Product;
import com.music.store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductToProductViewModelConverter productToProductViewModelConverter;

    @Autowired
    private ProductService productService;

    @RequestMapping("productList")
    public String getProducts(Model model) {
        List<Product> productViewModels = productService.getProductList();
        model.addAttribute("products", productViewModels);
        return "productList";
    }

    @RequestMapping("/viewProduct/{id}")
    public String viewProduct(@PathVariable int id, Model model) {
        Product productViewModel  = productService.getProductById(id);
        model.addAttribute("product", productViewModel);
        return "viewProduct";
    }
}

package com.music.store.controller;

import com.music.store.converters.ProductToProductViewModelConverter;
import com.music.store.dao.ProductDao;
import com.music.store.entity.Product;
import com.music.store.services.ProductService;
import com.music.store.viewModels.ProductViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductToProductViewModelConverter productToProductViewModelConverter;

    @Autowired
    private ProductService productService;

    @RequestMapping("productList")
    public String getProducts(@RequestParam(value = "searchCondition", required = false) String searchCondition, Model model) {
        List<Product> productViewModels = productService.getProductList();
        model.addAttribute("products", productViewModels);
        if(!StringUtils.isEmpty(searchCondition)) {
            model.addAttribute("searchCondition", searchCondition);
        }

        return "productList";
    }

    @RequestMapping("/viewProduct/{id}")
    public String viewProduct(@PathVariable int id, Model model) {
        Product productViewModel  = productService.getProductById(id);
        model.addAttribute("product", productViewModel);
        return "viewProduct";
    }
}

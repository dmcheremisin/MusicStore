package com.music.store.controller;

import com.music.store.dao.ProductDao;
import com.music.store.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Dmitrii on 09.03.2019.
 */
@Controller
public class HomeController {

    private ProductDao productDao = new ProductDao();

    @RequestMapping("/")
    public String getHomePage() {
        return "index";
    }


    @RequestMapping("/productList")
    public String getProducts(Model model) {
        List<Product> productList = productDao.getProductList();
        model.addAttribute("products", productList);

        return "productList";
    }

    @RequestMapping("/productList/viewProduct/{id}")
    public String viewProduct(@PathVariable int id, Model model) {
        Product product = productDao.getProductById(id);
        model.addAttribute("product", product);
        return "viewProduct";
    }
}

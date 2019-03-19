package com.music.store.controller;

import com.music.store.services.ProductService;
import com.music.store.viewModels.ProductViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductService productService;

    @RequestMapping
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/productInventory")
    public String productInventory(Model model) {
        List<ProductViewModel> productList = productService.getProductList();
        model.addAttribute("products", productList);
        return "productInventory";
    }

    @RequestMapping("/customer")
    public String customerManagement(Model model) {

        return "customerManagement";
    }

}

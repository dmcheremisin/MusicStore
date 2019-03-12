package com.music.store.controller;

import com.music.store.dao.ProductDao;
import com.music.store.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Dmitrii on 09.03.2019.
 */
@Controller
public class HomeController {

    @Autowired
    private ProductDao productDao;

    @RequestMapping("/")
    public String getHomePage() {
        return "index";
    }


    @RequestMapping("/productList")
    public String getProducts(Model model) {
        List<Product> productList = productDao.getAllProducts();
        model.addAttribute("products", productList);

        return "productList";
    }

    @RequestMapping("/productList/viewProduct/{id}")
    public String viewProduct(@PathVariable int id, Model model) {
        Product product = productDao.getProductById(id);
        model.addAttribute("product", product);
        return "viewProduct";
    }

    @RequestMapping("/productList/add")
    public String addStubProduct(Model model) {
        Product product = new Product();
        product.setProductName("new tool");
        product.setProductCategory("accessorizes");
        productDao.addProduct(product);
        return getProducts(model);
    }

    @RequestMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/admin/productInventory")
    public String productInventory(Model model) {
        List<Product> allProducts = productDao.getAllProducts();
        model.addAttribute("products", allProducts);
        return "productInventory";
    }

    @RequestMapping("admin/productInventory/addProduct")
    public String addProductForm(Model model){
        Product product = new Product();
        product.setProductCategory("instrument");
        product.setProductCondition("new");
        product.setProductStatus("active");

        model.addAttribute("product", product);

        return "addProduct";
    }

    @RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product){
        productDao.addProduct(product);
        return "redirect:/admin/productInventory";
    }
}

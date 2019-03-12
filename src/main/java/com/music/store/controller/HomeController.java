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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Dmitrii on 09.03.2019.
 */
@Controller
public class HomeController {

    private Path path;

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
    public String addProduct(@ModelAttribute("product") Product product, HttpServletRequest request){
        productDao.addProduct(product);

        MultipartFile productImage = product.getProductImage();
        String realPath = request.getSession().getServletContext().getRealPath("/");
        Path path = Paths.get(realPath + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".png");

        if(productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving fail", e);
            }
        }

        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/admin/productInventory/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id, Model model, HttpServletRequest request) {
        String realPath = request.getSession().getServletContext().getRealPath("/");
        Path path = Paths.get(realPath + "\\WEB-INF\\resources\\images\\" + id + ".png");

        if(Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        productDao.deleteProduct(id);

        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/admin/productInventory/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        Product product = productDao.getProductById(id);
        model.addAttribute(product);
        return "editProduct";
    }

    @RequestMapping(value = "/admin/productInventory/edit", method = RequestMethod.POST)
    public String editProduct(@ModelAttribute("product") Product product, Model model, HttpServletRequest request) {
        MultipartFile image = product.getProductImage();
        String realPath = request.getSession().getServletContext().getRealPath("/");
        Path path = Paths.get(realPath + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".png");

        if(image != null && !image.isEmpty()) {
            try {
                image.transferTo(new File(path.toString()));
            } catch (Exception e) {
                throw new RuntimeException("Product image update failed", e);
            }
        }

        productDao.addProduct(product);

        return "redirect:/admin/productInventory";
    }

}

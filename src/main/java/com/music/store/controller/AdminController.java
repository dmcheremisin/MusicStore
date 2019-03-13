package com.music.store.controller;

import com.music.store.converters.ProductToProductViewModelConverter;
import com.music.store.dao.ProductDao;
import com.music.store.entity.Product;
import com.music.store.viewModels.ProductViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductToProductViewModelConverter productToProductViewModelConverter;


    @RequestMapping()
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/productInventory")
    public String productInventory(Model model) {
        List<Product> allProducts = productDao.getAllProducts();
        List<ProductViewModel> productViewModels = productToProductViewModelConverter.convertProducts(allProducts);
        model.addAttribute("products", productViewModels);
        return "productInventory";
    }

    @RequestMapping("/productInventory/addProduct")
    public String addProductForm(Model model){
        ProductViewModel productViewModel = new ProductViewModel();
        productViewModel.setProductCategory("instrument");
        productViewModel.setProductCondition("new");
        productViewModel.setProductStatus("active");

        model.addAttribute("product", productViewModel);

        return "addProduct";
    }

    @RequestMapping(value = "/productInventory/addProduct", method = RequestMethod.POST)
    public String addProduct(@Valid @ModelAttribute("product") ProductViewModel productViewModel,
                             BindingResult bindingResult,
                             HttpServletRequest request){
        if(bindingResult.hasErrors()){
            return "addProduct";
        }

        Product product = productToProductViewModelConverter.convert(productViewModel);
        productDao.addProduct(product);

        MultipartFile productImage = productViewModel.getProductImage();
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

    @RequestMapping("/productInventory/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id, HttpServletRequest request) {
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

    @RequestMapping("/productInventory/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        Product product = productDao.getProductById(id);
        ProductViewModel productViewModel = productToProductViewModelConverter.convert(product);
        model.addAttribute("product", productViewModel);

        return "editProduct";
    }

    @RequestMapping(value = "/productInventory/edit", method = RequestMethod.POST)
    public String editProduct(@Valid @ModelAttribute("product") ProductViewModel productViewModel,
                              BindingResult bindingResult,
                              HttpServletRequest request) {
        if(bindingResult.hasErrors()){
            return "addProduct";
        }
        MultipartFile image = productViewModel.getProductImage();
        String realPath = request.getSession().getServletContext().getRealPath("/");
        Path path = Paths.get(realPath + "\\WEB-INF\\resources\\images\\" + productViewModel.getProductId() + ".png");

        if(image != null && !image.isEmpty()) {
            try {
                image.transferTo(new File(path.toString()));
            } catch (Exception e) {
                throw new RuntimeException("Product image update failed", e);
            }
        }

        Product product = productToProductViewModelConverter.convert(productViewModel);
        productDao.addProduct(product);

        return "redirect:/admin/productInventory";
    }

}
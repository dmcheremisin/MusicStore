package com.music.store.controller;

import com.music.store.converters.ProductToProductViewModelConverter;
import com.music.store.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.file.Path;

/**
 * Created by Dmitrii on 09.03.2019.
 */
@Controller
public class HomeController {

    private Path path;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductToProductViewModelConverter productToProductViewModelConverter;

    @RequestMapping("/")
    public String getHomePage() {
        return "index";
    }



}

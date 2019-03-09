package com.music.store;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Dmitrii on 09.03.2019.
 */
@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String getHomePage() {
        return "index";
    }
}

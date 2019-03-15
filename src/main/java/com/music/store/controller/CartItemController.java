package com.music.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Dmitrii on 15.03.2019.
 */
@Controller
@RequestMapping("/cart")
public class CartItemController {

    @RequestMapping
    public String get(HttpServletRequest request) {
        return "redirect:/cart/" + request.getSession(true).getId();
    }

    @RequestMapping(value = "/{cartId}")
    public String getCart(@PathVariable String cartId, Model model) {
        model.addAttribute("cartId", cartId);
        return "cart";
    }
}

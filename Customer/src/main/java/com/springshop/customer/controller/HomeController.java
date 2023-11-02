package com.springshop.customer.controller;

import com.springshop.library.dto.ProductDto;
import com.springshop.library.model.Category;
import com.springshop.library.service.CategoryService;
import com.springshop.library.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class HomeController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;
    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("title", "Home");
        model.addAttribute("page", "Home");
        return "home";
    }
    @GetMapping("/home")
    public String index(Model model){
        List<Category> categories = categoryService.findAll();
        List<ProductDto> productDtos = productService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("products", productDtos);
        return "index";
    }
}

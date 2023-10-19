package com.springshop.admin.controller;


import com.springshop.library.dto.ProductDto;
import com.springshop.library.model.Category;
import com.springshop.library.service.CategoryService;
import com.springshop.library.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class ProductController {


    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;
    @GetMapping("/products")
    public String products(Model model, Principal principal){
        if (principal == null){
            return  "redirect:/login";
        }
        List<ProductDto> productDtoList = productService.findAll();
        model.addAttribute("title", "Manage Product");
        model.addAttribute("products", productDtoList);
        model.addAttribute("size", productDtoList.size());
        return "products";
    }

    @GetMapping("/add-product")
    public  String addProductForm(Model model){
        List<Category> categories = categoryService.findAllByActivated();
        model.addAttribute("categories", categories);
        model.addAttribute("product", new ProductDto());

        return "add-product";
    }
}

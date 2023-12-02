package com.springshop.customer.controller;


import com.springshop.library.dto.CustomerDto;
import com.springshop.library.model.City;
import com.springshop.library.model.Country;
import com.springshop.library.service.CityService;
import com.springshop.library.service.CountryService;
import com.springshop.library.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final CountryService countryService;
    private final PasswordEncoder passwordEncoder;
    private final CityService cityService;

    @GetMapping("/profile")
    public String profile(Model model, Principal principal) {
        if(principal == null) {
            return "redirect:/login";
        }
        String username = principal.getName();
        CustomerDto  customer = customerService.getCustomer(username);
        List<Country> countryList = countryService.findAll();
        List<City> cities = cityService.findAll();
        model.addAttribute("customer", customer);
        model.addAttribute("cities", cities);
        model.addAttribute("countries", countryList);
        model.addAttribute("title", "Profile");
        model.addAttribute("page", "Profile");
        return "customer-information";

    }
}

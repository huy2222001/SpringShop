package com.springshop.library.service;

import com.springshop.library.dto.ProductDto;
import com.springshop.library.dto.ShoppingCartDto;
import com.springshop.library.model.ShoppingCart;

public interface ShoppingCartService {
    ShoppingCart addItemToCart(ProductDto productDto, int quantity, String username);

    ShoppingCart updateCart(ProductDto productDto, int quantity, String username);

    ShoppingCart removeItemFromCart(ProductDto productDto, String username);
    void deleteCartById(Long id);
    ShoppingCartDto addItemToCartSession(ShoppingCartDto cartDto, ProductDto productDto, int quantity);
}

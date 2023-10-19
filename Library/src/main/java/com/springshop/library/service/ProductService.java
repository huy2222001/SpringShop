package com.springshop.library.service;

import com.springshop.library.dto.ProductDto;
import com.springshop.library.model.Product;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAll();
    Product save(ProductDto productDto);
    Product update(ProductDto productDto);
    void deleteById(Long id);

    void enableById(Long id);

}

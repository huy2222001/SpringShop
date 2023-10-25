package com.springshop.library.service;

import com.springshop.library.dto.ProductDto;
import com.springshop.library.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    List<ProductDto> findAll();
    Product save(MultipartFile imageProduct, ProductDto product);
    Product update(MultipartFile imageProduct, ProductDto productDto);
    void deleteById(Long id);

    void enableById(Long id);
    ProductDto getById(Long id);
    Page<ProductDto> getAllProducts(int pageNo);
    List<ProductDto> allProduct();

}

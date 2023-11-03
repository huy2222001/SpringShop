package com.springshop.library.service;

import com.springshop.library.dto.ProductDto;
import com.springshop.library.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    List<ProductDto> findAll();//check
    Product save(MultipartFile imageProduct, ProductDto product);//check
    Product update(MultipartFile imageProduct, ProductDto productDto);//check
    void deleteById(Long id);//check

    void enableById(Long id);//check
    ProductDto getById(Long id);//check
    Page<ProductDto> getAllProducts(int pageNo);
    List<ProductDto> allProduct();//check
    Page<ProductDto> searchProducts(int pageNo, String keyword);

    List<ProductDto> products();//check


//    Customer
    List<Product> getAllProducts();
    List<ProductDto> randomProduct();
    List<ProductDto> listViewProducts();
    List<ProductDto> findAllByCategory(String category);
}

package com.springshop.library.service;

import com.springshop.library.dto.CategoryDto;
import com.springshop.library.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();
    Category save(Category category);
    Optional<Category> findById(Long id);
    Category update(Category category);
    void deleteById(Long id);
    void enableById(Long id);

    List<Category> findAllByActivated();
    List<CategoryDto> getCategoriesAndSize();
}

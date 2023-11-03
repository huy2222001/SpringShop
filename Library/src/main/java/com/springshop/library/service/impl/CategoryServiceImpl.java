package com.springshop.library.service.impl;

import com.springshop.library.dto.CategoryDto;
import com.springshop.library.model.Category;
import com.springshop.library.repository.CategoryRepository;
import com.springshop.library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private CategoryRepository repo;


    @Override
    public List<Category> findAll() {
        return repo.findAll();
    }

    @Override
    public Category save(Category category) {
        try {
            Category categorySave = new Category(category.getName());
            return repo.save(categorySave);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Optional<Category> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Category update(Category category) {
        Category categoryUpdate = repo.getReferenceById(category.getId());
        categoryUpdate.setName(category.getName());
        return repo.save(categoryUpdate);
    }

    @Override
    public void deleteById(Long id) {
        Category category = repo.getById(id);
        category.set_deleted(true);
        category.set_activated(false);
        repo.save(category);
    }

    @Override
    public void enableById(Long id) {
        Category category = repo.getById(id);
        category.set_deleted(false);
        category.set_activated(true);
        repo.save(category);
    }

    @Override
    public List<Category> findAllByActivated() {

        return repo.findAllByActivated();
    }

    @Override
    public List<CategoryDto> getCategoriesAndSize() {
        List<CategoryDto> categories = repo.getCategoriesAndSize();
        return categories;
    }
}

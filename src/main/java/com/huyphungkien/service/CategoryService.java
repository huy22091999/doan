package com.huyphungkien.service;

import com.huyphungkien.entity.Category;
import com.huyphungkien.model.CategoryDto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    CategoryDto save(CategoryDto dto);

    void deleteById(Long aLong);

    @Query("select new com.huyphungkien.model.CategoryDto(c) from Category c")
    List<CategoryDto> getAll();
}

package com.huyphungkien.repository;

import com.huyphungkien.entity.Category;
import com.huyphungkien.model.CategoryDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("select new com.huyphungkien.model.CategoryDto(c) from Category c")
    public List<CategoryDto> getAll();
}

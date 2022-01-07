package com.huyphungkien.service.Impl;

import com.huyphungkien.entity.Category;
import com.huyphungkien.model.CategoryDto;
import com.huyphungkien.repository.CartItemRepository;
import com.huyphungkien.repository.CategoryRepository;
import com.huyphungkien.service.CartService;
import com.huyphungkien.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository cr;

    @Override
    public List<Category> findAll() {
        return cr.findAll();
    }

    @Override
    public CategoryDto save(CategoryDto dto) {
        if(dto==null){
            return null;
        }
        Category category=null;
        if(dto.getId()!=null){
            category=cr.getOne(dto.getId());
        }
        if(category==null){
            category=new Category();
        }
        category.setName(dto.getName());
        category=cr.save(category);
        if(category!=null)
            return new CategoryDto(category);
        return null;
    }

    @Override
    public void deleteById(Long aLong) {
        cr.deleteById(aLong);
    }

    @Override
    @Query("select new com.huyphungkien.model.CategoryDto(c) from Category c")
    public List<CategoryDto> getAll() {
        return cr.getAll();
    }
}

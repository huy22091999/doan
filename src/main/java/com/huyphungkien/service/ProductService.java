package com.huyphungkien.service;

import com.huyphungkien.entity.Product;
import com.huyphungkien.model.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface ProductService {
    @Query("select new.huyphungkien.model.ProductDto(p) from Product p")
    Page<ProductDto> getPage(Pageable pageable);

    Product getById(Long aLong);

    ProductDto save(ProductDto dto);

    void deleteById(Long aLong);
}

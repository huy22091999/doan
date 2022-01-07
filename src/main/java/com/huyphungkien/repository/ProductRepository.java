package com.huyphungkien.repository;

import com.huyphungkien.entity.Product;
import com.huyphungkien.model.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
//    @Query("select new com.huyphungkien.model.ProductDto(p) from Product p ")
//    public Page<ProductDto> findAllPro(Pageable page);
    @Query("select new com.huyphungkien.model.ProductDto(p) from Product p")
    public Page<ProductDto> countk(Pageable page);

}

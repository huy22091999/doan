package com.huyphungkien.repository;

import com.huyphungkien.entity.CartItem;
import com.huyphungkien.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}

package com.huyphungkien.repository;

import com.huyphungkien.entity.Category;
import com.huyphungkien.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

}

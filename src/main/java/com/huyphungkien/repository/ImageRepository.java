package com.huyphungkien.repository;

import com.huyphungkien.entity.CartItem;
import com.huyphungkien.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

}

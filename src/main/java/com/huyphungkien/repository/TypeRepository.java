package com.huyphungkien.repository;

import com.huyphungkien.entity.TypePro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<TypePro, Long> {

}

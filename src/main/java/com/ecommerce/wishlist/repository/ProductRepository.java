package com.ecommerce.wishlist.repository;

import com.ecommerce.wishlist.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Products, Long> {

    @Query("SELECT p FROM Products p WHERE p.id = ?1")
    Products getById(Long id);
}

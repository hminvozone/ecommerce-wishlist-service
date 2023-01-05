package com.ecommerce.wishlist.repository;

import com.ecommerce.wishlist.entity.WishListProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WishListProductsRepository extends JpaRepository<WishListProducts, Long> {

    @Query("SELECT wp FROM WishListProducts wp JOIN FETCH wp.products p WHERE wp.wishList.id = ?1")
    List<WishListProducts> getAllBy(Long id);
}

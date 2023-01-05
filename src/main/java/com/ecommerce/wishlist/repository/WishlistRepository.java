package com.ecommerce.wishlist.repository;

import com.ecommerce.wishlist.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WishlistRepository extends JpaRepository<WishList, Long> {

    @Query("SELECT w FROM WishList w WHERE w.id = ?1")
    WishList getById(Long id);

    @Query("SELECT w FROM WishList w JOIN FETCH w.user u WHERE w.user.id = ?1")
    WishList getByUserId(Long id);
}

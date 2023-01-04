package com.ecommerce.wishlist.service;

import com.ecommerce.wishlist.entity.WishList;

public interface IWishlistService {
    WishList getWishList(Long id);

    void createWishlist(Long id);
}

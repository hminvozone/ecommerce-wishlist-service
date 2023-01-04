package com.ecommerce.wishlist.service;

import com.ecommerce.wishlist.entity.WishList;
import com.ecommerce.wishlist.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WishlistService implements IWishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    @Override
    public WishList getWishList(Long id) {
        WishList wishlist = wishlistRepository.getById(id);
        return wishlist;
    }

    @Override
    public void createWishlist(Long id) {
        WishList wishlist = new WishList();
        wishlist.setUser_id(id);
        wishlist.setCreated_at(new Date());
        wishlist.setUpdated_at(new Date());
        wishlistRepository.save(wishlist);
    }
}

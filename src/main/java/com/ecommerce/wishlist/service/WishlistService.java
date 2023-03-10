package com.ecommerce.wishlist.service;

import com.ecommerce.wishlist.entity.User;
import com.ecommerce.wishlist.entity.WishList;
import com.ecommerce.wishlist.repository.UserRepository;
import com.ecommerce.wishlist.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WishlistService implements IWishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public WishList getWishList(Long id) {
        WishList wishlist = wishlistRepository.getByUserId(id);
        return wishlist;
    }

    @Override
    public void createWishlist(Long id) throws Exception {
        WishList wishlist = new WishList();
        try {
            User user = userRepository.getById(id);
            wishlist.setUser(user);
            wishlist.setCreated_at(new Date());
            wishlist.setUpdated_at(new Date());
            wishlistRepository.save(wishlist);
        }catch (Exception e){
            throw new Exception(e);
        }
    }
}

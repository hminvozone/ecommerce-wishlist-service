package com.ecommerce.wishlist.service;

import com.ecommerce.wishlist.dto.GetWishListProductsResponse;

public interface IWishListProductsService {

    GetWishListProductsResponse getWishListProducts(Long id);

    void addProduct(Long wishlist_id, Long product_id) throws Exception;

    void removeProduct(Long wishlist_id, Long product_id) throws Exception;

}

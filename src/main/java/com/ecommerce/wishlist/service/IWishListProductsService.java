package com.ecommerce.wishlist.service;

import com.ecommerce.wishlist.dto.GetWishListProductsResponse;

public interface IWishListProductsService {

    GetWishListProductsResponse getWishListProducts(Long id);

}

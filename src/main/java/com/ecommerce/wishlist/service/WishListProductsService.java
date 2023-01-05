package com.ecommerce.wishlist.service;

import com.ecommerce.wishlist.dto.GetWishListProductsResponse;
import com.ecommerce.wishlist.dto.Product;
import com.ecommerce.wishlist.entity.WishListProducts;
import com.ecommerce.wishlist.repository.WishListProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListProductsService implements IWishListProductsService{

    @Autowired
    private WishListProductsRepository wishListProductsRepository;

    @Override
    public GetWishListProductsResponse getWishListProducts(Long id) {
        GetWishListProductsResponse getWishListProductsResponse = new GetWishListProductsResponse();
        List<WishListProducts> wishListProducts = wishListProductsRepository.getAllBy(id);
        wishListProducts.forEach(wishListProduct -> {
            getWishListProductsResponse.getProducts().add(Product.factoryProduct(wishListProduct.getProducts()));
        });
        return getWishListProductsResponse;
    }
}

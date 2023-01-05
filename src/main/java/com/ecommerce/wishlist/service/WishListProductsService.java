package com.ecommerce.wishlist.service;

import com.ecommerce.wishlist.dto.GetWishListProductsResponse;
import com.ecommerce.wishlist.dto.Product;
import com.ecommerce.wishlist.entity.Products;
import com.ecommerce.wishlist.entity.WishList;
import com.ecommerce.wishlist.entity.WishListProducts;
import com.ecommerce.wishlist.repository.ProductRepository;
import com.ecommerce.wishlist.repository.WishListProductsRepository;
import com.ecommerce.wishlist.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishListProductsService implements IWishListProductsService{

    @Autowired
    private WishListProductsRepository wishListProductsRepository;

    @Autowired
    private WishlistRepository wishlistRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public GetWishListProductsResponse getWishListProducts(Long id) {
        GetWishListProductsResponse getWishListProductsResponse = new GetWishListProductsResponse();
        List<WishListProducts> wishListProducts = wishListProductsRepository.getAllBy(id);
        wishListProducts.forEach(wishListProduct -> {
            getWishListProductsResponse.getProducts().add(Product.factoryProduct(wishListProduct.getProducts()));
        });
        return getWishListProductsResponse;
    }

    @Override
    public void addProduct(Long wishlist_id, Long product_id) throws Exception {
        WishListProducts wishListProducts = new WishListProducts();
        try {
            Products products = productRepository.getById(product_id);
            WishList wishList = wishlistRepository.getById(wishlist_id);

            wishListProducts.setWishList(wishList);
            wishListProducts.setProducts(products);

            wishListProductsRepository.save(wishListProducts);
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    @Override
    public void removeProduct(Long wishlist_id, Long product_id) throws Exception {
        List<WishListProducts> wishListProducts = new ArrayList<>();
        try {
            wishListProducts = wishListProductsRepository.getAllBy(wishlist_id);
            wishListProducts.forEach(wishListProduct -> {
                if ((wishListProduct.getProducts().getId()).equals(product_id)){
                    wishListProductsRepository.delete(wishListProduct);
                }
            });
        }catch (Exception e){
            throw new Exception(e);
        }
    }
}

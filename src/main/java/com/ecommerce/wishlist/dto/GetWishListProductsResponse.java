package com.ecommerce.wishlist.dto;

import com.ecommerce.wishlist.entity.WishList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@Data
public class GetWishListProductsResponse {

    @JsonProperty(value = "products")
    private List<Product> products = new ArrayList<>();

    public GetWishListProductsResponse() {
    }

    public GetWishListProductsResponse(List<Product> products) {
        this.products = products;
    }
}

package com.ecommerce.wishlist.dto;

import com.ecommerce.wishlist.entity.Categories;
import com.ecommerce.wishlist.entity.Products;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@Data
public class Product {
    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "product_name")
    @NotNull
    private String product_name;

    @JsonProperty(value = "thumbnail")
    private String thumbnail;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "price")
    private Integer price;

    @JsonProperty(value = "discount_price")
    private Integer discount_price;

    @JsonProperty(value = "categories")
    private Categories categories;

    public Product() {
    }

    public Product(Long id, String product_name, String thumbnail, String description, Integer price, Integer discount_price, Categories categories) {
        this.id = id;
        this.product_name = product_name;
        this.thumbnail = thumbnail;
        this.description = description;
        this.price = price;
        this.discount_price = discount_price;
        this.categories = categories;
    }

    public static Product factoryProduct(Products products) {
        return Product.builder()
                .id(products.getId())
                .product_name(products.getProduct_name())
                .description(products.getDescription())
                .thumbnail(products.getThumbnail())
                .price(products.getPrice())
                .discount_price(products.getDiscount_price())
                .categories(products.getCategories())
                .build();
    }
}

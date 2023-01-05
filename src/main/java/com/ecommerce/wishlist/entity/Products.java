package com.ecommerce.wishlist.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "products")
@Entity
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Accessors(chain = true)
@Builder(toBuilder = true)
@Setter()
@Getter()
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private Long id;

    @Column(name = "product_name", nullable = false)
    @NotNull
    private String product_name;

    @Column(name = "thumbnail", nullable = true)
    private String thumbnail;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "price", nullable = true)
    private Integer price;

    @Column(name = "discount_price", nullable = true)
    private Integer discount_price;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    @NotNull
    private Categories categories;
}

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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "categories")
@Entity
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Accessors(chain = true)
@Builder(toBuilder = true)
@Setter()
@Getter()
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private Long id;

    @Column(name = "category_name", nullable = false)
    @NotNull
    private String category_name;

    @Column(name = "thumbnail", nullable = true)
    private String thumbnail;
}

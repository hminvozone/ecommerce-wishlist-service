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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Table(name = "wishlist")
@Entity
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Accessors(chain = true)
@Builder(toBuilder = true)
@Setter()
@Getter()
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @NotNull
    private User user;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = true)
    private Date created_at;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = true)
    private Date updated_at;
}

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Table(name = "users")
@Entity
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Accessors(chain = true)
@Builder(toBuilder = true)
@Setter()
@Getter()
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private Long id;

    @Column(name = "email", nullable = false)
    @NotNull
    private String email;

    @Column(name = "password", nullable = false)
    @NotNull
    private String password;

    @Column(name = "name", nullable = false)
    @NotNull
    private String name;

    @Column(name = "phone", nullable = false)
    @NotNull
    private String phone;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = true)
    private Date created_at;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = true)
    private Date updated_at;
}

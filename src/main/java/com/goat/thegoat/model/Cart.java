package com.goat.thegoat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_id", nullable = false)
    private Long cartId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User userData;

    @ElementCollection
    @CollectionTable(name = "cart_product", joinColumns = @JoinColumn(name = "cart_id"))
    private List<Long> product;

    @ElementCollection
    @CollectionTable(name = "cart_product_quantities", joinColumns = @JoinColumn(name = "cart_id"))
    private List<Long> productQuantity;

    public Cart() {
    }

    public Cart(Long cartId, User userData, List<Long> product, List<Long> productQuantity) {
        this.cartId = cartId;
        this.userData = userData;
        this.product = product;
        this.productQuantity = productQuantity;
    }

    public Cart(User userData, List<Long> product, List<Long> productQuantity) {
        this.userData = userData;
        this.product = product;
        this.productQuantity = productQuantity;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public User getUserData() {
        return userData;
    }

    public void setUserData(User userData) {
        this.userData = userData;
    }

    public List<Long> getProduct() {
        return product;
    }

    public void setProduct(List<Long> product) {
        this.product = product;
    }

    public List<Long> getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(List<Long> productQuantity) {
        this.productQuantity = productQuantity;
    }
}
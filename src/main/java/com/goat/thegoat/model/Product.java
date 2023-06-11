package com.goat.thegoat.model;

import com.goat.thegoat.dto.ProductDTO;

import javax.persistence.*;
import java.util.List;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long productId;
    String productName;
    String productBrand;
    String productType;
    Integer productPrice;
    @ElementCollection
    @CollectionTable(name = "product_images", joinColumns = @JoinColumn(name = "product_id"))
    List<String> productImage;
    String productDescription;
    Integer productQuantity;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public List<String> getProductImage() {
        return productImage;
    }

    public void setProductImage(List<String> productImage) {
        this.productImage = productImage;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public Product(Long productId, String productName, String productBrand, String productType, Integer productPrice, List<String> productImage, String productDescription, Integer productQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.productBrand = productBrand;
        this.productType = productType;
        this.productPrice = productPrice;
        this.productImage = productImage;
        this.productDescription = productDescription;
        this.productQuantity = productQuantity;
    }
    public Product(ProductDTO productDTO) {
        this.productName = productDTO.getProductName();
        this.productBrand = productDTO.getProductBrand();
        this.productType = productDTO.getProductType();
        this.productPrice = productDTO.getProductPrice();
        this.productImage = productDTO.getProductImage();
        this.productDescription = productDTO.getProductDescription();
        this.productQuantity = productDTO.getProductQuantity();
    }

    public Product() {
    }
    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }
}

package com.goat.thegoat.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductDTO {
    String productName;
    String productBrand;
    String productType;
    Integer productPrice;
    List<String> productImage;
    String productDescription;
    Integer productQuantity;

    public ProductDTO() {
    }

    public ProductDTO(String productName, String productBrand, String productType, Integer productPrice, List<String> productImage, String productDescription, Integer productQuantity) {
        this.productName = productName;
        this.productBrand = productBrand;
        this.productType = productType;
        this.productPrice = productPrice;
        this.productImage = productImage;
        this.productDescription = productDescription;
        this.productQuantity = productQuantity;
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
    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }
}

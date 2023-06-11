package com.goat.thegoat.service;

import com.goat.thegoat.dto.ProductDTO;
import com.goat.thegoat.model.Product;

import java.util.List;

public interface iProductService {
    public List<Product> getAllItem();
    public Product addProduct(ProductDTO productDTO);

    public List<Product> getAllProducts();

    public Product getproductByID(Long productId);

    public List<Product> getproductByproductName(String productName);
}

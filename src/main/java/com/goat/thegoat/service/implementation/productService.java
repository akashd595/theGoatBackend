package com.goat.thegoat.service.implementation;

import com.goat.thegoat.dto.ProductDTO;
import com.goat.thegoat.helper.CustomException;
import com.goat.thegoat.model.Product;
import com.goat.thegoat.repository.ProductRepository;
import com.goat.thegoat.service.iProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productService implements iProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllItem() {
        return null;
    }

    @Override
    public Product addProduct(ProductDTO productDTO) {
        Product product = new Product(productDTO);
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        if(productRepository.findAll() != null){
            return productRepository.findAll();
        }
        else{
            throw new CustomException("No Products Found");
        }
    }

    @Override
    public Product getproductByID(Long productId) {
        if (productRepository.findById(productId).isPresent()) {
            return productRepository.findById(productId).orElseThrow(() -> new CustomException("product not found"));
        } else {
            throw new CustomException("No product  Found with the product id: " + productId);
        }
    }

    @Override
    public List<Product> getproductByproductName(String productName) {
        if (!productRepository.getproductByproductName(productName).isEmpty()) {
            return productRepository.getproductByproductName(productName);
        } else {
            throw new CustomException("No product  Found with the name: " + productName);
        }
    }
}

package com.goat.thegoat.repository;

import com.goat.thegoat.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM product p WHERE p.product_name = :product_name", nativeQuery = true)
    List<Product> getproductByproductName(@Param("product_name") String product_name);
}

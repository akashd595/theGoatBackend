package com.goat.thegoat.repository;

import com.goat.thegoat.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query(value = "SELECT * FROM cart c WHERE c.id = :user_id", nativeQuery = true)
    Cart findCartByUserId(@Param("user_id") Long user_id);

    @Query(value = "SELECT * FROM cart c WHERE c.cart_id = :cart_id", nativeQuery = true)
    Cart findCartByCartId(@Param("cart_id") Long cart_id);
}

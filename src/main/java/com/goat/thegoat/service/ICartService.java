package com.goat.thegoat.service;

import com.goat.thegoat.dto.CartDTO;
import com.goat.thegoat.model.Cart;

public interface ICartService {
    public Cart addToCart(CartDTO cartDTO);

    public Cart getCartForUserId(Long userId);
}

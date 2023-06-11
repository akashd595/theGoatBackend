package com.goat.thegoat.service.implementation;

import com.goat.thegoat.dto.CartDTO;
import com.goat.thegoat.helper.CustomException;
import com.goat.thegoat.model.Cart;
import com.goat.thegoat.model.User;
import com.goat.thegoat.repository.CartRepository;
import com.goat.thegoat.repository.UserRepository;
import com.goat.thegoat.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class CartService implements ICartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Cart addToCart(CartDTO cartDTO) {
        System.out.println("inside addToCart");
        System.out.println(cartDTO.userId);
        System.out.println(cartDTO.quantity);
        System.out.println(cartDTO.productId);
        User user = userRepository.getReferenceById(cartDTO.userId);
        Cart cart = null;
        if ( user != null ) {
            cart = cartRepository.findCartByUserId(user.getId());
//            System.out.println(cart.getCartId());
            System.out.println("cartService 31");
            //if user has already a cart
            if(cart != null){
                System.out.println("cartService 35");
                System.out.println(cart.getCartId());
                System.out.println(cart.getProduct());
//                System.out.println(cart.getUserData());
                System.out.println(((Object)cart.getProduct()).getClass().getSimpleName());
                List<Long> productIdList = cart.getProduct();
                List<Long> quantities =  cart.getProductQuantity();
                productIdList.add(cartDTO.productId);
                quantities.add(cartDTO.getQuantity());
                cart = new Cart(cart.getCartId(), user, productIdList, quantities);

            }else{
                //if user has no cart
                System.out.println("cartService 47");
                List<Long> productIdList = new ArrayList<Long>() ;
                List<Long> quantities = new ArrayList<Long>();
                productIdList.add(cartDTO.productId);
                quantities.add(cartDTO.getQuantity());
                cart = new Cart( user, productIdList, quantities);
            }
        }
        System.out.println("cartService 55");
        System.out.println(cart.getUserData());
        System.out.println(cart.getCartId());
        return cartRepository.save(cart);
    }
    public Cart getCartForUserId(Long userId){
        System.out.println("cartService 55");
        Cart cart = null;
        if(userId != null){
            System.out.println("cartService 58");
            cart = cartRepository.findCartByUserId(userId);
            System.out.println("cart details");
            System.out.println(cart.getCartId());
            System.out.println(cart.getProduct());
            System.out.println(cart.getUserData());
        }else{
            System.out.println("cartService 61");
            throw new CustomException("cart is not available for the user ");
        }

        return cart;
    }
}

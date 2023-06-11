package com.goat.thegoat.controller;

import com.goat.thegoat.dto.CartDTO;
import com.goat.thegoat.dto.ResponseDTO;
import com.goat.thegoat.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private ICartService iCartService;
    @PostMapping("/addProductToCart")
    public ResponseEntity<ResponseDTO> createUser(@RequestBody CartDTO cartDTO){
        ResponseDTO responseDTO = new ResponseDTO("product added to cart Successfully", iCartService.addToCart ( cartDTO ));
        return new ResponseEntity<>( responseDTO, HttpStatus.CREATED );
    }
    @GetMapping("/get-cart/{userId}")
    public ResponseEntity<ResponseDTO> getCart(@PathVariable Long userId){
        ResponseDTO responseDTO = new ResponseDTO("cart found Successfully", iCartService.getCartForUserId ( userId ));
        return new ResponseEntity<>( responseDTO, HttpStatus.CREATED );
    }
}

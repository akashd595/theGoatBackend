package com.goat.thegoat.controller;

import com.goat.thegoat.dto.ProductDTO;
import com.goat.thegoat.dto.ResponseDTO;
import com.goat.thegoat.service.iProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private iProductService productService;
    @PostMapping("/addproduct")
    public ResponseEntity<ResponseDTO> createBook(@RequestBody ProductDTO productDTO){
        ResponseDTO responseDTO = new ResponseDTO("Product has been Added to the list", productService.addProduct(productDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    @GetMapping("/allProducts")
    public ResponseEntity<ResponseDTO> getAllProducts(){
        ResponseDTO responseDTO= new ResponseDTO("all Products at your doorstep", productService.getAllProducts());
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    @GetMapping("/getProductByID/{product_id}")
    public ResponseEntity<ResponseDTO> findProductByID( @PathVariable Long product_id){
        ResponseDTO responseDTO = new ResponseDTO("The product is Present in the product Store", productService.getproductByID( product_id));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
    @GetMapping("/getproductByName/{product_name}")
    public ResponseEntity<ResponseDTO> findproductByName( @PathVariable String product_name){
        ResponseDTO responseDTO = new ResponseDTO("The product is Present in the product  Store", productService.getproductByproductName( product_name));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}

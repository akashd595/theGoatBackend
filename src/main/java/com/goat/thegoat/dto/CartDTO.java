package com.goat.thegoat.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class CartDTO {
    public Long userId;
    public Long productId;
    public Long quantity;
    public CartDTO() {
        super();
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public Long getQuantity() {
        return quantity;
    }
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public CartDTO(Long userId, Long productId, Long quantity) {
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
    }
}

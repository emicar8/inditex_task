package com.inditex.task.controllers.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.inditex.task.models.Price;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceResponse {
    
    private Long productId;
    private Long brandId;
    private BigDecimal price;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime priceDate;

    public PriceResponse(Price price) {
        this.brandId = price.getBrandId();
        this.productId = price.getProductId();
        this.price = price.getPrice();
    }
}

package com.inditex.task.controllers.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inditex.task.models.Price;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PriceResponse {
    
    @JsonProperty("product_id")
    private Long productId;

    @JsonProperty("brand_id")
    private Long brandId;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("price_date")
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime priceDate;

    public PriceResponse(Price price) {
        this.brandId = price.getBrandId();
        this.productId = price.getProductId();
        this.price = price.getPrice();
    }
}

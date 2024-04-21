package com.inditex.task.models.builders;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.inditex.task.models.Price;

public class PriceBuilder {

    private Long id;
    private Long productId;
    private Long brandId;
    private BigDecimal price;
    private String currency;
    private Long priority;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public PriceBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public PriceBuilder productId(Long productId) {
        this.productId = productId;
        return this;
    }
    
    public PriceBuilder brandId(Long brandId) {
        this.brandId = brandId;
        return this;
    }

    public PriceBuilder price(BigDecimal price) {
        this.price = price;
        return this;
    }
    
    public PriceBuilder currency(String currency) {
        this.currency = currency;
        return this;
    }

    public PriceBuilder priority(Long priority) {
        this.priority = priority;
        return this;
    }

    public PriceBuilder startDate(LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public PriceBuilder endDate(LocalDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    public Price build() {
        return new Price(this.id, this.productId, this.brandId, this.price, this.currency, this.priority, this.startDate, this.endDate);
    }
}

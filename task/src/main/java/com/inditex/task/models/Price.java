package com.inditex.task.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Price {

    @Id
    private Long id;
    private Long productId;
    private Long brandId;
    private BigDecimal price;
    private String currency;
    private Long priority;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    
}
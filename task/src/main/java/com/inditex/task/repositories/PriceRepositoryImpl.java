package com.inditex.task.repositories;

import java.time.LocalDateTime;

import org.springframework.stereotype.Repository;

import com.inditex.task.models.Price;

import jakarta.persistence.EntityManager;

@Repository
public class PriceRepositoryImpl implements PriceRepository{

    private EntityManager entityManager;

    PriceRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Price findPriceByParams(LocalDateTime priceDate, Long brandId, Long productId) {
        System.out.println(priceDate);
        return entityManager.createQuery("SELECT p FROM Price p " +
        "WHERE p.startDate <= :priceDate " +
        "AND p.endDate >= :priceDate " +
        "AND p.brandId = :brandId " +
        "AND p.productId = :productId " +
        "ORDER BY p.priority DESC, p.price DESC " , Price.class)
        .setParameter("priceDate", priceDate)
        .setParameter("brandId", brandId)
        .setParameter("productId", productId)
        .setMaxResults(1)
        .getSingleResult();
    }
    
}

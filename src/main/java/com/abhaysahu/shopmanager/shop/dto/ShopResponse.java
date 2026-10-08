package com.abhaysahu.shopmanager.shop.dto;

import com.abhaysahu.shopmanager.shop.entity.Shop;

import java.time.OffsetDateTime;

public record ShopResponse(Long id,
                           String name,
                           String address,
                           OffsetDateTime createdAt) {
    public static ShopResponse from(Shop shop){
        return new ShopResponse(
                shop.getId(),
                shop.getName(),
                shop.getAddress(),
                shop.getCreatedAt()
        );
    }
}

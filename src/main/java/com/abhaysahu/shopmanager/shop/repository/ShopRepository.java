package com.abhaysahu.shopmanager.shop.repository;

import com.abhaysahu.shopmanager.shop.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ShopRepository extends JpaRepository<Shop,Long> {
}

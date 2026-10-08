package com.abhaysahu.shopmanager.shop.service;

import com.abhaysahu.shopmanager.shop.dto.ShopRequest;
import com.abhaysahu.shopmanager.shop.dto.ShopResponse;
import com.abhaysahu.shopmanager.shop.entity.Shop;
import com.abhaysahu.shopmanager.shop.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ShopService {
    private final ShopRepository repository;

    @Transactional
    public ShopResponse createShop(ShopRequest req){
        Shop createdShop= repository.save(mapToShop(req));
        return ShopResponse.from(createdShop);

    }
    private Shop mapToShop(ShopRequest req){
        Shop shop=new Shop();
        shop.setName(req.name());
        shop.setAddress(req.address());
        return shop;
    }

}

package com.abhaysahu.shopmanager.shop.controller;


import com.abhaysahu.shopmanager.shop.service.ShopService;
import com.abhaysahu.shopmanager.shop.dto.ShopRequest;
import com.abhaysahu.shopmanager.shop.dto.ShopResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/shops")
@RequiredArgsConstructor
public class ShopController {
    private final ShopService shopService;

    @PostMapping
    public ResponseEntity<ShopResponse> createShop(@Valid @RequestBody ShopRequest req){
        return ResponseEntity.status(HttpStatus.CREATED).body(shopService.createShop(req));
    }

}

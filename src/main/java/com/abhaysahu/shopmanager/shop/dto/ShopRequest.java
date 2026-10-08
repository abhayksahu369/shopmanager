package com.abhaysahu.shopmanager.shop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ShopRequest(
        @NotBlank(message = "shop name is required")
        @Size(max=100,message = "shop name must be at most 100 characters")
        String name,

        @Size(max=255,message = "address must be at most 255 characters")
        String address
){ }

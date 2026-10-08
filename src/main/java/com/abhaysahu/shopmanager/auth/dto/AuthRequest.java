package com.abhaysahu.shopmanager.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AuthRequest(

        @NotBlank(message = "name is required")
        @Size(max = 100, message = "name must be at most 100 characters")
        String userName,

        @NotBlank(message = "phone number is required")
        @Pattern(regexp = "^[6-9][0-9]{9}$",
                 message = "phone number must be 10 digits starting with 6-9")
        String phoneNumber,

        @NotBlank(message = "password is required")
        @Size(min = 6, max = 72, message = "password must be between 6 and 72 characters")
        String password,

        @Email(message = "email is not valid")
        @Size(max = 150, message = "email must be at most 150 characters")
        String email,

        @NotBlank(message = "shop name is required")
        @Size(max = 100, message = "shop name must be at most 100 characters")
        String shopName,

        @Size(max = 255, message = "shop address must be at most 255 characters")
        String shopAddress
) {}

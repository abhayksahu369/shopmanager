package com.abhaysahu.shopmanager.auth.service;

import com.abhaysahu.shopmanager.auth.dto.AuthRequest;
import com.abhaysahu.shopmanager.auth.dto.AuthResponse;
import com.abhaysahu.shopmanager.shop.entity.Shop;
import com.abhaysahu.shopmanager.shop.repository.ShopRepository;
import com.abhaysahu.shopmanager.user.entity.Role;
import com.abhaysahu.shopmanager.user.entity.User;
import com.abhaysahu.shopmanager.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final ShopRepository shopRepository;

    @Transactional
    public AuthResponse register(AuthRequest req){
        if (userRepository.existsByPhoneNumber(req.phoneNumber())) {
            throw new RuntimeException("will add specific exception later");
        }
        Shop shop=shopRepository.save(mapToShop(req));
        User user=userRepository.save(mapToUser(req,shop));
        return new AuthResponse(user.getId(), shop.getId());
    }

    private Shop mapToShop(AuthRequest req){
        return Shop.builder()
                .name(req.shopName())
                .address(req.shopAddress())
                .build();
    }

    private User mapToUser(AuthRequest req,Shop shop){
        return User.builder()
                .name(req.userName())
                .phoneNumber(req.phoneNumber())
                .email(req.email())
                .passwordHash(req.password())
                .role(Role.OWNER)
                .shop(shop)
                .build();
    }


}

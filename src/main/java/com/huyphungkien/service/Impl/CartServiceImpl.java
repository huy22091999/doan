package com.huyphungkien.service.Impl;

import com.huyphungkien.repository.CartItemRepository;
import com.huyphungkien.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartItemRepository cir;
}

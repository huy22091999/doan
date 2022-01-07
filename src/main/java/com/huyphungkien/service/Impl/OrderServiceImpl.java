package com.huyphungkien.service.Impl;

import com.huyphungkien.repository.CartItemRepository;
import com.huyphungkien.repository.OrderRepository;
import com.huyphungkien.service.CartService;
import com.huyphungkien.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository or;
}

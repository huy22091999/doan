package com.huyphungkien.service.Impl;

import com.huyphungkien.repository.CartItemRepository;
import com.huyphungkien.repository.CustomerRepository;
import com.huyphungkien.service.CartService;
import com.huyphungkien.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository cr;
}

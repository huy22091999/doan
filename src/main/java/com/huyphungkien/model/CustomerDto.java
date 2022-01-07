package com.huyphungkien.model;

import com.huyphungkien.entity.CartItem;
import com.huyphungkien.entity.Order;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

public class CustomerDto {
    private Long id;
    private String userName;
    private String passWord;
    private String phone;
    private List<CartItemDto> cartItems;
    private List<OrderDto> orders;
}

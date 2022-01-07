package com.huyphungkien.model;

import com.huyphungkien.entity.Order;
import com.huyphungkien.entity.Product;

import javax.persistence.*;
import java.io.Serializable;

public class OrderDetailDto  {

    private Long id;
    private int quantity;
    private Long price;
    private ProductDto product;
    private OrderDto order;
}

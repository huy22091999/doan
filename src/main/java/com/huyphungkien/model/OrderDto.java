package com.huyphungkien.model;

import com.huyphungkien.entity.Customer;
import com.huyphungkien.entity.OrderDetail;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class OrderDto {
    private Long id;
    private Date orderDate;
    private Date finishDate;
    private String phone;
    private String address;
    private String note;
    private String status;
    private List<OrderDetailDto> orderDetails;
    private CustomerDto customer;

}

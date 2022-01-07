package com.huyphungkien.model;

import com.huyphungkien.entity.Product;
import com.huyphungkien.entity.TypePro;

import javax.persistence.*;
import java.io.Serializable;
public class TypeDto  {

    private Long id;
    private String name;
    private Long price;
    private int quantity;
    public TypeDto(){}
    public TypeDto(TypePro entity){
        this.id=entity.getId();
        this.name=entity.getName();
        this.price=entity.getPrice();
        this.quantity=entity.getQuantity();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

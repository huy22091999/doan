package com.huyphungkien.model;

import com.huyphungkien.entity.Image;
import com.huyphungkien.entity.Product;
import org.hibernate.annotations.Type;

import javax.persistence.*;

public class ImageDto {
    private Long id;
    private String img;
    public ImageDto(){}
    public ImageDto(Image entity){
        this.id=entity.getId();
        this.img=entity.getImg();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}

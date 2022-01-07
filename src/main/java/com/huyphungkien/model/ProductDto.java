package com.huyphungkien.model;

import com.huyphungkien.entity.Category;
import com.huyphungkien.entity.Image;
import com.huyphungkien.entity.Product;
import com.huyphungkien.entity.TypePro;
import org.hibernate.annotations.Type;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductDto implements Serializable{
    private Long id;
    private String name;
    private int quantity;
    private String description;
    public CategoryDto category;
    private List<TypeDto> types;
    private List<ImageDto> images;
    private List<MultipartFile> files;
    public ProductDto(){}
    public ProductDto(Product entity){
        this.id=entity.getId();
        this.name=entity.getName();
        this.quantity=entity.getQuantity();
        this.description=entity.getDescription();
        this.category=new CategoryDto();
        if(entity.category!=null){
            this.category=new CategoryDto(entity.category);
        }
        if(entity.getImages()!=null&&entity.getImages().size()>0){
            this.images=new ArrayList<ImageDto>();
            for (Image p:entity.getImages()) {
                this.images.add(new ImageDto(p));
            }
        }
        if(entity.getTypes()!=null&&entity.getTypes().size()>0){
            this.types=new ArrayList<TypeDto>();
            for (TypePro t:entity.getTypes()) {
                this.types.add(new TypeDto(t));
            }
        }
    }
    public List<MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }

    public List<TypeDto> getTypes() {
        return types;
    }

    public void setTypes(List<TypeDto> types) {
        this.types = types;
    }

    public List<ImageDto> getImages() {
        return images;
    }

    public void setImages(List<ImageDto> images) {
        this.images = images;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }
}

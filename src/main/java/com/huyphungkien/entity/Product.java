package com.huyphungkien.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "tbl_product")
public class Product  implements Serializable{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;
    private String name;
    private int quantity;

    @Type(type = "text")
    private String description;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private Set<Image> images;

    @ManyToOne
    @JoinColumn(name = "id_category")
    public Category category;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private Set<TypePro> types;

    public Set<TypePro> getTypes() {
        return types;
    }

    public void setTypes(Set<TypePro> types) {
        this.types = types;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

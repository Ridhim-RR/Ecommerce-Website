package com.example.ecommerce.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Entity
@Data
public class Product extends BaseModel {
    String title;
    Double price;
    String description;
    String image;
    @ManyToOne
    Category category;
}

/*
1        :       1
Product ----> Category  =====> m:1
m           :     1
*/
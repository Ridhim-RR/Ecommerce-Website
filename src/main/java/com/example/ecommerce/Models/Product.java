package com.example.ecommerce.Models;

import lombok.Data;

@Data
public class Product {
    Long id;
    String title;
    Double price;
    String description;
    String image;
    Category category;
}

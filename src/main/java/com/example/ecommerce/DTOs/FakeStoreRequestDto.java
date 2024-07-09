package com.example.ecommerce.DTOs;

import lombok.Data;

@Data
public class FakeStoreRequestDto {
   private String title;
    private String description;
    private Double price;
    private String image;
    private String category;
}

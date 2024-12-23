package com.example.ecommerce.DTOs;

import lombok.Data;

@Data
public class FakeStoreResponseDto {
    private long id;
    private String title;
    private String description;
    private String image;
    private double price;
    private String category;
}

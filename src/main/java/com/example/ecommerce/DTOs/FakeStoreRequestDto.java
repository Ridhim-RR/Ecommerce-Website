package com.example.ecommerce.DTOs;

import lombok.Data;

import java.io.Serializable;

@Data
public class FakeStoreRequestDto  implements Serializable {
    private static final long serialVersionUID = 1L;
   private String title;
    private String description;
    private Double price;
    private String image;
    private String category;
}

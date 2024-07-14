package com.example.ecommerce.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.Date;
@MappedSuperclass
@Data
public class BaseModel {
    @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    Date createdAt;
    Date updatedAt;
}

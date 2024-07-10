package com.example.ecommerce.Models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.Date;
@MappedSuperclass
@Data
public class BaseModel {
    @Id
    Long Id;
    Date createdAt;
    Date updatedAt;
}

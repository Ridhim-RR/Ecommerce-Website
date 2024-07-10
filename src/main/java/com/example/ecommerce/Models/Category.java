package com.example.ecommerce.Models;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
public class Category extends BaseModel {
    String title;
}

package com.example.ecommerce.Models;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Entity
@Data
public class Category extends BaseModel implements Serializable {
    String title;
}

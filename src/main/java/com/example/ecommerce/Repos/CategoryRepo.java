package com.example.ecommerce.Repos;


import com.example.ecommerce.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
}

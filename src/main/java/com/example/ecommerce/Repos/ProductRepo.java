package com.example.ecommerce.Repos;

import com.example.ecommerce.Models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    @Override
    Optional<Product> findById(Long id);

  Optional<Product> findByTitle(String title);
//  Select *
//     FROM Product
//    Where title  = ""
Optional<Product> findByTitleAndDescription(String title, String description);

Product save(Product product);

void deleteProductById(Long id);

List<Product> findAll();

Page<Product> findAll(Pageable pageable);
}

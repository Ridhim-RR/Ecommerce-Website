package com.example.ecommerce.Services;

import com.example.ecommerce.DTOs.FakeStoreResponseDto;
import com.example.ecommerce.Models.Product;

public interface ProductService {
    public Product getProduct(Long id);
    public Product updateProduct(Long id, Product product);
    public void deleteProduct(Long id);
    public Product createProduct(Product product);
    public Product[] getAllProducts();
}

package com.example.ecommerce.Services;

import com.example.ecommerce.Exceptions.ProductNotFound;
import com.example.ecommerce.Models.Product;

public interface ProductService {
    public Product getProduct(Long id) throws ProductNotFound;
    public Product updateProduct(Long id, Product product) throws ProductNotFound;
    public Product deleteProduct(Long id) throws ProductNotFound;
    public Product createProduct(Product product);
    public Product[] getAllProducts() throws ProductNotFound;
}

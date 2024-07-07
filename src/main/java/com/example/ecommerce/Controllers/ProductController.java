package com.example.ecommerce.Controllers;

import com.example.ecommerce.DTOs.ProductRequestDto;
import com.example.ecommerce.DTOs.ProductResponseDto;
import com.example.ecommerce.Models.Product;
import com.example.ecommerce.Services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")

public class ProductController {
ProductService productService;

public ProductController(ProductService productService) {
    this.productService = productService;
}
 @GetMapping("/{id}")
    public Product getProduct(@PathVariable long id) {
    return this.productService.getProduct(id);
    }
    @PostMapping("/")
    public Product createProduct(@RequestBody Product product) {
        return new Product();
    }
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
    return new Product();
    }
    @DeleteMapping("/delete")
    public void deleteProduct(@RequestBody Product product) {
        System.out.println("Product deleted");
    }

}

package com.example.ecommerce.Controllers;

import com.example.ecommerce.DTOs.ProductRequestDto;
import com.example.ecommerce.DTOs.ProductResponseDto;
import com.example.ecommerce.Exceptions.ProductNotFound;
import com.example.ecommerce.Models.Product;
import com.example.ecommerce.Services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {
ProductService productService;

public ProductController(@Qualifier("SelfProductService") ProductService productService) {
    this.productService = productService;
}
 @GetMapping("/{id}")
    public Product getProduct(@PathVariable long id) throws ProductNotFound {
    return this.productService.getProduct(id);
    }
    @GetMapping("/all")
    public List<Product> getAllProducts() throws ProductNotFound {
    return List.of(this.productService.getAllProducts());
    }
    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product) {
        return this.productService.createProduct(product);
    }
    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable long id, @RequestBody Product product) throws ProductNotFound {
    return this.productService.updateProduct(id,product);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable long id) throws ProductNotFound {
    this.productService.deleteProduct(id);
        System.out.println("Product deleted");
    }

}

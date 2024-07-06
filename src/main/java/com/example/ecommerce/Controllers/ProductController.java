package com.example.ecommerce.Controllers;

import com.example.ecommerce.Models.Product;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
 @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return  new Product();
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

package com.example.ecommerce.Controllers;

import com.example.ecommerce.Common.AuthCommon;
import com.example.ecommerce.Exceptions.ProductNotFound;
import com.example.ecommerce.Models.Product;
import com.example.ecommerce.Services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")

public class ProductController {
    private  AuthCommon authCommon;
   private ProductService productService;

public ProductController(@Qualifier("FakeStore") ProductService productService, AuthCommon authCommon) {
    this.productService = productService;
    this.authCommon = authCommon;
}
 @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") long id) throws ProductNotFound {
// public ResponseEntity<Product> getProduct(@PathVariable("id") long id , @RequestHeader("Auth") String auth) throws ProductNotFound, UserNotAuthenticated {
//    UserDto user = authCommon.validate(auth);
//   if(user == null) {
//       throw new UserNotAuthenticated("Token is not valid");
//   }
     Product p = productService.getProduct(id);
         return new ResponseEntity<>(p, HttpStatus.OK);
    }
    @GetMapping("/all")
    public Page<Product> getAllProducts(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize) throws ProductNotFound {
        return  productService.getAllProducts(pageNumber,pageSize);
    }
    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product) {
     System.out.println(product);
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

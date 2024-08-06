package com.example.ecommerce.Controllers;

import com.example.ecommerce.Exceptions.ProductNotFound;
import com.example.ecommerce.Models.Product;
import com.example.ecommerce.Services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

//@SpringBootTest
//class ProductControllerTest {
//    @Autowired
//private ProductController productController;
//    @MockBean
//private ProductService productService;
//    @Test
//    void TestGetProductById() throws ProductNotFound {
//    Product p = new Product();
//    p.setId(1L);
//    when(productService.getProduct(1l)).thenReturn(p);
//        ResponseEntity<Product> ExpectedresponseEntity = new ResponseEntity<>(p, HttpStatus.OK);
//        ResponseEntity<Product> actualResponse = productController.getProduct(1l);
//        assertEquals(ExpectedresponseEntity, actualResponse);
//    }
//}
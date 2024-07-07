package com.example.ecommerce.Services;

import com.example.ecommerce.DTOs.FakeStoreResponseDto;
import com.example.ecommerce.Models.Categories;
import com.example.ecommerce.Models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class FakeStoreProductService implements ProductService {
    private RestTemplate restTemplate;

    FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public Product getProduct(Long id) {
        FakeStoreResponseDto fDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreResponseDto.class);
         if(fDto == null){
         return null;
         }
        return convertFakeStoreResponseDtoToProduct(fDto);
    }
    public Product convertFakeStoreResponseDtoToProduct(FakeStoreResponseDto fDto){
        Product product = new Product();
        product.setId(fDto.getId());
        product.setDescription(fDto.getDescription());
        product.setPrice(fDto.getPrice());
        product.setImage(fDto.getImage());
        product.setTitle(fDto.getTitle());
        Categories c = new Categories();
        c.setTitle(fDto.getCategory());
        return product;
    }
    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long id) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }
}

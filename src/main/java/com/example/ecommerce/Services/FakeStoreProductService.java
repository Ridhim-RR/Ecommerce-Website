package com.example.ecommerce.Services;

import com.example.ecommerce.DTOs.FakeStoreRequestDto;
import com.example.ecommerce.DTOs.FakeStoreResponseDto;
import com.example.ecommerce.Models.Category;
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

    @Override
    public Product[] getAllProducts() {
        FakeStoreResponseDto[] fDto = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreResponseDto[].class);
        if(fDto == null){
            return null;
        }
        Product[] products = new Product[fDto.length];
        for(int i=0; i<fDto.length; i++){
          products[i] = convertFakeStoreResponseDtoToProduct(fDto[i]);
        }
        return products;
    }

    @Override
    public Product createProduct(Product product) {
    FakeStoreRequestDto requestDto = convertProductToFakeStoreRequestDto(product);
    FakeStoreResponseDto responseDto = restTemplate.postForObject("https://fakestoreapi.com/products", requestDto, FakeStoreResponseDto.class);
    if(responseDto == null){
        return null;
    }
    Product res = convertFakeStoreResponseDtoToProduct(responseDto);
        return res;
    }

    @Override
    public Product updateProduct(Long id,Product product) {
        FakeStoreRequestDto requestDto = convertProductToFakeStoreRequestDto(product);
        restTemplate.put("https://fakestoreapi.com/products/"+id,requestDto);

      return product;
    }

    @Override
    public void deleteProduct(Long id) {
        restTemplate.delete("https://fakestoreapi.com/products/"+id);

    }

    public Product convertFakeStoreResponseDtoToProduct(FakeStoreResponseDto fDto){
        Product product = new Product();
        product.setId(fDto.getId());
        product.setDescription(fDto.getDescription());
        product.setPrice(fDto.getPrice());
        product.setImage(fDto.getImage());
        product.setTitle(fDto.getTitle());
        Category c = new Category();
        c.setTitle(fDto.getCategory());
        product.setCategory(c);
        return product;
    }

    public FakeStoreRequestDto convertProductToFakeStoreRequestDto(Product product){
        FakeStoreRequestDto fDto = new FakeStoreRequestDto();
        fDto.setTitle(product.getTitle());
        fDto.setDescription(product.getDescription());
        fDto.setPrice(product.getPrice());
        fDto.setImage(product.getImage());
        fDto.setCategory(product.getCategory().getTitle());
        return fDto;
    }

}

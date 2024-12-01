package com.example.ecommerce.Services;

import com.example.ecommerce.DTOs.FakeStoreRequestDto;
import com.example.ecommerce.DTOs.FakeStoreResponseDto;
import com.example.ecommerce.Exceptions.ProductNotFound;
import com.example.ecommerce.Models.Category;
import com.example.ecommerce.Models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service("FakeStore")
public class FakeStoreProductService implements ProductService {
    private RestTemplate restTemplate;
    private RedisTemplate redisTemplate;

    FakeStoreProductService(RestTemplate restTemplate, RedisTemplate redisTemplate){
        this.restTemplate = restTemplate;
        this.redisTemplate = redisTemplate;
    }
    @Override
    public Product getProduct(Long id) throws ProductNotFound {
           Product p = (Product) redisTemplate.opsForHash().get("PRODUCTS", "PRODUCT_"+ id);
       if(p != null){
//           Cache hit:
           return p;
       }

        FakeStoreResponseDto fDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreResponseDto.class);
         if(fDto == null){
         throw new ProductNotFound("No product found with id "+id);
         }
//         Cache Miss:
//        Put in the Cache:
        p =  convertFakeStoreResponseDtoToProduct(fDto);
        redisTemplate.opsForHash().put("PRODUCTS", "PRODUCT_" + id,p);
      return p;
    }

    @Override
    public Page<Product> getAllProducts(int pageNumber, int pageSize) {
        FakeStoreResponseDto[] fDto = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreResponseDto[].class);
        if(fDto == null){
            return  Page.empty();
        }
        Product[] products = new Product[fDto.length];
        for(int i=0; i<fDto.length; i++){
          products[i] = convertFakeStoreResponseDtoToProduct(fDto[i]);
        }
        int start = pageNumber * pageSize;
        int end = Math.min(start + pageSize, products.length);

        // Create a subarray for the requested page
        Product[] paginatedProducts = new Product[end - start];
        if (start < products.length) {
            System.arraycopy(products, start, paginatedProducts, 0, end - start);
        }

        // Create and return a Page object
        return new PageImpl<>(Arrays.asList(paginatedProducts), PageRequest.of(pageNumber, pageSize), products.length);
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
    public Product updateProduct(Long id,Product product) throws ProductNotFound {
        FakeStoreRequestDto requestDto = convertProductToFakeStoreRequestDto(product);
        restTemplate.put("https://fakestoreapi.com/products/"+id,requestDto);

      return product;
    }

    @Override
    public Product deleteProduct(Long id) {
        restTemplate.delete("https://fakestoreapi.com/products/"+id);

        return null;
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

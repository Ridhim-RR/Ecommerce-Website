package com.example.ecommerce.Services;

import com.example.ecommerce.Exceptions.ProductNotFound;
import com.example.ecommerce.Models.Category;
import com.example.ecommerce.Models.Product;
import com.example.ecommerce.Repos.CategoryRepo;
import com.example.ecommerce.Repos.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Primary
@Service
@Qualifier("SelfProductService")
public class SelfProductService implements ProductService{
    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;
    public SelfProductService(ProductRepo productRepo, CategoryRepo categoryRepo){
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }

    public Product getProduct(Long id) throws ProductNotFound{
      Optional<Product> product = productRepo.findById(id);
      if(product.isEmpty()){
          throw new ProductNotFound("Product not found");
      }
        return product.get();
    }

    public Product updateProduct(Long id, Product product) throws ProductNotFound{
        Optional<Product> existingProductOpt = productRepo.findById(id);
        if(existingProductOpt.isEmpty()){
            throw new ProductNotFound("Product not found!");
        }
      Product existingProduct =  existingProductOpt.get();
     existingProduct.setTitle(product.getTitle());
     existingProduct.setPrice(product.getPrice());
     existingProduct.setDescription(product.getDescription());
     existingProduct.setImage(product.getImage());
     Category category = product.getCategory();
     if(category != null){
         if(category.getId() == null){
//             If the category doesn't have an Id then save it as a new category::
             Category newCategory = categoryRepo.save(category);
             existingProduct.setCategory(newCategory);
         }else{
//             If the category has an id then associate it with the product:
            Optional<Category> existingCategory = categoryRepo.findById(category.getId());
            if(existingCategory.isEmpty()){
                throw new ProductNotFound("Category not found");
            }
            existingProduct.setCategory(existingCategory.get());
         }
     }else{
//         If category is null set it to null::
         existingProduct.setCategory(null);
     }
      return  productRepo.save(existingProduct);
    }

    @Transactional
    public Product deleteProduct(Long id) throws ProductNotFound{
//        Here we will be only deleting a product only not hr category long with it.
        Optional<Product> productOpt = productRepo.findById(id);
        if(productOpt.isEmpty()){
            throw new ProductNotFound("Product not found");
        }
        productRepo.deleteProductById(id);
        return null;
    }

    public Product createProduct(Product product){
        Category category = product.getCategory();
        if(category.getId() == null){
            Category saveCategory = categoryRepo.save(category);
            product.setCategory(saveCategory);
        }
        return productRepo.save(product);
    }

    public Product[] getAllProducts() throws ProductNotFound{
     List<Product> products = productRepo.findAll();
     if (products.isEmpty()) {
         throw new ProductNotFound("No products are available");
     }
     Product[] productArray = new Product[products.size()];
     products.toArray(productArray);
        return productArray;
    }
}

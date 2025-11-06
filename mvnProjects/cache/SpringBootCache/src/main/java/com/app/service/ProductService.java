package com.app.service;

import com.app.entity.Product;
import com.app.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Cacheable(value = "products") // save result in cache
    public Optional<Product> getProductById(Long id) {
        System.out.println("Fetching product from database...");
        return productRepository.findById(id);
    }

//    @CachePut(value = "products", key = "#product.id") // update result in cache
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @CacheEvict(value = "products") // delete value from cache
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

}

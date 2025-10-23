package com.shop.service.impl;

import com.shop.dto.PageResponse;
import com.shop.dto.ProductDto;
import com.shop.entity.Product;
import com.shop.entity.ProductCount;
import com.shop.exception.ProductNotFoundException;
import com.shop.repository.ProductRepository;
import com.shop.repository.specification.ProductSpecification;
import com.shop.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> getProducts(Pageable page) {
        return  productRepository.findAll(page);
    }

    @Override
    public PageResponse<Product> getProductsPageRequest(Pageable page) {
        Page<Product> all = productRepository.findAll(page);
        return new PageResponse<>(all.getContent(), all.getNumber(),
            all.getSize(), all.getTotalElements(), all.getTotalPages());
    }

    @Override
    public Long addProduct(ProductDto product) {
        Product productEntity = new Product().setName(product.getName()).setPrice(product.getPrice());
        return productRepository.save(productEntity).getId();
    }

    @Override
    public Product getProductById(Long id) {
        log.info("getProductById - from DB");
        return productRepository.findById(id)
            .orElseThrow(() -> new ProductNotFoundException("COULD NOT FOUND PRODUCT"));
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductCount> getProductStatistic() {
        return productRepository.calculateProductsCount();
    }

    @Override
    public List<Product> findProductsByName(String name) {
        return productRepository.findAllByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Product> findProductsBy(String text, Double min, Double max) {
        return productRepository.findAll(
            ProductSpecification.build(text, min, max));
    }
}

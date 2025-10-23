package com.shop.service;

import com.shop.dto.PageResponse;
import com.shop.dto.ProductDto;
import com.shop.entity.Product;
import com.shop.entity.ProductCount;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    List<Product> getProducts();

    Page<Product> getProducts(Pageable page);

    PageResponse<Product> getProductsPageRequest(Pageable page);

    Long addProduct(ProductDto product);

    Product getProductById(Long id);

    List<ProductCount> getProductStatistic();

    List<Product> findProductsByName(String name);

    List<Product> findProductsBy(String text, Double min, Double max);

}

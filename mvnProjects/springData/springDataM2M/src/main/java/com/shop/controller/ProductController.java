package com.shop.controller;

import com.shop.dto.PageResponse;
import com.shop.dto.ProductDto;
import com.shop.entity.Product;
import com.shop.entity.ProductCount;
import com.shop.service.ProductService;
import com.shop.service.impl.ProductServiceImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductServiceImpl service;

    @GetMapping
    public List<Product> getProducts() {
        log.info("Run method get all products - list");
        return service.getProducts();
    }

    @GetMapping("/page")
    public Page<Product> getPageProducts(@RequestParam int page, @RequestParam int size) {
        log.info("Run method get all products page");
        return service.getProducts(PageRequest.of(page, size));
    }

    @GetMapping("/paggination")
    public PageResponse<Product> getProductsPaggination(Pageable pageable) {
        log.info("Run method get all products - custom page response");
        return service.getProductsPageRequest(pageable);
    }

    @PostMapping
    public Long addNewProduct(@RequestBody ProductDto product){
        log.info("Run method add new product");
        return service.addProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        log.info("Run method get product by id");
        return service.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        log.info("Run method delete product by id");
         service.deleteProduct(id);
    }


    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        log.info("Update product");
        return service.saveProduct(product);
    }

    @GetMapping("/statistic")
    public List<ProductCount> getProductStatistic() {
        log.info("Run method get product by id");
        return service.getProductStatistic();
    }

    @GetMapping("/search")
    public List<Product> findProductsByName(@RequestParam String name) {
        log.info("Run method find products by name");
        return service.findProductsByName(name);
    }

    @GetMapping("/findby")
    public List<Product> findProductsB(
        @RequestParam(required = false) String name,
        @RequestParam(required = false) Double min,
        @RequestParam(required = false) Double max) {
        return service.findProductsBy(name, min, max);
    }
}

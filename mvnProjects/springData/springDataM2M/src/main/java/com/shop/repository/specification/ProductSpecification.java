package com.shop.repository.specification;

import com.shop.entity.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {

    public static Specification<Product> hasName(String name) {
        return (root, query, criteriaBuilder) ->
            name == null || name.isEmpty()
                ? criteriaBuilder.conjunction()
                : criteriaBuilder.like(
                    criteriaBuilder.lower(root.get("name")),
                    "%" + name.toLowerCase() + "%"
                );
    }

    public static Specification<Product> priceBetween(Double minPrice, Double maxPrice) {
        return (root, query, criteriaBuilder) -> {
            if (minPrice != null && maxPrice != null) {
                return criteriaBuilder.between(root.get("price"), minPrice, maxPrice);
            } else if (minPrice != null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
            } else if (maxPrice != null) {
                return criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
            } else {
                return criteriaBuilder.conjunction();
            }
        };
    }

    public static Specification<Product> build(String name, Double minPrice, Double maxPrice) {
        return Specification.where(hasName(name))
            .and(priceBetween(minPrice, maxPrice));
    }
}

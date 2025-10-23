package com.shop.repository;

import com.shop.entity.Product;
import com.shop.entity.ProductCount;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    String QUERY = """
        select pr.name, COUNT(b.id) as count from product pr
              left join purchase p on pr.id = p.product_id
              left join basket b on b.id = p.basket_id
                group by pr.id having COUNT(b.id) > 0                  
    """;
    @Query(value = QUERY, nativeQuery = true )
    List<ProductCount> calculateProductsCount();

    List<Product> findAllByIdIn(List<Long> products);

    List<Product> findAllByNameContainingIgnoreCase(String name);


}

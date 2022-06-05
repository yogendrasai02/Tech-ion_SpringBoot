package com.techion.techion.repository;

import com.techion.techion.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // SELECT * from product WHERE UPPER(productName) LIKE UPPER('%<givenName>%');
    public List<Product> findByNameContainingIgnoreCase(String name);

}

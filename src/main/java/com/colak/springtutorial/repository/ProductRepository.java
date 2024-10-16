package com.colak.springtutorial.repository;

import com.colak.springtutorial.jpa.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.stream.Stream;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value="SELECT p from Product p where p.description= :description")
    Stream<Product> findByDescription(@Param("description") String description);
}

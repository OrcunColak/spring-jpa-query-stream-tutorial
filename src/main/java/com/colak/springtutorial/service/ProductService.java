package com.colak.springtutorial.service;

import com.colak.springtutorial.jpa.Product;
import com.colak.springtutorial.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    private final EntityManager entityManager;

    @Transactional(readOnly = true)
    public void findByDescription(String description) {
        try (Stream<Product> productStream = productRepository.findByDescription(description)) {
            productStream.forEach(product -> {
                log.info(product.getName());

                entityManager.clear();
            });
        }
    }

}

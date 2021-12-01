package com.example.campinggearstore.repository;

import com.example.campinggearstore.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<ProductEntity, String> {
    Page<ProductEntity> findAll(Pageable pageable);
    Optional<ProductEntity> findById(String Id);
    @Query(value = "{}", count = true)
    Integer countAllProducts();
}
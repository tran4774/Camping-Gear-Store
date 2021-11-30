package com.example.campinggearstore.service.Impl;

import com.example.campinggearstore.entity.ProductEntity;
import com.example.campinggearstore.repository.ProductRepository;
import com.example.campinggearstore.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    public List<ProductEntity> saveListProducts(List<ProductEntity> listProducts) {
        return productRepository.saveAll(listProducts);
    }
}

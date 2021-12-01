package com.example.campinggearstore.service.Impl;

import com.example.campinggearstore.entity.ProductEntity;
import com.example.campinggearstore.repository.ProductRepository;
import com.example.campinggearstore.service.IProductService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductEntity getProductById(String Id) {
        return productRepository.findById(Id).orElse(null);
    }

    @Override
    public List<ProductEntity> getProductsPageable(Integer page, Integer size) {
        return productRepository.findAll(PageRequest.of(page, size)).getContent();
    }

    @Override
    public List<ProductEntity> saveListProducts(List<ProductEntity> listProducts) {
        return productRepository.saveAll(listProducts);
    }

    @Override
    public Integer countAllProducts() {
        return productRepository.countAllProducts();
    }
}

package com.example.campinggearstore.service;

import com.example.campinggearstore.entity.ProductEntity;
import java.util.List;

public interface IProductService {
    List<ProductEntity> getProductsPageable(Integer page, Integer size);
    List<ProductEntity> saveListProducts(List<ProductEntity> listProducts);
    Integer countAllProducts();
}

package com.example.campinggearstore.entity.user.embedded;

import com.example.campinggearstore.entity.ProductEntity;
//import dev.morphia.annotations.Entity;
//import dev.morphia.annotations.Property;
//import dev.morphia.annotations.Reference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private Float delivery;
    private Float total;
    @DBRef(lazy = true)
    private List<ProductEntity> listProducts;
}

package com.example.campinggearstore.entity.category.embedded;

import com.example.campinggearstore.entity.ProductEntity;
//import dev.morphia.annotations.Entity;
//import dev.morphia.annotations.Property;
//import dev.morphia.annotations.Reference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubCategory implements Serializable {
    @Field(value = "categoryName")
    private String subCategoryName;
    @Field(value = "listProducts")
    @DBRef
    private List<ProductEntity> listProducts;
}

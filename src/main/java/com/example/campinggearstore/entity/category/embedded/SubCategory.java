package com.example.campinggearstore.entity.category.embedded;

import com.example.campinggearstore.entity.ProductEntiry;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Property;
import dev.morphia.annotations.Reference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SubCategory implements Serializable {
    private String subCategoryName;
    @Property
    @Reference
    private List<ProductEntiry> listProducts;
}

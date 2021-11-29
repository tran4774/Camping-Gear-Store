package com.example.campinggearstore.entity.user.embedded;

import com.example.campinggearstore.entity.ProductEntiry;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Property;
import dev.morphia.annotations.Reference;
import dev.morphia.mapping.experimental.MorphiaReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cart {
    private float delivery;
    private float total;
    @Property
    @Reference(lazy = true)
    private List<ProductEntiry> listProducts;
}

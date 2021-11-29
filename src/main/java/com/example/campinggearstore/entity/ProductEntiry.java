package com.example.campinggearstore.entity;

import com.example.campinggearstore.entity.product.embedded.Color;
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
public class ProductEntiry extends BaseEntity implements Serializable {
    private String productName;
    private String Branch;
    private List<Float> prices;
    private List<Float> sales;
    private List<String> sizes;
    @Property
    @Reference
    private List<Color> colors;
    private String description;
}

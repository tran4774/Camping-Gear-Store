package com.example.campinggearstore.entity;

import com.example.campinggearstore.entity.product.embedded.Color;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
public class ProductEntity extends BaseEntity implements Serializable {
    @Field(value = "productName")
    private String productName;
    @Field(value = "branch")
    private String branch;
    @Field(value = "prices")
    private List<Float> prices;
    @Field(value = "sales")
    private List<Float> sales;
    @Field(value = "sizes")
    private List<String> sizes;
    @Field(value = "colors")
    private List<Color> colors;
    @Field(value = "description")
    private String description;
}

package com.example.campinggearstore.entity.product.embedded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Color {
    @Field(value = "quantity")
    private Integer quantity;
    @Field(value = "colorName")
    private String colorName;
    @Field(value = "imageUrl")
    private List<String> imageUrl;
}

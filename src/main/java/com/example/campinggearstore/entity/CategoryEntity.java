package com.example.campinggearstore.entity;

import com.example.campinggearstore.entity.category.embedded.SubCategory;
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
@Document(collection = "categories")
public class CategoryEntity extends BaseEntity implements Serializable {
    @Field(value = "categoryName")
    private String categoryName;
    @Field(value = "subCategories")
    private List<SubCategory> subCategories;
}
